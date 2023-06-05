package org.dorukt.repository.entity;

import lombok.*;
import org.dorukt.repository.enums.EHesapTipi;

import javax.persistence.*;
import java.time.LocalDate;

@Builder // bir sınıftan nesne türetmeyi sağlar.
@Data // get set metodlarını otomatik tanımlar.
@NoArgsConstructor //boş constructor oluşturur.
@AllArgsConstructor //tüm attributelarla constuctor oluşturur
@Entity
@Table(name = "tblhesap")
public class Hesap {
    /*
    Küçük bir güncelleme...
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Builder.Default
    Long bakiye=0L;
    @Enumerated(EnumType.STRING)
    EHesapTipi hesapTipi;
    @Builder.Default
    LocalDate acilmaTarihi=LocalDate.now();
    /*    @ManyToOne()
       @JoinColumn(name="musteriid", nullable=false,referencedColumnName = "musteriid")
      @ToString.Exclude

*/
    @ManyToOne()
    Musteri musteri;


}
