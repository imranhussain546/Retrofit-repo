package com.imran.finhealcapital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.imran.finhealcapital.Modelclass.CategoryList;
import com.imran.finhealcapital.Modelclass.Setdata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {
private RecyclerView recycler;
private String token="CfDJ8GOTD2sKL4lIuGUqiFtjEd4+syAPWfFSFHvvhAV2iGjIIRvSZpbeV2kwi2SZd+Z9NTIwVsi9Paa5lYy5w8Snqioph09JVUKJjpaUfXtbmJ8mUPWQoBJupPN0mMFXJAdviCvC9ouhAUzwgmHu1WlvXf7Jq3wqkSsMQ/Cz0tce+WqNEh34xbqbaDF49YTVJQfxfkQ6H2tHAGrbspmEGhOK9528EeK2MZk+2vd9mOVqyWyJ";
private List<CategoryList> list = new ArrayList<>();
private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler=findViewById(R.id.recyclerVideos);
        showdata();

    }

    private void showdata()
    {
        Call<Setdata> call=RetrofitClient.getApi().getData("bearer "+token);

        call.enqueue(new Callback<Setdata>() {
            @Override
            public void onResponse(Call<Setdata> call, Response<Setdata> response)
            {
                if (response.isSuccessful())
                {
                    Log.d("TAG", "onResponse: "+response.body().getData().getCategoryList());

                    list=response.body().getData().getCategoryList();
                    configurarRecyclerView();


                }
            }

            @Override
            public void onFailure(Call<Setdata> call, Throwable t)
            {
                Log.e("responseerror",t.toString());
            }
        });
    }

    private void configurarRecyclerView()
    {
        adapter = new Adapter(list,this);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        recycler.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        this,
                        recycler,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                String idVideo = list.get(position).getPath();

                                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                                intent.putExtra("idVideo", idVideo);
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            }
                        }
                )
        );
    }
}