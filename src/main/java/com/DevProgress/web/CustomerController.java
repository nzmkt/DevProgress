package com.DevProgress.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.DevProgress.domain.Customer;
import com.DevProgress.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController{
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String list(Model model){
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);	//ビジネスロジックの顧客一覧取得結果をモデルにセットする
		return "customer/list";	//画面のテンプレート「customer/list.html」を呼び出す
	}
	
	
}



