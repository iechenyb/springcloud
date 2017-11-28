package com.cyb.demo.repository;

import org.springframework.data.repository.Repository;

import com.cyb.demo.bean.Cat;

public interface Cat2Repository extends Repository<Cat, Integer>{
 public Cat findByCatName(String catName);
}
