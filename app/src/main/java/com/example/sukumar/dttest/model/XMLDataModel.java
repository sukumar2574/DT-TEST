package com.example.sukumar.dttest.model;

/**
 * Created by Sukumar on 2/9/2017.
 */

public class XMLDataModel {

    private String productName;
    private String thumbNailURL;
    private String ratingImageURL;
    private String categoryName;
    private String numOfRatings;
    private String rating;
    private String minOSVersion;
    private String description;

    public String getNumOfRatings() {
        return numOfRatings;
    }

    public void setNumOfRatings(String numOfRatings) {
        this.numOfRatings = numOfRatings;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getMinOSVersion() {
        return minOSVersion;
    }

    public void setMinOSVersion(String minOSVersion) {
        this.minOSVersion = minOSVersion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getThumbNailURL() {
        return thumbNailURL;
    }

    public void setThumbNailURL(String thumbNailURL) {
        this.thumbNailURL = thumbNailURL;
    }

    public String getRatingImageURL() {
        return ratingImageURL;
    }

    public void setRatingImageURL(String ratingImageURL) {
        this.ratingImageURL = ratingImageURL;
    }

}
