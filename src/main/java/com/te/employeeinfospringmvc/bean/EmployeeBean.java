package com.te.employeeinfospringmvc.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employee_info")
public class EmployeeBean implements Serializable{
	
	@Id
	private Integer id;
	
	private String name;
	
	private Date dob;
	
	private String password;
	
}
