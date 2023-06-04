package org.dorukt.repository;

import org.dorukt.repository.entity.Adres;
import org.dorukt.repository.entity.Musteri;
import org.dorukt.utility.MyFactoryRepository;

public class AdresRepository extends MyFactoryRepository<Adres,Integer> {
    public AdresRepository() {
        super(new Adres());
    }
}
