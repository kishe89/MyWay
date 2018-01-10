package com.kmlwriter.kjw.myway.model.rest_api.v1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by kjw on 2018. 1. 10..
 */

public class ArticleItem implements Serializable{
    /**
     * {
     "_id": "5a34ba808928b7003e5c1118",
     "Title": "Hello World1",
     "Place": "용당 동아아파트104동",
     "PlaceType": "요식업",
     "Loc": [
     127.1231312,
     34.324224
     ],
     "PostedBy": "5a2ba63eec5be6004055c761",
     "__v": 0,
     "UpdatedAt": "2017-12-16T06:17:36.687Z",
     "CreatedAt": "2017-12-16T06:17:36.687Z"
     }
     */
    private String _id;
    private String Title;
    private String place;
    private String PlaceType;
    private float[] Loc;

    @SerializedName("PostedBy")
    @Expose
    private String postedBy;
    private int __v;
    private Date UpdatedAt;
    private Date CreatedAt;

    public String get_id() {
        return _id;
    }

    public String getTitle() {
        return Title;
    }

    public String getPlace() {
        return place;
    }

    public String getPlaceType() {
        return PlaceType;
    }

    public float[] getLoc() {
        return Loc;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public int get__v() {
        return __v;
    }

    public Date getUpdatedAt() {
        return UpdatedAt;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    @Override
    public String toString() {
        return "ArticleItem{" +
                "_id='" + _id + '\'' +
                ", Title='" + Title + '\'' +
                ", place='" + place + '\'' +
                ", PlaceType='" + PlaceType + '\'' +
                ", Loc=" + Arrays.toString(Loc) +
                ", postedBy=" + postedBy +
                ", __v=" + __v +
                ", UpdatedAt=" + UpdatedAt +
                ", CreatedAt=" + CreatedAt +
                '}';
    }
}
