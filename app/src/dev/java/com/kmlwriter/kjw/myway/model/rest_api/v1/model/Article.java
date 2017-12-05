package com.kmlwriter.kjw.myway.model.rest_api.v1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kjw on 2017. 12. 5..
 */

public class Article implements Serializable{
    private String Kml_Uri;
    private String Contents;
    private int Like;
    private String Like_Persons;
    private ArrayList<String> Images;
    private int Publish_range;
    private ArrayList<String>Article_List;
    private ArrayList<String>Comments;
    private String PostedBy;
    private Date CreatedAt;
    private Date UpdatedAt;
}
