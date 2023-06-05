package org.dorukt;

import org.dorukt.controller.AdresController;
import org.dorukt.controller.BankaController;
import org.dorukt.controller.HesapConroller;
import org.dorukt.controller.MusteriController;
import org.dorukt.repository.MusteriRepository;
import org.dorukt.repository.entity.Adres;
import org.dorukt.repository.entity.Banka;
import org.dorukt.repository.entity.Hesap;
import org.dorukt.repository.entity.Musteri;
import org.dorukt.repository.enums.EHesapTipi;
import org.dorukt.service.AdresService;
import org.dorukt.service.HesapService;
import org.dorukt.service.MusteriService;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.ArrayList;
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
        AdresService adresService=new AdresService();
        MusteriService musteriService=new MusteriService();
        HesapService hesapService=new HesapService();



        Adres a1= Adres.builder().sehir("Adana").build();
        Adres a2= Adres.builder().sehir("Erzurum").build();

        Musteri m1= Musteri.builder().ad("Engin").adresList(List.of(a1,a2)).build();
        Musteri m2= Musteri.builder().ad("Atamert").adresList(List.of(a1,a2)).build();

        musteriService.save(m1);
        musteriService.save(m2);



        System.out.println("--------Müşteriler-------------");
        musteriService.findAll().forEach(x->{
            System.out.print(x.getAd());
            for (Adres adres:x.getAdresList()) {
                System.out.print(" "+adres.getSehir());
            }
            System.out.println();
        });
        //Adresler hangi müşteriye ait onu görebilir miyiz?
        //@OneToOne(mappedBy = "adres") eklendikten sonra görebiliriz.
        System.out.println("--------Adresler-------------");
        adresService.findAll().forEach(x->{
            System.out.print(x.getSehir());
            for (Musteri musteri1:x.getMusteriList()) {
                System.out.print(" "+musteri1.getAd());
            }
            System.out.println();
        });


       // Entity - Nesne(a1)
      /*  Hesap h1= Hesap.builder().bakiye(50L).hesapTipi(EHesapTipi.TL).build();
        Hesap h2= Hesap.builder().bakiye(150L).hesapTipi(EHesapTipi.DOLAR).build();

        List<Hesap> liste=new ArrayList<>();
        liste.add(h1);
        liste.add(h2);*/
        //hesapService.saveAll(liste);
        /*Musteri m1= Musteri.builder().ad("Engin").hesaplar(liste).build();
        h1.setMusteri(m1);
        h2.setMusteri(m1);
        musteriService.save(m1);*/

        //Musteriye bağlı hesaplardan birini silme:
    /*    Musteri m2= musteriService.findById(1).get();
        Hesap hesap1=m2.getHesaplar().get(0);

        hesapService.delete(hesap1);*/
        //id'si 1 olan müşteriye yeni bir hesap ekleme:
        /*Hesap hesap2= Hesap.builder().hesapTipi(EHesapTipi.EURO).bakiye(25000L).build();
        hesap2.setMusteri(musteriService.findById(1).get());
        hesapService.save(hesap2);*/

        //id'si 1 olan müsterinin hesabındaki para kadar hesabına para ekleyelim.
      /*  Hesap hesap1=musteriService.findById(1).get().getHesaplar().get(0);
        hesap1.setBakiye(50000L);
        hesapService.update(hesap1);*/

        //olan müşteriye diğer hesaplardan da tanımlama:
      /*   Musteri musteri1=musteriService.findById(1).get();
       Hesap hesap2= Hesap.builder().hesapTipi(EHesapTipi.TL).bakiye(50000L).musteri(musteri1).build();
        Hesap hesap3= Hesap.builder().hesapTipi(EHesapTipi.DOLAR).bakiye(30000L).musteri(musteri1).build();

        List<Hesap> hesapList=new ArrayList<>();
        hesapList.add(hesap2);
        hesapList.add(hesap3);
        musteri1.setHesaplar(hesapList);

        musteriService.update(musteri1);*/

        //Bir müşterinin tüm hesaplarını silelim:
      /*  Musteri musteri1=musteriService.findById(1).get();
        List<Hesap> liste=musteri1.getHesaplar();
        for (Hesap hesap:liste ) {

            hesapService.delete(hesap);
        }
*/

        // Illegal attempt to associate a collection with two open sessions.

    /*    Musteri m1 = musteriService.findById(1).get();
        List<Hesap> hesaplar = m1.getHesaplar();

        hesaplar.add(Hesap.builder().hesapTipi(EHesapTipi.EURO).musteri(m1).bakiye(1000l).build());

        musteriService.update(m1);*/



        /*m1.getHesaplar().add();
        musteriService.update(m1);*/


      /*  System.out.println("---------MUSTERİLER-------------");
        // musteri ile beraber hesap bilgileri de gelir.
        musteriService.findAll().forEach(x->{
            System.out.print(x.getId()+" "+x.getAd()+" ");
            for (Hesap h:x.getHesaplar() ) {
                System.out.print(h.getBakiye()+" "+h.getHesapTipi());
            }
            System.out.println();
        });

        System.out.println("---------HESAPLAR-------------");*/
        //bu hesabın sahibi kim?
       /* hesapService.findAll().forEach(x->{
            System.out.println(x.getBakiye()+" "+x.getHesapTipi()+" "+x.getMusteri().getAd());
        });*/






      /*//  @OneToOne(cascade = CascadeType.ALL) ifadesi eklendikten sonra kaldırdık
        adresService.save(a1);
        Musteri m1= Musteri.builder().ad("Engin").build();

        Adres a1= Adres.builder().ulke("Tr").sehir("Ankara").musteri(m1).build();

        Adres a2= Adres.builder().ulke("Tr").sehir("Antalya").musteri(m1).build();


        adresService.save(a1);

        @JoinColumn(unique = true) bu ifade ile adres tablosunda aynı musteriden 2 defa bulunamayacak.

        //adresService.save(a2);
      //  musteriService.save(m1);


        @OneToOne(cascade = CascadeType.ALL) ifadesi sayesinde
        müşteri silinirken ona ait olan adres de silinir.
        musteriService.deleteById(1);
        //Musterileri adresleriyle gösterebiliyor.
        System.out.println("--------Müşteriler-------------");
        musteriService.findAll().forEach(x->{
            System.out.println(x.getAd()+" "+x.getAdres().getUlke()+" "+x.getAdres().getSehir());
        });
        //Adresler hangi müşteriye ait onu görebilir miyiz?
        //@OneToOne(mappedBy = "adres") eklendikten sonra görebiliriz.
        System.out.println("--------Adresler-------------");
        adresService.findAll().forEach(x->{
            System.out.println(x.getUlke()+" "+x.getSehir()+" "+x.getMusteri().getAd());
        });*/



      /*  Uygulama uyg1 = new Uygulama();
        uyg1.defaultData();
        do {
            uyg1.menu();
        } while (uyg1.musteri == null);

        uyg1.hosgeldin();*/
     /*   hesaplar();
        musteriler();
        hesaplar();*/

    }

    private static void hesaplar() {
        HesapConroller hesapConroller1=new HesapConroller();
      //  hesapConroller1.deleteById(2);
        System.out.println("hesaplar...");
        System.out.println( hesapConroller1.findAll().size());
        hesapConroller1.findAll().forEach(x->{
            System.out.println(x);
           // System.out.println(x.getMusteri());
        });
    }
    private static void musteriler() {
        MusteriController musteriController1=new MusteriController();
        HesapConroller hesapConroller1=new HesapConroller();
//        musteriController1.deleteById(1);
        Musteri hesabiSilinecekMusteri= musteriController1.findById(4).get();
        List<Hesap> hesapList=hesabiSilinecekMusteri.getHesaplar();
        hesapConroller1.delete(hesapList.get(0));
        hesapList.remove(hesapList.get(0));

        musteriController1.update(hesabiSilinecekMusteri);

        System.out.println("musteirler...");
        System.out.println( musteriController1.findAll().size());
        musteriController1.findAll().forEach(x->{
            System.out.println(x);
        });
    }


    private void hesaplariGoster() {
        for (Hesap hesap1 : musteri.getHesaplar()) {
            System.out.println("ID:" + hesap1.getId() + " - " + hesap1.getHesapTipi() + " hesabınızdaki güncel bakiye: " + hesap1.getBakiye());
        }
    }

   /* public void defaultData() {

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
    }*/

   /* private void hosgeldin() {
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
    }*/

   /* private void yeniHesapAc() {
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

    }*/

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

   /* public int menu() {
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
    }*/


}
