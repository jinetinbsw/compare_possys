package kr.or.possys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.possys.Staff_service.Staff;
import kr.or.possys.Staff_service.Staff_Dao;

@Controller
public class Staff_Controller {
	
	@Autowired
	private Staff_Dao sdao;
	
	/*@RequestMapping(value="/", method = RequestMethod.GET)
	public String start(){
		return "home";
	}*/
	
	@RequestMapping(value="/staff_add_form", method = RequestMethod.GET)
	public String staffadd(){
		System.out.println("01 Staff_Controller.java -> staffadd");
		return "/tori/staff/staff_insert_form";
	}
	
	@RequestMapping(value="/staff_add_form", method = RequestMethod.POST)
	public String staffadd(Staff Staff){
		System.out.println("01_1 Staff_Controller.java -> paymentadd");
		sdao.insertStaff(Staff);
		return "redirect:/staff_list";
	}
	
	@RequestMapping(value="/staff_list", method = RequestMethod.GET)
	public String stafflist(Model model, @RequestParam(value="currentpage", required=false, defaultValue="1") int currentPage){
		System.out.println("02_Staff_Controller.java -> stafflist");
		int staffcount = sdao.getStaffCount();
		int pageRow = 20;
		int lastPage = (int)(Math.ceil(staffcount/pageRow));
		List<Staff> list = sdao.getStaffList(currentPage, pageRow);
		System.out.println(staffcount);
		System.out.println(Math.ceil(staffcount/pageRow));
		System.out.println(lastPage);
		
		model.addAttribute("staffcount",staffcount);
		model.addAttribute("currentPage",currentPage);
		model.addAttribute("staffcount",staffcount);
		model.addAttribute("lastPage",lastPage);
		model.addAttribute("list",list);
		
		return "/tori/staff/staff_list";
	}
}
