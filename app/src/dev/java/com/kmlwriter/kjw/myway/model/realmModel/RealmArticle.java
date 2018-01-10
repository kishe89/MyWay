package com.kmlwriter.kjw.myway.model.realmModel;

import java.util.ArrayList;
import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by kjw on 2017. 12. 5..
 */

/**
 * @TODO inheritance 지원 안함, retrofit Serialization할 class랑 Realm Model 따로 생성
 */

public class RealmArticle extends RealmObject{
    private String Kml_Uri;
    private String Contents;
    private int Like;
    private String Like_Persons;
    private RealmList<String> Images;
    private int Publish_range;
    private RealmList<String> Article_List;
    private RealmList<String>Comments;
    private RealmPostedByUser PostedBy;
    private Date CreatedAt;
    private Date UpdatedAt;
    private int viewType;

    public RealmArticle() {
    }

    public RealmArticle(int viewType) {
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
        getFilesURI.addAll(Article_List);
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

    public RealmList<String> getImages() {
        return Images;
    }

    public int getPublish_range() {
        return Publish_range;
    }

    public RealmList<String> getArticle_List() {
        return Article_List;
    }

    public RealmList<String> getComments() {
        return Comments;
    }

    public RealmPostedByUser getPostedBy() {
        return PostedBy;
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
                ", PostedBy=" + PostedBy +
                ", CreatedAt=" + CreatedAt +
                ", UpdatedAt=" + UpdatedAt +
                ", viewType=" + viewType +
                '}';
    }
}
