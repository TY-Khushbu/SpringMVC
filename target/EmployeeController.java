package com.te.employeeinfospringmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.te.employeeinfospringmvc.bean.EmployeeBean;
import com.te.employeeinfospringmvc.dao.EmployeeDao;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDao dao;
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String getLogin(int id, String password, HttpServletRequest request,ModelMap map) {
		EmployeeBean bean=dao.authenticate(id, password);
		if (bean!=null) {
			HttpSession session=request.getSession(true);
			session.setAttribute("emp",bean);
			return "home";		
		}else {
			map.addAttribute("errmsg","invalid Credentials");
		}
		return "login";
	}

}
