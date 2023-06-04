package org.dorukt.controller;

import org.dorukt.repository.entity.Banka;
import org.dorukt.service.BankaService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class BankaController {

    Scanner sc;
    BankaService bankaService;

    public BankaController() {
        bankaService = new BankaService();
        sc = new Scanner(System.in);
    }

    public Banka save(Banka bank) {
        return bankaService.save(bank);
    }


    public Iterable<Banka> saveAll(Iterable<Banka> entities) {
        bankaService.saveAll(entities);
        return entities;

    }

    public Banka update(Banka entity) {
        bankaService.update(entity);
        return entity;
    }


    public Iterable<Banka> updateAll(Iterable<Banka> entities) {
        bankaService.updateAll(entities);
        return entities;
    }


    public boolean delete(Banka entity) {
        return bankaService.delete(entity);
    }


    public boolean deleteById(Integer id) {
        return bankaService.deleteById(id);
    }


    public Optional<Banka> findById(Integer id) {
        return bankaService.findById(id);
    }


    public List<Banka> findByEntity(Banka entity) {
        return bankaService.findByEntity(entity);
    }


    public boolean existById(Integer id) {
        return bankaService.existById(id);
    }


    public List<Banka> findAll() {
        return bankaService.findAll();
    }


    public List<Banka> findAllByColomnNameAndValue(String column, String columnValue) {
        return bankaService.findAllByColomnNameAndValue(column, columnValue);
    }
}
