package org.top.kitchendb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends CrudRepository<Menu, Integer> {
    Iterable<Menu> findAllByOrderByTitle(); //сортировка в алфавитном порядке
}
