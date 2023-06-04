package org.dorukt.service;

import org.dorukt.repository.BankaRepository;
import org.dorukt.repository.entity.Banka;
import org.dorukt.utility.MyFactoryService;

public class BankaService extends MyFactoryService<BankaRepository, Banka,Integer> {
    public BankaService() {
        super(new BankaRepository());
    }
}
