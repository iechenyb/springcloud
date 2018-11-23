package com.cyb.web;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *作者 : iechenyb<br>
 *类描述: 说点啥<br>
 *创建时间: 2018年11月13日
 */
class Entity {
	
}

@RestController
public class RestFullController {
	Log log = LogFactory.getLog(RestFullController.class);
	
	@GetMapping("Entity/{id}")
	public String getObject(@PathVariable String id ){
		
		return id;
	}
	
	@GetMapping("Entitys")
	public String getObjects(String condition){
		return condition;
	}
	
	@PutMapping("Entitys/{id}")
	public String updateObject(@PathVariable String id
			,@RequestBody String object){
		return object;
	}
	
	@DeleteMapping("Entity/{id}")
	public String deleteObject(@PathVariable String id){
		return id;
	}
	
	
}
