package model;

public class Raamat {
    //see klass salvestab raamatu andmed kui äpp töötab
    private static int count = 1;
    private int id;
    private String title;
    private String author;
    private String published;
    private ZhanrCategory zhanr;
    private ArvustusCategory arvustus;

    //teeme konstruktori
    public Raamat(String title, String author, String published, ZhanrCategory zhanr, ArvustusCategory arvustus) {
        this.title = title;
        this.author = author;
        this.published = published;
        this.zhanr = zhanr;
        this.arvustus = arvustus;
        this.id = count;
        count++;
    }

    public Raamat(int id, String title, String author, String published, ZhanrCategory zhanr, ArvustusCategory arvustus) {
        this(title, author, published, zhanr, arvustus);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ZhanrCategory getZhanr() {
        return zhanr;
    }

    public void setZhanr(ZhanrCategory zhanr) {
        this.zhanr = zhanr;
    }

    public ArvustusCategory getArvustus() {
        return arvustus;
    }

    public void setArvustus(ArvustusCategory arvustus) {
        this.arvustus = arvustus;
    }

    public String toString() {
        return title + ": " + author;
    }




}//klassi lõpp
