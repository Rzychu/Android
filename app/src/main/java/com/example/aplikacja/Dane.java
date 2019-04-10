package com.example.aplikacja;

class Dane {
    String data;
    Float koszt;
    Float dystans;
    Float ilosc;
    Float cena;


    public Dane(Float koszt, Float dystans, String data, Float ilosc, Float cena) {
        this.koszt = koszt;
        this.dystans = dystans;
        this.data = data;
        this.ilosc = ilosc;
        this.cena = cena;
    }

    public Float getKoszt() { return koszt; }

    public void setKoszt(Float koszt) {
        this.koszt = koszt;
    }

    public Float getDystans() {
        return dystans;
    }

    public void setDystans(Float dystans) {
        this.dystans = dystans;
    }



}
