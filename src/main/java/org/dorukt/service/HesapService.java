package org.dorukt.service;

import org.dorukt.repository.AdresRepository;
import org.dorukt.repository.HesapRepository;
import org.dorukt.repository.entity.Adres;
import org.dorukt.repository.entity.Hesap;
import org.dorukt.utility.MyFactoryService;

public class HesapService extends MyFactoryService<HesapRepository, Hesap,Integer> {
    public HesapService() {
        super(new HesapRepository());
    }
}
