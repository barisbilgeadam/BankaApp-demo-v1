package org.dorukt.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data // get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //tüm attributelarla constuctor oluşturur
@Entity
@Table(name = "tbladres")
public class Adres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String ulke;
    String sehir;

    @ManyToMany(mappedBy = "adresList")
    List<Musteri> musteriList;

}
