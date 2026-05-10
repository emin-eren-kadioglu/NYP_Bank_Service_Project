package com.bank.app.accounts;

// BankaHesabi sınıfından miras alan Yatırım Hesabı modeli.
public class YatirimHesabi extends BankaHesabi {
    private String hesapTuru;

    public YatirimHesabi(double bakiye) {
        super(bakiye);
        this.hesapTuru = "Yatırım";
    }

    // Yatırım hesabına manuel olarak para ekleme işlemi.
    public void paraEkle(double miktar) {
        if(miktar > 0) {
            this.setBakiye(this.getBakiye() + miktar);
            System.out.println("Yatırım hesabınıza " + miktar + " TL eklendi. Yeni bakiye: " + this.getBakiye());
        }
    }

    // Yatırım hesabından para çekme metodu.
    public void paraCek(double miktar) {
        // Çekilmek istenen miktar hesaptaki paradan büyük olmamalı.
        if(this.getBakiye() >= miktar) {
            this.setBakiye(this.getBakiye() - miktar);
            System.out.println("Yatırım hesabınızdan " + miktar + " TL çekildi. Yeni bakiye: " + this.getBakiye());
        } else {
            System.out.println("Hata: Yatırım hesabınızda yeterli bakiye bulunmuyor!");
        }
    }

    public String getHesapTuru() { return hesapTuru; }
    public void setHesapTuru(String hesapTuru) { this.hesapTuru = hesapTuru; }

    @Override
    public String toString() {
        return super.toString() + ", Hesap Türü: " + hesapTuru;
    }
}