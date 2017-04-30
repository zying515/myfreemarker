package com.myfreemarker.controller;


import com.myfreemarker.bean.ResponseModal;
import com.myfreemarker.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {

	/*@Autowired
    private IUserService userService;*/
	
	@Autowired
	private IRedisService redisService;
	
/*	@RequestMapping("/users")
	public ResponseModal users(){
		List<User> users = userService.getAll();
		ResponseModal modal = new ResponseModal(200,true,"",users);
		return modal;
	}*/
	@RequestMapping(value = "/redis/set", method= RequestMethod.GET)
	public ResponseModal redisSet(@RequestParam("value")String value){
		System.out.println("redisSet.....");
		boolean isOk = redisService.set("name", value);
		return new ResponseModal(isOk ? 200 : 500, isOk, isOk ? "success" : "error" , null);
	}
	
	@RequestMapping("/redis/get")
	public ResponseModal redisGet(){
		String name = redisService.get("name");
		return new ResponseModal(200, true,"success",name);
	}
	
}