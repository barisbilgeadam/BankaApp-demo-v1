package org.dorukt.repository;

import org.dorukt.repository.entity.Banka;
import org.dorukt.utility.MyFactoryRepository;

public class BankaRepository extends MyFactoryRepository<Banka,Integer> {
    public BankaRepository() {
        super(new Banka());
    }
}
