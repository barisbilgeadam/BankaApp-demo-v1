package org.dorukt.repository;

import org.dorukt.repository.entity.Banka;
import org.dorukt.repository.entity.Hesap;
import org.dorukt.utility.MyFactoryRepository;

public class HesapRepository extends MyFactoryRepository<Hesap,Integer> {
    public HesapRepository() {
        super(new Hesap());
    }
}
