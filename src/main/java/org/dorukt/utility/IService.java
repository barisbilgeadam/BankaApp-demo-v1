package org.dorukt.utility;

import java.util.List;
import java.util.Optional;

public interface IService<T,ID> {
    //Kaydetme işlemleri
    <S extends T> S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
    <S extends T> S update(S entity);

    <S extends T> Iterable<S> updateAll(Iterable<S> entities);
    //Silme işlemleri
    boolean delete(T entity);
    boolean deleteById(ID id);
    //Arama ve listeleme işlemleri
    Optional<T> findById(ID id);
    /**
     * Bu metod entity içinde bulunan herhangi bir alana göre kendisi otomatik sorgu yapacak.
     * Reflection API kullanılacak.
     * @param entity
     * @return
     */
    List<T> findByEntity(T entity);
    boolean existById(ID id);
    List<T> findAll();
    List<T> findAllByColomnNameAndValue(String column, String columnValue);
}
