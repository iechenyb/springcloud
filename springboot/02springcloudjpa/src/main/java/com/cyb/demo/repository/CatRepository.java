package com.cyb.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.cyb.demo.bean.Cat;

public interface CatRepository extends CrudRepository<Cat, Integer>{

}
