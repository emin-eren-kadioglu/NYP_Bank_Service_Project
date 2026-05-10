package com.bank.app.main;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;
import com.bank.app.people.BankaPersoneli;
import com.bank.app.people.Musteri;
import com.bank.app.service.BankaService;
import java.util.Scanner;

// Projenin çalıştığı, Scanner ile dinamik verilerin alındığı test sınıfı.
public class Main {
    public static void main(String[] args) {
        // Kullanıcıdan veri almak için Scanner nesnesini başlatıyorum.
        Scanner scanner = new Scanner(System.in);
        BankaService bankaServisi = new BankaService();

        System.out.println("=== BTÜ BANKA OTOMASYON SİSTEMİNE HOŞ GELDİNİZ ===");

        // ---- ADIM 1: Personel ve Müşteri Kaydı ----
        System.out.print("Sisteme eklenecek personelin adı: ");
        String pAd = scanner.nextLine();
        System.out.print("Personelin soyadı: ");
        String pSoyad = scanner.nextLine();
        // Konsoldan aldığım isimle dinamik mail oluşturup yeni personel nesnesi yaratıyorum.
        BankaPersoneli personel = new BankaPersoneli(pAd, pSoyad, pAd.toLowerCase() + "@banka.com", 5550001);
        bankaServisi.personelEkle(personel);

        System.out.print("\nKaydı yapılacak müşterinin adı: ");
        String mAd = scanner.nextLine();
        System.out.print("Müşterinin soyadı: ");
        String mSoyad = scanner.nextLine();
        Musteri musteri = new Musteri(mAd, mSoyad, mAd.toLowerCase() + "@mail.com", 5550002);
        bankaServisi.musteriEkle(musteri);
        
        // Müşteriyi personele atama işlemi
        bankaServisi.musteriTemsilcisineAta(personel, musteri);

        // ---- ADIM 2: Hesap Açma ve Para Yatırma ----
        System.out.println("\n--- Hesap Açma İşlemleri ---");
        musteri.hesapEkle("Vadesiz");
        musteri.hesapEkle("Yatirim");

        // Polimorfizm kullanarak nesneleri ilgili hesap tiplerine dönüştürüyorum (Casting).
        VadesizHesap vadesiz = (VadesizHesap) musteri.getHesaplar().get(0);
        YatirimHesabi yatirim = (YatirimHesabi) musteri.getHesaplar().get(1);

        System.out.print("Vadesiz hesaba başlangıç için yatırılacak tutar: ");
        double vBakiye = scanner.nextDouble();
        vadesiz.setBakiye(vBakiye);

        System.out.print("Yatırım hesabına başlangıç için yatırılacak tutar: ");
        double yBakiye = scanner.nextDouble();
        yatirim.paraEkle(yBakiye);

        // ---- ADIM 3: Para Transferi ----
        System.out.println("\n--- Para Transferi ---");
        System.out.print("Vadesiz hesaptan Yatırım hesabına ne kadar para gönderilsin? ");
        double transferTutari = scanner.nextDouble();
        // Transfer iş mantığını tetikliyorum.
        vadesiz.paraTransferi(yatirim, vadesiz, transferTutari);

        // ---- ADIM 4: Kredi Kartı İşlemleri ----
        System.out.println("\n--- Kredi Kartı Tanımlama ---");
        System.out.print("Kredi kartı limitini belirleyin: ");
        double limit = scanner.nextDouble();
        musteri.krediKartiEkle(limit);
        KrediKarti kart = musteri.getKrediKartlari().get(0);

        // Test için sanal bir alışveriş borcu yansıtıyorum.
        System.out.print("Karta yansıtılacak (harcanan) borç tutarı: ");
        double borc = scanner.nextDouble();
        kart.setGuncelBorc(borc);

        System.out.print("Vadesiz hesap bakiyenizden, kredi kartı borcunuzun ne kadarını ödemek istersiniz? ");
        double odeme = scanner.nextDouble();
        vadesiz.krediKartiBorcOdeme(kart, odeme);

        // ---- ADIM 5: Silme Kontrolleri (Güvenlik Algoritmaları) ----
        System.out.println("\n--- Sistemden Silme Testleri ---");
        
        System.out.println("-> Borcu olan kart silinmeye çalışılıyor...");
        musteri.krediKartiSil(kart); // Borç sıfırlanmadığı için hata uyarısı vermeli.

        System.out.println("\n-> İçinde bakiyesi olan yatırım hesabı silinmeye çalışılıyor...");
        musteri.hesapSil(yatirim); // Hesapta para olduğu için hata uyarısı vermeli.

        System.out.println("\nİşlemler tamamlandı. Program sonlandırılıyor.");
        // Scanner nesnesini kapatarak bellek (memory) sızıntısını önlüyorum.
        scanner.close(); 
    }
}