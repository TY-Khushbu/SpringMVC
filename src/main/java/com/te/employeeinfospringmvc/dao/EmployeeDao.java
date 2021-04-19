package com.te.employeeinfospringmvc.dao;

import java.util.List;

import com.te.employeeinfospringmvc.bean.EmployeeBean;

public interface EmployeeDao {
	public EmployeeBean authenticate(int id, String password);
	public EmployeeBean getEmployee(int id);
	public boolean delete(int id);
	public List<EmployeeBean> getAllData();
}
