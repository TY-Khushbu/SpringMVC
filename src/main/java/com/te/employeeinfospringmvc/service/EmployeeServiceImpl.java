package com.te.employeeinfospringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.employeeinfospringmvc.bean.EmployeeBean;
import com.te.employeeinfospringmvc.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface{
	


	@Autowired
	EmployeeDao dao;
	@Override
	public EmployeeBean authenticate(int id, String password) {
		// TODO Auto-generated method stub
		return dao.authenticate(id, password);
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployee(id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public List<EmployeeBean> getAllData() {
		// TODO Auto-generated method stub
		return dao.getAllData();
	}

}
