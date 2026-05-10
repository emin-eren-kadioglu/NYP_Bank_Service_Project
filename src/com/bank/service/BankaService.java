package com.bank.app.service;

import com.bank.app.people.BankaPersoneli;
import com.bank.app.people.Musteri;
import java.util.ArrayList;

// Bu sınıf sistemdeki genel iş mantığını yöneten "Yönetici" veya "Veritabanı" görevi görüyor.
public class BankaService {
    
    // Bankadaki tüm kayıtlı personelleri ve müşterileri tuttuğum listeler.
    private ArrayList<BankaPersoneli> personeller;
    private ArrayList<Musteri> musteriler;

    public BankaService() {
        this.personeller = new ArrayList<>();
        this.musteriler = new ArrayList<>();
    }

    // Sisteme genel personel kaydı yapan metot.
    public void personelEkle(BankaPersoneli personel) {
        personeller.add(personel);
        System.out.println("Sisteme yeni personel eklendi: " + personel.getAd() + " " + personel.getSoyad());
    }

    // Sisteme genel müşteri kaydı yapan metot.
    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
        System.out.println("Sisteme yeni müşteri eklendi: " + musteri.getAd() + " " + musteri.getSoyad());
    }

    // Sisteme eklenen müşteriyi, belirli bir banka personeline (temsilci) atama metodu.
    public void musteriTemsilcisineAta(BankaPersoneli personel, Musteri musteri) {
        // Olası hataları engellemek için nesnelerin null olup olmadığını kontrol ediyorum.
        if (personel != null && musteri != null) {
            personel.musteriEkle(musteri);
            System.out.println("Atama Başarılı: " + musteri.getAd() + " isimli müşteri, " + personel.getAd() + " temsilcisine atandı.");
        }
    }
}