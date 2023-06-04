package org.dorukt.controller;


import org.dorukt.repository.entity.Musteri;
import org.dorukt.service.MusteriService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MusteriController {
    Scanner sc;
    MusteriService musteriService;

    public MusteriController() {
        musteriService = new MusteriService();
        sc = new Scanner(System.in);
    }
    public Musteri save(Musteri musteri) {
        return musteriService.save(musteri);
    }


    public Iterable<Musteri> saveAll(Iterable<Musteri> entities) {
        musteriService.saveAll(entities);
        return entities;

    }

    public Musteri update(Musteri entity) {
        musteriService.update(entity);
        return entity;
    }


    public Iterable<Musteri> updateAll(Iterable<Musteri> entities) {
        musteriService.updateAll(entities);
        return entities;
    }


    public boolean delete(Musteri entity) {
        return musteriService.delete(entity);
    }


    public boolean deleteById(Integer id) {
        return musteriService.deleteById(id);
    }


    public Optional<Musteri> findById(Integer id) {
        return musteriService.findById(id);
    }


    public List<Musteri> findByEntity(Musteri entity) {
        return musteriService.findByEntity(entity);
    }


    public boolean existById(Integer id) {
        return musteriService.existById(id);
    }


    public List<Musteri> findAll() {
        return musteriService.findAll();
    }


    public List<Musteri> findAllByColomnNameAndValue(String column, String columnValue) {
        return musteriService.findAllByColomnNameAndValue(column, columnValue);
    }


}
