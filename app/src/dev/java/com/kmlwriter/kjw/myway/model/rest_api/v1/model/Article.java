package com.kmlwriter.kjw.myway.model.rest_api.v1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kjw on 2017. 12. 5..
 */

/**
 * @TODO inheritance 지원 안함, retrofit Serialization할 class랑 Realm Model 따로 생성
 */

public class Article implements Serializable{
    private String Kml_Uri;
    private String Contents;
    private int Like;
    private String Like_Persons;
    private ArrayList<String> Images;
    private int Publish_range;
    private ArrayList<ArticleItem>Article_List;
    private ArrayList<String>Comments;

    @SerializedName("PostedBy")
    @Expose
    private PostedBy postedBy;

    private Date CreatedAt;
    private Date UpdatedAt;
    private int viewType;


    public Article(int viewType) {
//        super(viewType);
        setViewType(viewType);
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public ArrayList<String> getFilesURI(){
        ArrayList<String> getFilesURI = new ArrayList<>();
        if(this.Kml_Uri != null && (!(this.Kml_Uri.isEmpty()))){
            getFilesURI.add(Kml_Uri);
        }
        getFilesURI.addAll(Images);
        return getFilesURI;
    }

    public String getKml_Uri() {
        return Kml_Uri;
    }

    public String getContents() {
        return Contents;
    }

    public int getLike() {
        return Like;
    }

    public String getLike_Persons() {
        return Like_Persons;
    }

    public ArrayList<String> getImages() {
        return Images;
    }

    public int getPublish_range() {
        return Publish_range;
    }

    public ArrayList<ArticleItem> getArticle_List() {
        return Article_List;
    }

    public ArrayList<String> getComments() {
        return Comments;
    }

    public PostedBy getPostedBy() {
        return postedBy;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    @Override
    public String toString() {
        return "Article{" +
                "Kml_Uri='" + Kml_Uri + '\'' +
                ", Contents='" + Contents + '\'' +
                ", Like=" + Like +
                ", Like_Persons='" + Like_Persons + '\'' +
                ", Images=" + Images +
                ", Publish_range=" + Publish_range +
                ", Article_List=" + Article_List +
                ", Comments=" + Comments +
                ", postedBy=" + postedBy +
                ", CreatedAt=" + CreatedAt +
                ", UpdatedAt=" + UpdatedAt +
                ", viewType=" + viewType +
                '}';
    }
}
