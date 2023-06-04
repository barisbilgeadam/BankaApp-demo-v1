package org.dorukt.controller;

import org.dorukt.repository.entity.Banka;
import org.dorukt.repository.entity.Hesap;
import org.dorukt.service.HesapService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class HesapConroller {
    Scanner sc;
    HesapService hesapService;


    public HesapConroller() {
        hesapService = new HesapService();
        sc = new Scanner(System.in);
    }
    public Hesap save(Hesap hesap) {
        return hesapService.save(hesap);
    }


    public Iterable<Hesap> saveAll(Iterable<Hesap> entities) {
        hesapService.saveAll(entities);
        return entities;

    }

    public Hesap update(Hesap entity) {
        hesapService.update(entity);
        return entity;
    }


    public Iterable<Hesap> updateAll(Iterable<Hesap> entities) {
        hesapService.updateAll(entities);
        return entities;
    }


    public boolean delete(Hesap entity) {
        return hesapService.delete(entity);
    }


    public boolean deleteById(Integer id) {
        return hesapService.deleteById(id);
    }


    public Optional<Hesap> findById(Integer id) {
        return hesapService.findById(id);
    }


    public List<Hesap> findByEntity(Hesap entity) {
        return hesapService.findByEntity(entity);
    }


    public boolean existById(Integer id) {
        return hesapService.existById(id);
    }


    public List<Hesap> findAll() {
        return hesapService.findAll();
    }


    public List<Hesap> findAllByColomnNameAndValue(String column, String columnValue) {
        return hesapService.findAllByColomnNameAndValue(column, columnValue);
    }
}
