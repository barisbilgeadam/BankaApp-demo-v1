package org.dorukt;

import org.dorukt.controller.AdresController;
import org.dorukt.controller.BankaController;
import org.dorukt.controller.HesapConroller;
import org.dorukt.controller.MusteriController;
import org.dorukt.repository.entity.Adres;
import org.dorukt.repository.entity.Banka;
import org.dorukt.repository.entity.Hesap;
import org.dorukt.repository.entity.Musteri;
import org.dorukt.repository.enums.EHesapTipi;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Uygulama {
    Scanner sc = new Scanner(System.in);
    BankaController bankaController = new BankaController();
    AdresController adresController = new AdresController();
    MusteriController musteriController = new MusteriController();
    HesapConroller hesapConroller = new HesapConroller();

    Banka temp;
    Musteri musteri;

    Hesap hesap;

    public static void main(String[] args) {
        Uygulama uyg1 = new Uygulama();
        uyg1.defaultData();
        do {
            uyg1.menu();
        } while (uyg1.musteri == null);

        uyg1.hosgeldin();
    }

    private void hesaplariGoster() {
        for (Hesap hesap1 : musteri.getHesaplar()) {
            System.out.println("ID:" + hesap1.getId() + " - " + hesap1.getHesapTipi() + " hesabınızdaki güncel bakiye: " + hesap1.getBakiye());
        }
    }

    public void defaultData() {

        Banka bank1 = Banka.builder().ad("Halkbank").build();
        Banka bank2 = Banka.builder().ad("ING").build();

        bankaController.save(bank1);
        bankaController.save(bank2);
        Hesap hesap1 = Hesap.builder().acilmaTarihi(LocalDate.of(2022, 06, 14)).hesapTipi(EHesapTipi.TL).bakiye(500L).build();
        Hesap hesap2 = Hesap.builder().acilmaTarihi(LocalDate.of(2023, 06, 2)).hesapTipi(EHesapTipi.DOLAR).bakiye(6600L).build();
        Hesap hesap3 = Hesap.builder().acilmaTarihi(LocalDate.of(2022, 03, 14)).hesapTipi(EHesapTipi.EURO).bakiye(2990L).build();
        Hesap hesap4 = Hesap.builder().acilmaTarihi(LocalDate.of(2023, 03, 22)).hesapTipi(EHesapTipi.TL).bakiye(8000L).build();
        Adres adres1 = Adres.builder().ulke("Türkiye").sehir("İstanbul").build();
        Adres adres2 = Adres.builder().ulke("Türkiye").sehir("Ankara").build();
        Adres adres3 = Adres.builder().ulke("Türkiye").sehir("Antalya").build();
        Adres adres4 = Adres.builder().ulke("Türkiye").sehir("Kastamonu").build();
        Musteri musteri1 = Musteri.builder().ad("Doruk").soyad("Tokinan").adres(adres4).password("123").username("mono").banka(bank1).hesaplar(List.of(hesap1)).build();
        adres4.setMusteri(musteri1);
        hesap1.setMusteri(musteri1);
        Musteri musteri2 = Musteri.builder().ad("Berk").soyad("Aktaş").adres(adres3).password("424").username("canki").banka(bank2).hesaplar(List.of(hesap3)).build();
        adres3.setMusteri(musteri2);
        hesap3.setMusteri(musteri2);
        Musteri musteri3 = Musteri.builder().ad("Semih").soyad("Aksoy").adres(adres2).password("252").username("deep").banka(bank1).hesaplar(List.of(hesap4)).build();
        adres2.setMusteri(musteri3);
        hesap4.setMusteri(musteri3);
        Musteri musteri4 = Musteri.builder().ad("Onur").soyad("İltekin").adres(adres1).password("5673").username("mrbotz").banka(bank2).hesaplar(List.of(hesap2)).build();
        adres1.setMusteri(musteri4);
        hesap2.setMusteri(musteri4);


        musteriController.save(musteri1);
        musteriController.save(musteri2);
        musteriController.save(musteri3);
        musteriController.save(musteri4);
    }

    private void hosgeldin() {
        int secim = 0;
        System.out.println("Hoşgeldin! " + musteri.getAd() + "\n");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        do {
            System.out.println("Aktif Kullanıcı: " + musteri.getUsername());
            System.out.println("Aktif Banka: " + temp.getAd());
            System.out.println("Lütfen yapılacak işlemi seçin:");
            System.out.println("1 - Hesaplarımı göster.");
            System.out.println("2 - Yeni hesap aç");
            System.out.println("3 - Hesap işlemleri.");
            System.out.println("4 - Özel Sorgu işlemleri");
            System.out.println("0 - Çıkış.");
            System.out.println("Lutfen Secim Yapin.");
            secim = sc.nextInt();
            sc.nextLine();
            switch (secim) {
                case 1:
                    hesaplariGoster();
                    break;
                case 2:
                    yeniHesapAc();
                    break;
                case 3:
                    hesapIslemleri();
                    break;
                case 4:
                    break;
                case 0:
                    break;

            }
        } while (secim != 0);
    }

    private void yeniHesapAc() {
        System.out.println("Hesabın türünü seçin:");
        for (EHesapTipi value : EHesapTipi.values()) {
            System.out.println((value.ordinal() + 1) + " - " + value.name());
        }
        EHesapTipi hesapTipi = EHesapTipi.values()[sc.nextInt() - 1];
        sc.nextLine();
        hesap = Hesap.builder().hesapTipi(hesapTipi).build();
        hesap.setMusteri(musteri);
        musteri = musteriController.findById(musteri.getId()).get();
        musteri.getHesaplar().add(hesap);
        musteriController.update(musteri);

    }

    private void hesapIslemleri() {
        int secim = 0;
        hesaplariGoster();
        System.out.println("Lütfen çalışılacak hesabın ID'sini girin.");
        hesap = hesapConroller.findById(sc.nextInt()).get();
        do {

            System.out.println("1 - Hesabı kapa");
            System.out.println("2 - Bakiye görüntüle");
            System.out.println("3 - Bakiye güncelleme işlemleri");
            System.out.println("0 - Önceki menüye dön");
            System.out.println("Seçiminiz: ");
            secim = sc.nextInt();
            switch (secim) {
                case 1:
                    System.out.println(hesap.getId() + " ID'li hesabı silmek istediğinize emin misiniz (Yes/No)");
                    String cevap = sc.nextLine();
                    if (cevap.equalsIgnoreCase("Yes")) {
                        musteri.getHesaplar().remove(hesap);
                        musteriController.update(musteri);
                    }
                    //hesapConroller.deleteById(hesap.getId());

                    else
                        System.out.println("Yes yazmadığınız için işlem iptal edildi.");

                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hatalı giriş.");

            }
        } while (secim != 0);
    }

    public int menu() {
        int secim = 0;
        System.out.println("Hoşgeldin lütfen yapılacak işlemi seç:");
        System.out.println("1- Yeni Müşteri Oluştur.");
        System.out.println("2- Giriş Yap");
        System.out.println("0- Çıkış Yap");
        secim = sc.nextInt();
        sc.nextLine();

        switch (secim) {
            case 1:
                System.out.println("Kullanıcı adınız:");
                String nickname = sc.nextLine();
                System.out.println("Şifreniz:");
                String pass = sc.nextLine();
                System.out.println("Adınız");
                String ad = sc.nextLine();
                System.out.println("Soyadınız:");
                String soyad = sc.nextLine();
                System.out.println("Hangi Şehirde ikamet ediyorsunuz?");
                String sehir = sc.nextLine();
                bankaController.findAll().forEach(x -> System.out.println(x.getId() + "-" + x.getAd()));
                temp = bankaController.findById(sc.nextInt()).get();
                sc.nextLine();
                System.out.println("Banka eklendi.");
                System.out.println("Lütfen hesap türü id'sini seçin");
                for (EHesapTipi value : EHesapTipi.values()) {
                    System.out.println((value.ordinal() + 1) + " - " + value.name());
                }
                EHesapTipi hesapTipi = EHesapTipi.values()[sc.nextInt() - 1];
                sc.nextLine();
                Hesap hesap = Hesap.builder().hesapTipi(hesapTipi).build();
                Adres adres = Adres.builder().ulke("Türkiye").sehir(sehir).build();
                Musteri musteri1 = Musteri.builder().ad(ad).soyad(soyad).adres(adres).password(pass).username(nickname).banka(temp).hesaplar(List.of(hesap)).build();
                adres.setMusteri(musteri1);
                hesap.setMusteri(musteri1);
                musteri = musteriController.save(musteri1);
                System.out.println("Kayıt başarılı");
                temp = musteri.getBanka();
                System.out.println(temp.getAd());
                break;
            case 2:
                System.out.println("Lütfen kullanıcı adınızı girin.");
                String username = sc.nextLine();
                System.out.println("Lütfen şifrenizi girin.");
                String password = sc.nextLine();
                List<Musteri> byEntity = musteriController.findByEntity(Musteri.builder().username(username).password(password).build());
                if (byEntity.size() == 0) {
                    System.out.println("Hatalı giriş yaptın.");
                } else {
                    musteri = byEntity.get(0);
                    temp = musteri.getBanka();
                }
                break;
            case 0:
                System.out.println("Çıkış yapılıyor.");
                System.exit(0);
            default:
                System.out.println("Hatalı giriş.");
        }
        return secim;
    }


}
