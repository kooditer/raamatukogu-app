package gui;

public interface StringListener {
    public void textEmitted(String text);
}
/*Tekitame interface-i(see on vahelüli erinevate klasside vahel)
, mille kutsub esile toolbar
        ja toolbar tekitab selle muutuja, ning
kasutades selle meetodit textemitted
        lisab nupuvajutuse teksti sinna meetodisse.
        mainframe-s saame selle stringi lükata textareasse/textPaneli
Niimoodi saame eristada toolbari ja textbar-i
*/