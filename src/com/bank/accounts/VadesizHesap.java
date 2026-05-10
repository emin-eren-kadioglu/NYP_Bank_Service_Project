package com.bank.app.accounts;

import com.bank.app.cards.KrediKarti;

// BankaHesabi sınıfından kalıtım alarak vadesiz hesaba özgü işlemleri barındırır.
public class VadesizHesap extends BankaHesabi {
    private String hesapTuru;

    public VadesizHesap(double bakiye) {
        // super() ile bakiyeyi üst sınıfa (BankaHesabi) iletiyorum.
        super(bakiye); 
        this.hesapTuru = "Vadesiz";
    }

    // İki hesap arasında para transferi yapan iş mantığı (Business Logic) metodu.
    public void paraTransferi(BankaHesabi aliciHesap, BankaHesabi gonderenHesap, double miktar) {
        // Gönderen hesaptaki paranın, gönderilecek tutara yetip yetmediğini kontrol ediyorum.
        if (gonderenHesap.getBakiye() >= miktar) {
            // Yeterliyse gönderenden parayı düşüp, alıcıya ekliyorum.
            gonderenHesap.setBakiye(gonderenHesap.getBakiye() - miktar);
            aliciHesap.setBakiye(aliciHesap.getBakiye() + miktar);
            System.out.println("Başarılı! " + miktar + " TL transfer edildi.");
        } else {
            System.out.println("Hata: Yetersiz bakiye!");
        }
    }

    // Vadesiz hesaptaki parayla kredi kartı borcunu ödeyen metot.
    public void krediKartiBorcOdeme(KrediKarti kart, double miktar) {
        // Hesapta yeterli bakiye var mı kontrolü yapıyorum.
        if (this.getBakiye() >= miktar) {
            // Hesaptan parayı düşüyorum.
            this.setBakiye(this.getBakiye() - miktar);
            
            // Kartın güncel borcunu ödenen miktar kadar azaltıyorum.
            kart.setGuncelBorc(kart.getGuncelBorc() - miktar); 
            System.out.println("Başarılı! Kredi kartı borcunuzdan " + miktar + " TL ödendi.");
        } else {
            System.out.println("Hata: Yetersiz bakiye!");
        }
    }

    public String getHesapTuru() { return hesapTuru; }
    public void setHesapTuru(String hesapTuru) { this.hesapTuru = hesapTuru; }

    @Override
    public String toString() {
        return super.toString() + ", Hesap Türü: " + hesapTuru;
    }
}