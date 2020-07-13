package com.auapp.anuraguniversity;

public class Events {
    String eventname,data,img,profil,tstudent,link,name,uid,olink;




    public Events(String eventname, String data, String img, String profil, String tstudent, String link, String name,  String olink) {
        this.eventname = eventname;
        this.data = data;
        this.img = img;
        this.profil = profil;
        this.tstudent = tstudent;
        this.link = link;
        this.name = name;
        //this.uid = uid;
        this.olink = olink;
    }

    public String getUid() {
        return uid;
    }

    public String getOlink() {
        return olink;
    }

    public void setOlink(String olink) {
        this.olink = olink;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Events() {
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String getTstudent() {
        return tstudent;
    }

    public void setTstudent(String tstudent) {
        this.tstudent = tstudent;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
