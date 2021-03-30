package com.imran.finhealcapital.Modelclass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data
{
    @SerializedName("CategoryList")
    @Expose
    private List<CategoryList> categoryList = null;

    public List<CategoryList> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryList> categoryList) {
        this.categoryList = categoryList;
    }
}
