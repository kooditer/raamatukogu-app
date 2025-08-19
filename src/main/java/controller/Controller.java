package controller;

import gui.FormEvent;
import model.ArvustusCategory;
import model.Database;
import model.Raamat;
import model.ZhanrCategory;

import java.util.List;

public class Controller {
    Database db = new Database();

    public List<Raamat> getRaamatud() {//selle list of raamat pean saama tablemodelisse
        return db.getRaamatud();
    }

    public void removeRaamat(int index) {
        db.removeRaamat(index);
    }

    //järgnevaga saadan ma kontrollerisse evendi ev mis tuleb form elementidest FormPanelist.
    public void addRaamat(FormEvent ev) {
        String title = ev.getTitle();
        String author = ev.getAuthor();
        String published = ev.getPublished();
        String zhanrCat = ev.getZhanrCategory();
        String arvustusCat = ev.getArvustusCategory();

        ZhanrCategory zhanrCategory = null;
        switch (zhanrCat) {
            case "Kriminull":
                zhanrCategory = ZhanrCategory.Kriminull;
                break;
            case "Põnevik":
                zhanrCategory = ZhanrCategory.Põnevik;
                break;
            case "Õpik":
                zhanrCategory = ZhanrCategory.Õpik;
                break;
            case "Eneseabi":
                zhanrCategory = ZhanrCategory.Eneseabi;
                break;
            case "Investeerimine":
                zhanrCategory = ZhanrCategory.Investeerimine;
                break;
            case "Lasteraamat":
                zhanrCategory = ZhanrCategory.Lasteraamat;
                break;
            case "Muu":
                zhanrCategory = ZhanrCategory.Muu;

        }//switch lõpp

        ArvustusCategory arvustusCategory = null;

        if (arvustusCat.equals("Väga hea")) {
            arvustusCategory = ArvustusCategory.Väga_hea;
        } else if (arvustusCat.equals("Hea")) {
            arvustusCategory = ArvustusCategory.Hea;
        } else if (arvustusCat.equals("Keskmine")) {
            arvustusCategory = ArvustusCategory.Keskmine;
        } else if (arvustusCat.equals("Halb")) {
            arvustusCategory = ArvustusCategory.Väga_halb;
        }


        Raamat raamat = new Raamat(title, author, published, zhanrCategory, arvustusCategory);
        db.addraamat(raamat);
    } //addRaamat lõpp


}//klassi lõpp
