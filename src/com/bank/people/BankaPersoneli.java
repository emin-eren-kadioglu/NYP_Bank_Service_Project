package com.bank.app.people;

import java.util.ArrayList;
import java.util.Random;

// BankaPersoneli, Kisi sınıfının ortak özelliklerini Inheritance (Kalıtım) ile miras alır.
public class BankaPersoneli extends Kisi {
    private String personelID;
    
    // Bir personelin birden fazla müşterisi olabileceği için bunları bir ArrayList içinde tutuyorum.
    private ArrayList<Musteri> musteriler; 

    public BankaPersoneli(String ad, String soyad, String email, int telefonNumarasi) {
        // super() anahtar kelimesi ile üst sınıfın (Kisi) constructor'ına bilgileri gönderiyorum.
        super(ad, soyad, email, telefonNumarasi); 
        
        // Proje isterlerine uygun olarak ID'yi dışarıdan almak yerine içeride otomatik ürettiriyorum.
        this.personelID = rastgeleIDUret(); 
        
        // NullPointerException hatası almamak için listeyi başlatıyorum.
        this.musteriler = new ArrayList<>(); 
    }

    // Personel ID'sini rastgele türeten yardımcı (private) metot.
    private String rastgeleIDUret() {
        Random rnd = new Random();
        // PER-1234 gibi bir format oluşturuyor.
        return "PER-" + (1000 + rnd.nextInt(9000)); 
    }

    // İlgili personele yeni bir müşteri atamak için kullandığım metot.
    public void musteriEkle(Musteri musteri) {
        this.musteriler.add(musteri);
    }

    public String getPersonelID() { return personelID; }
    public ArrayList<Musteri> getMusteriler() { return musteriler; }

    @Override
    public String toString() {
        // Üst sınıfın toString metoduna Personel ID'yi de ekleyerek döndürüyorum.
        return super.toString() + ", Personel ID: " + personelID;
    }
}