package org.dorukt.service;

import org.dorukt.repository.AdresRepository;
import org.dorukt.repository.entity.Adres;
import org.dorukt.utility.MyFactoryRepository;
import org.dorukt.utility.MyFactoryService;

public class AdresService extends MyFactoryService<AdresRepository,Adres,Integer> {
    public AdresService() {
        super(new AdresRepository());
    }
}
