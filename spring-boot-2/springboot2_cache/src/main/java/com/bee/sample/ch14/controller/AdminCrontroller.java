package com.bee.sample.ch14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bee.sample.ch14.entity.Menu;
import com.bee.sample.ch14.pojo.MenuNode;
import com.bee.sample.ch14.service.MenuService;

@Controller
public class AdminCrontroller {

	
	@Autowired
	MenuService menuService;
	
	@RequestMapping("/addmenu.json") 
	public @ResponseBody String add() throws Exception{
		//模拟改变缓存
		return "{\"success\":true}";
	}

	@RequestMapping("/addmenu.json2")
	public @ResponseBody Menu add2() throws Exception{
		Menu menu = new Menu();
		menu.setCode("123");
		menu.setName("abc");
		menu.setId(1L);
		//模拟改变缓存
		return menuService.addMenu2(menu);
	}
	
	@RequestMapping("/getmenu.json") 
	public @ResponseBody Menu getMenu(Long menuId) throws Exception{
		return menuService.getMenu(menuId);
	}
	
	@RequestMapping("/tree.json") 
	public @ResponseBody MenuNode tree() throws Exception{
		return menuService.getMenuTree();
	}
	
	
	
	
	
}
