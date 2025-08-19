package gui;

import java.util.EventObject;

public class FormEvent extends EventObject {
    //see klass võtab info , mida kasutaja sisestab, salvestab selle ja teeb saadab selle mainfram-le.
    private String title;
    private String author;
    private String published;
    private String zhanr;
    private String arvustus;

    public FormEvent(Object source) {
        super(source);
    }

    public String getZhanrCategory() {
        return zhanr;
    }
    public  String getArvustusCategory() {
        return arvustus;
    }


    public FormEvent(Object source, String title, String author, String published, String zhanr, String arvustus) {
        super(source);
        this.title = title;
        this.author = author;
        this.published = published;
        this.zhanr = zhanr;
        this.arvustus = arvustus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }
}
