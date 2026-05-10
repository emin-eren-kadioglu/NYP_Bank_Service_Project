package com.bank.app.cards;

import java.util.Random;

public class KrediKarti {
    private String kartNumarasi;
    private double limit;
    private double guncelBorc;
    private double kullanilabilirLimit;

    public KrediKarti(double limit, double guncelBorc) {
        // Proje isterine uygun olarak kart numarasını random oluşturuyorum.
        this.kartNumarasi = rastgeleKartNoUret(); 
        this.limit = limit;
        this.guncelBorc = guncelBorc;
        // Kullanılabilir limit, toplam limitten güncel borcun çıkarılmasıyla bulunur.
        this.kullanilabilirLimit = limit - guncelBorc; 
    }

    // 16 haneli rastgele kredi kartı numarası üreten simülasyon metodu.
    private String rastgeleKartNoUret() {
        Random rnd = new Random();
        long randomNo = 1000000000000000L + (long)(rnd.nextDouble() * 8999999999999999L);
        return String.valueOf(randomNo);
    }

    public String getKartNumarasi() { return kartNumarasi; }
    
    public double getLimit() { return limit; }
    public void setLimit(double limit) { this.limit = limit; }

    public double getGuncelBorc() { return guncelBorc; }
    
    // Borç değerini her güncellediğimde, kullanılabilir limitin de matematiksel olarak 
    // eş zamanlı güncellenmesini bu Setter metodu içinde garanti altına alıyorum.
    public void setGuncelBorc(double guncelBorc) { 
        this.guncelBorc = guncelBorc; 
        this.kullanilabilirLimit = this.limit - this.guncelBorc;
    }

    public double getKullanilabilirLimit() { return kullanilabilirLimit; }

    @Override
    public String toString() {
        return "Kart No: " + kartNumarasi + ", Limit: " + limit + ", Güncel Borç: " + guncelBorc + ", Kullanılabilir Limit: " + kullanilabilirLimit;
    }
}