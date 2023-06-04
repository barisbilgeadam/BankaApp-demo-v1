package org.dorukt.controller;

import org.dorukt.repository.entity.Adres;
import org.dorukt.repository.entity.Banka;
import org.dorukt.service.AdresService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AdresController {
    Scanner sc;
    AdresService adresService;

    public AdresController() {
        adresService = new AdresService();
        sc = new Scanner(System.in);
    }

    public Adres save(Adres adres) {
        return adresService.save(adres);
    }


    public Iterable<Adres> saveAll(Iterable<Adres> entities) {
        adresService.saveAll(entities);
        return entities;

    }

    public Adres update(Adres entity) {
        adresService.update(entity);
        return entity;
    }


    public Iterable<Adres> updateAll(Iterable<Adres> entities) {
        adresService.updateAll(entities);
        return entities;
    }


    public boolean delete(Adres entity) {
        return adresService.delete(entity);
    }


    public boolean deleteById(Integer id) {
        return adresService.deleteById(id);
    }


    public Optional<Adres> findById(Integer id) {
        return adresService.findById(id);
    }


    public List<Adres> findByEntity(Adres entity) {
        return adresService.findByEntity(entity);
    }


    public boolean existById(Integer id) {
        return adresService.existById(id);
    }


    public List<Adres> findAll() {
        return adresService.findAll();
    }


    public List<Adres> findAllByColomnNameAndValue(String column, String columnValue) {
        return adresService.findAllByColomnNameAndValue(column, columnValue);
    }
}
