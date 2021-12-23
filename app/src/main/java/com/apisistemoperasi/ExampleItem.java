package com.apisistemoperasi;

public class ExampleItem {
    private String logoUrl, versi, website, deskripsi;


    public ExampleItem(String logoUrl, String versi, String website, String deskripsi) {
        this.logoUrl = logoUrl;
        this.versi = versi;
        this.website = website;
        this.deskripsi = deskripsi;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getVersi() {
        return versi;
    }

    public String getWebsite() {
        return website;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
