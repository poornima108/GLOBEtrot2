package com.example.poornima.globetrot2;

/**
 * Created by mohit on 4/8/2017.
 */

public class Data {

    private String nameList;
    private String photoList;
    private Double ratingList, locationLatList, locationLngList;

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    public void setPhotoList(String photoList) {
        this.photoList = photoList;
    }

    public void setRatingList(Double ratingList) {
        this.ratingList = ratingList;
    }

    public void setLocationLatList(Double locationLatList) {
        this.locationLatList = locationLatList;
    }

    public void setLocationLngList(Double locationLngList) {
        this.locationLngList = locationLngList;
    }

    public String getNameList() {
        return nameList;
    }

    public String getPhotoList() {
        return photoList;
    }

    public Double getRatingList() {
        return ratingList;
    }

    public Double getLocationLatList() {
        return locationLatList;
    }

    public Double getLocationLngList() {
        return locationLngList;
    }
}
