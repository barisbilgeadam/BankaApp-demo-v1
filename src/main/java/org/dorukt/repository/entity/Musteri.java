package org.dorukt.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data // get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //tüm attributelarla constuctor oluşturur
@Entity
@Table(name = "tblmusteri")
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "musteriid")
    Integer id;
    String ad;
    String soyad;
    String username;
    String password;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "musteri")
    List<Hesap> hesaplar;


    @ManyToOne()
    Banka banka;

    /*
    Fetch Type:
    FetchType.EAGER: Aceleci. Bağlı olduğu ne var ne yok toplayıp getirir.
    FetchType.LAZY :  Sadece gerekli nesneyi döner. Bağlı olduklarını dönmez.
     */

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Adres> adresList;
}
