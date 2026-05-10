package com.bank.app.people;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;

import java.util.ArrayList;
import java.util.Random;

// Musteri sınıfı da Kisi sınıfından miras alıyor.
public class Musteri extends Kisi {
    private String musteriNumarasi;
    
    // Bir müşterinin birden fazla banka hesabı ve kredi kartı olabileceği için ArrayList kullandım.
    private ArrayList<BankaHesabi> hesaplar; 
    private ArrayList<KrediKarti> krediKartlari; 

    public Musteri(String ad, String soyad, String email, int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        
        // Müşteri numarasını projede istendiği gibi rastgele türetiyorum.
        this.musteriNumarasi = rastgeleMusteriNoUret(); 
        this.hesaplar = new ArrayList<>();
        this.krediKartlari = new ArrayList<>();
    }

    // 5 haneli rastgele bir müşteri numarası üretiyor (Örn: MUS-45892)
    private String rastgeleMusteriNoUret() {
        Random rnd = new Random();
        return "MUS-" + (10000 + rnd.nextInt(90000));
    }

    // Gelen parametreye göre müşteriye Vadesiz veya Yatırım hesabı açan metot.
    public void hesapEkle(String hesapTuru) {
        if (hesapTuru.equalsIgnoreCase("Vadesiz")) {
            // Başlangıç bakiyesini 0.0 vererek yeni bir VadesizHesap nesnesi oluşturup listeye ekliyorum.
            hesaplar.add(new VadesizHesap(0.0)); 
            System.out.println("Vadesiz hesap başarıyla eklendi.");
        } else if (hesapTuru.equalsIgnoreCase("Yatirim")) {
            hesaplar.add(new YatirimHesabi(0.0));
            System.out.println("Yatırım hesabı başarıyla eklendi.");
        } else {
            System.out.println("Geçersiz hesap türü!");
        }
    }

    // Müşteriye yeni bir kredi kartı nesnesi oluşturup ekleyen metot.
    public void krediKartiEkle(double limit) {
        KrediKarti yeniKart = new KrediKarti(limit, 0.0);
        krediKartlari.add(yeniKart);
        System.out.println("Kredi kartı başarıyla eklendi. Limit: " + limit);
    }

    // Proje isterindeki güvenlik kontrolü: Bakiye sıfırdan büyükse hesabı silmesine izin vermiyorum.
    public void hesapSil(BankaHesabi hesap) {
        if (hesap.getBakiye() > 0) {
            System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız.");
        } else {
            hesaplar.remove(hesap);
            System.out.println("Hesap başarıyla silindi.");
        }
    }

    // Güvenlik kontrolü: Borç varken kartın silinmesini engelliyorum.
    public void krediKartiSil(KrediKarti kart) {
        if (kart.getGuncelBorc() > 0) {
            System.out.println("Lütfen öncelikle borç ödemesi yapınız.");
        } else {
            krediKartlari.remove(kart);
            System.out.println("Kredi kartı başarıyla silindi.");
        }
    }

    // Getter metotları
    public String getMusteriNumarasi() { return musteriNumarasi; }
    public ArrayList<BankaHesabi> getHesaplar() { return hesaplar; }
    public ArrayList<KrediKarti> getKrediKartlari() { return krediKartlari; }

    @Override
    public String toString() {
        return super.toString() + ", Müşteri No: " + musteriNumarasi;
    }
}