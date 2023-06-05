package com.example.myquranapp;

public class Names {
    String urdu;
    String eng;

    public Names(){
        urdu = "";
        eng = "";
    }

    public Names(String s1, String s2) {
        this.urdu = s1;
        this.eng = s2;
    }

    public String getUrdu() {
        return urdu;
    }

    public void setUrdu(String urdu) {
        this.urdu = urdu;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }
}
