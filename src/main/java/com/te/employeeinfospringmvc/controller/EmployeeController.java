package com.te.employeeinfospringmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.employeeinfospringmvc.bean.EmployeeBean;
import com.te.employeeinfospringmvc.dao.EmployeeDao;
import com.te.employeeinfospringmvc.service.EmployeeServiceInterface;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeServiceInterface dao;

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
	} //End of Authenticate


	@GetMapping("/search")
	public String getSearchForm(ModelMap map,HttpSession session) {

		if (session.getAttribute("emp")!=null){
			return "search";		
		}else {
			map.addAttribute("errmsg","Please Login forst");
			return "login";
		}

	} //End of getSearchForm


	@GetMapping("/search1")
	public String searchEmp(int id, ModelMap map, 
			@SessionAttribute(name="emp",required = false) EmployeeBean employeeBean) {
		if (employeeBean!=null) {
			EmployeeBean employeeBean2=dao.getEmployee(id);
			if (employeeBean2!=null) {
				map.addAttribute("data",employeeBean2);			
			}else {
				map.addAttribute("errmsg","data not found for "+id);
			}
			return "search";
		}
		else {
			map.addAttribute("errmsg","Please Login first");
			return "login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session,ModelMap map) {
		session.invalidate();
		map.addAttribute("errmsg","Please Login first");
		return "login";		
	} //End of Logout
	
	
	@GetMapping("/delete")
		public String deleteEmp(int id,ModelMap map,@SessionAttribute(name="emp") EmployeeBean employeeBean) {
			if (employeeBean!=null) {
				boolean isDelete=dao.delete(id);
				if (isDelete) {
					map.addAttribute("msg","deleted successfully");			
				}else {
					map.addAttribute("errmsg","records not found in db");
				}
				return "delete";
			}
			else {
				map.addAttribute("msg","Please Login first");
				return "login";
			}
			
	}		
} //End of controller
