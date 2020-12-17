package com.example.defapp.model;

import java.util.ArrayList;

public class Application {

    private String appName;
    private ArrayList<String> creators;
    private String createDate;
    private int ranking;
    private String webSite;
    private String entreprise;
    private int imageView;

    public Application(int imageView,String appName, ArrayList<String> creators, String createDate, int ranking, String webSite, String entreprise) {
        this.imageView = imageView;
        this.appName = appName;
        this.creators = creators;
        this.createDate = createDate;
        this.ranking = ranking;
        this.webSite = webSite;
        this.entreprise = entreprise;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public ArrayList<String> getCreators() {
        return creators;
    }

    public void setCreators(ArrayList<String> creators) {
        this.creators = creators;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }
}
