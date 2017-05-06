package kr.or.possys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.possys.Payment_service.Payment;
import kr.or.possys.Payment_service.Payment_Dao;

@Controller
public class Payment_Controller {
	@Autowired
	private Payment_Dao pdao;
	
	// view �������� ����� ǥ�õǵ��� �ϱ� ���ؼ� �ٸ� ��Ʈ�ѷ��� ��Ʈ(/) ���� ��� ����ų� �ּ�ó���س���
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String start(){
		System.out.println("start");
		return "tori_home";
	}
	
	//����Ʈ �Է� ������ �̵��Ѵ�
	@RequestMapping(value="/tori/payment/payment_add_form", method = RequestMethod.GET)
	public String paymentadd(){
		System.out.println("01 Payment_Controller.java -> paymentadd");
		return "/tori/payment/payment_add_form";
		//tori_home���� ������ ��ο� ���ΰ�ΰ� �� ���ϰ��� ��ġ�ϰԲ� �����Ѵ�.
		
	}
	
	//�Է� ��û : �׼����� �̵��Ѵ�
	@RequestMapping(value="/tori/payment/payment_add_action", method = RequestMethod.POST)
	public String paymentadd(Payment Payment){
		System.out.println("01_1 Payment_Controller.java -> paymentadd");
		
		String id = Payment.getPayment_id();
		System.out.println(id+"<------ ��Ʈ�ѷ� �� Ȯ�� ");
		
		
		pdao.insertPayment(Payment);
		return "redirect:/tori/payment/payment_list";
		
	}
	
	@RequestMapping(value={"/tori/payment/payment_list"}, method = RequestMethod.GET)
	public String paymentlist(Model model,@RequestParam(value="currentpage",required=false,defaultValue="1") int currentPage){
		System.out.println("02_Payment_Controller.java -> paymentlist");
		int paymentcount = pdao.getPaymentCount();
		int pageRow = 20;
		int lastPage = (int)(Math.ceil(paymentcount/pageRow));
		List<Payment> list = pdao.getPaymentList(currentPage, pageRow);
		System.out.println(paymentcount);
		System.out.println(Math.ceil(paymentcount/pageRow));
		System.out.println(lastPage);
		
		model.addAttribute("paymentcount", paymentcount);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("paymentcount", paymentcount);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("list",list);
		
		return "/tori/payment/payment_list";
		
	}
	
	
}
