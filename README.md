# 🏦 Banka Otomasyon Sistemi (Bank Management System)

Bu proje, Bursa Teknik Üniversitesi (BTÜ) Bilgisayar Mühendisliği Bölümü **BLM0121 Nesneye Yönelik Programlama** dersi proje ödevi kapsamında geliştirilmiş, terminal üzerinden çalışan bir banka yönetim simülasyonudur.

Proje; gerçek dünyadaki banka personeli, müşteri, farklı banka hesapları (vadesiz/yatırım) ve kredi kartı gibi aktörlerin birbirleriyle olan finansal ilişkilerini Nesneye Yönelik Programlama prensiplerine (OOP) ve belirlenen UML diyagramına sadık kalarak modellemektedir.

## 🚀 Proje Özellikleri ve Senaryolar

Sistem, `Main` sınıfı üzerinden çalıştırıldığında aşağıdaki işlemleri sırasıyla otomatik olarak test eder ve sonuçları konsola yazdırır:

1. **Aktör Yönetimi:** Sisteme yeni banka personeli ve müşteri eklenmesi, müşterinin ilgili personele atanması.
2. **Hesap Açılışları:** Müşteri adına Vadesiz Hesap ve Yatırım Hesabı oluşturulması.
3. **Finansal İşlemler:** İlgili hesaplara başlangıç bakiyelerinin yatırılması ve hesaplar arası para transferinin matematiksel olarak doğrulanması.
4. **Kredi Kartı Modülü:** Müşteriye rastgele türetilen bir kart numarasıyla kredi kartı tanımlanması, harcama/borç yansıtılması ve vadesiz hesaptaki bakiye ile bu kredi kartı borcunun ödenmesi.
5. **Güvenlik ve Validasyon:** * İçerisinde para (bakiye) bulunan bir hesabın silinmesinin engellenmesi.
   * Güncel borcu bulunan bir kredi kartının sistemden silinmesinin engellenmesi.
   * Şartlar sağlandığında (bakiye 0, borç 0) silme işlemlerinin başarıyla gerçekleştirilmesi.

## 🧠 Uygulanan OOP Prensipleri

Proje, yazılım mühendisliği standartlarına uygun olarak modüler bir mimaride geliştirilmiştir:

* **Kalıtım (Inheritance):** Kod tekrarını önlemek amacıyla hiyerarşik bir yapı kurulmuştur. 
  * `Musteri` ve `BankaPersoneli` sınıfları, temel aktör sınıfı olan `Kisi` sınıfından miras almaktadır (`extends`).
  * `VadesizHesap` ve `YatirimHesabi` sınıfları, temel `BankaHesabi` sınıfından türetilmiştir.
* **Kapsülleme (Encapsulation):** Nesnelerin veri bütünlüğünü korumak için tüm sınıf özellikleri (isim, bakiye, borç, limit vb.) `private` olarak tanımlanmış, erişimler yalnızca kontrollü `Getter` ve `Setter` metotları ile sağlanmıştır. Müşteri numarası, Personel ID ve IBAN gibi bilgiler dışarıdan parametre olarak alınmamış; sınıfların içerisinde `Random` algoritmalarla otomatik üretilmiştir.
* **Kompozisyon (Composition):** Müşterilerin birden fazla hesaba ve kredi kartına sahip olabilmesi durumu, `Musteri` sınıfı içerisinde `ArrayList` veri yapıları kullanılarak (örn: `ArrayList<BankaHesabi> hesaplar`) tasarlanmıştır.

## 📂 Paket ve Klasör Mimarisi

Uygulamanın modüler yapısı, görev tanımlarına göre 5 farklı Java paketine ayrılmıştır:

```text
src/
└── com/
    └── bank/
        └── app/
            ├── accounts/       # BankaHesabi, VadesizHesap, YatirimHesabi
            ├── cards/          # KrediKarti
            ├── main/           # Main (Uygulamanın başlangıç ve test noktası)
            ├── people/         # Kisi, Musteri, BankaPersoneli
            └── service/        # BankaService (Atama ve iş mantığı işlemleri)

```

## 🛠️ Kurulum ve Çalıştırma

Projeyi kendi bilgisayarınızda derlemek ve çalıştırmak için bilgisayarınızda **Java (JDK)** kurulu olmalıdır.

1. Projeyi bilgisayarınıza klonlayın:
```bash
git clone [https://github.com/KULLANICI_ADIN/PROJE_REPOSU_ADI.git](https://github.com/KULLANICI_ADIN/PROJE_REPOSU_ADI.git)

```


2. Proje dizinine gidin ve kaynak kodların bulunduğu `src` klasörüne geçiş yapın:
```bash
cd PROJE_REPOSU_ADI/src

```


3. Java dosyalarını derleyin:
```bash
javac com/bank/app/main/Main.java

```


4. Uygulamayı çalıştırın:
```bash
java com.bank.app.main.Main

```



## 👨‍💻 Geliştirici

* **Emin Eren Kadıoğlu**
* Bursa Teknik Üniversitesi (BTÜ) - Bilgisayar Mühendisliği
* Öğrenci No: 25360859011

```

```
