package kr.or.possys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.possys.drop_food_service.Drop_Dao;


@Controller
public class Drop_Food_Controller {

	@Autowired
	private Drop_Dao dao;
	
	
	//drop �Է��� ��û
	@RequestMapping(value="/drop_add_form", method = RequestMethod.GET)
	public String foodadd(){
		System.out.println("01_FoodController.java ->>foodadd �� ��û");
		return "/wonbin/drop_food/drop_add_form";
	}
//	//����� �Է¾׼� ��û
//	@RequestMapping(value="/food_add_form", method = RequestMethod.POST)
//	public String foodadd(Food food){
//		System.out.println("02_FoodController.java ->>foodadd �׼� ��û");
//		dao.insertfood(food);
//		return "redirect:/food_list";
//	}
//	//����� ��� ��û
//	@RequestMapping(value="/food_list", method = RequestMethod.GET)
//	public String foodlist(Model model, @RequestParam(value="currentPage",required=false,defaultValue="1") int currentPage){
//		System.out.println("FoodController.java ->>foodlist ��û");
//		int foodcount = dao.getfoodcount();
//		int pageRow = 20;
//		int lastPage = (int)(Math.ceil((double)foodcount/(double)pageRow));
//		List<Food> list = dao.foodlist(currentPage, pageRow);
//		
//		model.addAttribute("pageRow",pageRow);
//		model.addAttribute("foodcount", foodcount);
//		model.addAttribute("currentPage", currentPage);
//		model.addAttribute("lastPage", lastPage);
//		model.addAttribute("list", list);
//		return "/wonbin/food_manage/food_list";
//	}
//	//����� ����ȭ�� ��û
//	@RequestMapping(value="/food_modify_view", method = RequestMethod.GET)
//	public String foodview(Model model, @RequestParam(value="food_id",required=true) String food_id){
//		System.out.println("FoodController.java ->>foodview ��û");
//		Food food = dao.foodview(food_id);
//		model.addAttribute("food",food);
//		return "/wonbin/food_manage/food_modify_view";
//	}
//	//����� �����׼� ��û
//	@RequestMapping(value="/food_modify", method = RequestMethod.POST)
//	public String foodmodify(Food food){
//		System.out.println("FoodController.java ->>foodmodify ��û");
//		dao.foodmodify(food);
//		return "redirect:/food_modify_view?food_id="+food.getFood_id();
//		
//	}
//	//����� ���� ��û
//	@RequestMapping(value="/food_delete", method = RequestMethod.GET)
//	public String fooddelete(@RequestParam(value="food_id", required=true) String food_id){
//		dao.fooddelete(food_id);
//		return "redirect:/food_list";
//	}
	
	
}