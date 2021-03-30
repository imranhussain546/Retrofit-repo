package com.imran.finhealcapital.Modelclass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryList
{
    @SerializedName("TagId")
    @Expose
    private Integer tagId;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("IsImage")
    @Expose
    private Integer isImage;
    @SerializedName("Path")
    @Expose
    private String path;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getIsImage() {
        return isImage;
    }

    public void setIsImage(Integer isImage) {
        this.isImage = isImage;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
