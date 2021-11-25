package com.h2sm.springmvcrest.services;

import java.util.List;

public interface BaseService <T>{
    List<T> showAllEntities();
    T showByID(int id);
    T findByNamepart(String namepart);
    void insert(T entity);
    void modify(T entity);
    void delete(int id);
}
