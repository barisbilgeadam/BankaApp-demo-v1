package org.dorukt.service;

import org.dorukt.repository.AdresRepository;
import org.dorukt.repository.MusteriRepository;
import org.dorukt.repository.entity.Adres;
import org.dorukt.repository.entity.Musteri;
import org.dorukt.utility.MyFactoryService;

public class MusteriService extends MyFactoryService<MusteriRepository, Musteri, Integer> {
    public MusteriService() {
        super(new MusteriRepository());
    }
}
