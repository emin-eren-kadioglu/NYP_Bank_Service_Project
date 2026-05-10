package com.bank.app.accounts;

import java.util.Random;

// Tüm hesap türlerinin (Vadesiz ve Yatırım) ortak özelliklerini tutan üst (Base) sınıf.
public class BankaHesabi {
    private String iban;
    private double bakiye;

    public BankaHesabi(double bakiye) {
        // IBAN bilgisini dışarıdan almak yerine içeride rastgele ürettiriyorum.
        this.iban = rastgeleIbanUret(); 
        this.bakiye = bakiye;
    }

    // Gerçekçi bir TR IBAN simülasyonu yapan metot.
    private String rastgeleIbanUret() {
        Random rnd = new Random();
        return "TR" + (10 + rnd.nextInt(90)) + "00062000000" + (10000000 + rnd.nextInt(90000000));
    }

    public String getIban() { return iban; }
    
    public double getBakiye() { return bakiye; }
    public void setBakiye(double bakiye) { this.bakiye = bakiye; }

    @Override
    public String toString() {
        return "IBAN: " + iban + ", Bakiye: " + bakiye;
    }
}
