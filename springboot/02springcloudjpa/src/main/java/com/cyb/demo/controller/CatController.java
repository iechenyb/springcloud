package com.cyb.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyb.demo.bean.Cat;
import com.cyb.demo.service.CatService;

@RestController
@RequestMapping("/cat")
public class CatController {
	
	@Resource
	private CatService catService;
	
	@RequestMapping("/save")
	public String save(){
		Cat cat = new Cat();
		cat.setCatName("jack");
		cat.setCatAge(3);
		catService.save(cat);
		return "save ok.";
	}
	
	@RequestMapping("/delete")
	public String delete(){
		catService.delete(1);
		return "delete ok";
	}
	
	@RequestMapping("/getAll")
	public Iterable<Cat> getAll(){
		return catService.getAll();
	}
	@RequestMapping("/getCatByName")
	public Cat getCatByName(String catName){
		return catService.findCatByName(catName);
	}
	
	@RequestMapping("/selectCatByName")
	public Cat selectCatByName(String catName){
		return catService.selectCatByName(catName);
	}
}
