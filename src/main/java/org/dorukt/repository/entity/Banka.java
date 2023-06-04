package org.dorukt.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data // get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //tüm attributelarla constuctor oluşturur
@Entity
@Table(name = "tblbanka")
public class Banka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String ad;
    @OneToMany(mappedBy = "banka")
    @ToString.Exclude
    List<Musteri> musteriler;
}
