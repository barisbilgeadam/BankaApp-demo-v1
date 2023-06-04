package org.dorukt.repository;

import org.dorukt.repository.entity.Musteri;
import org.dorukt.utility.MyFactoryRepository;

public class MusteriRepository extends MyFactoryRepository<Musteri,Integer> {
    public MusteriRepository() {
        super(new Musteri());
    }
}
