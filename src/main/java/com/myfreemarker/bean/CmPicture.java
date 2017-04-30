package com.myfreemarker.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/4/22.
 */
@Entity
@Table(name="cm_picture")
public class CmPicture implements Serializable {

    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pictureid", updatable = false)
    private Integer pictureid;
    @Column(nullable = false,name = "picturename")
    private String picturename;
    @Column(nullable = false,name = "pictureurl")
    private String pictureurl;
    @Column(nullable = false,name = "pictureDate")
    private Date pictureDate;
    @Column(nullable = false,name = "picturefix")
    private String picturefix;


    public String getPicturefix() {
        return picturefix;
    }

    public void setPicturefix(String picturefix) {
        this.picturefix = picturefix;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPictureid() {
        return pictureid;
    }

    public void setPictureid(Integer pictureid) {
        this.pictureid = pictureid;
    }

    public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }

    public Date getPictureDate() {
        return pictureDate;
    }

    public void setPictureDate(Date pictureDate) {
        this.pictureDate = pictureDate;
    }
}
