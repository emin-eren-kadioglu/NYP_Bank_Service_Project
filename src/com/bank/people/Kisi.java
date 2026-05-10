package com.bank.app.people;

public class Kisi {
    // OOP'nin Encapsulation (Kapsülleme) kuralı gereği değişkenleri private tanımladım.
    // Böylece bu verilere dışarıdan doğrudan erişilmesini engelledim.
    private String ad;
    private String soyad;
    private String email;
    private int telefonNumarasi;

    // Sınıftan nesne üretildiğinde ilk çalışacak olan Constructor (Yapıcı) metot.
    // Dışarıdan alınan bilgileri sınıfın içindeki değişkenlere atıyor.
    public Kisi(String ad, String soyad, String email, int telefonNumarasi) {
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.telefonNumarasi = telefonNumarasi;
    }

    // Private değişkenlere güvenli bir şekilde erişmek ve değiştirmek için Getter ve Setter metotlarını yazdım.
    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getSoyad() { return soyad; }
    public void setSoyad(String soyad) { this.soyad = soyad; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getTelefonNumarasi() { return telefonNumarasi; }
    public void setTelefonNumarasi(int telefonNumarasi) { this.telefonNumarasi = telefonNumarasi; }

    // Ekrana yazdırırken bellek adresi yerine anlamlı bir metin dönmesi için toString metodunu ezdim (override ettim).
    @Override
    public String toString() {
        return "Ad: " + ad + ", Soyad: " + soyad + ", Email: " + email + ", Tel: " + telefonNumarasi;
    }
}