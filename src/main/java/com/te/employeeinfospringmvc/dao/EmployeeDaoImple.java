package com.te.employeeinfospringmvc.dao;

import java.util.List;

import javax.net.ssl.X509ExtendedTrustManager;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.te.employeeinfospringmvc.bean.EmployeeBean;

@Repository
public class EmployeeDaoImple implements EmployeeDao {

	@Override
	public EmployeeBean authenticate(int id, String password) {
		// System.out.println(password);
		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = Persistence.createEntityManagerFactory("springdb");
			manager = factory.createEntityManager();

			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			System.out.println(bean);

			if (bean != null) {
				if (bean.getPassword().equalsIgnoreCase(password)) {
					System.out.println("Login Success");
					return bean;
				} else {
					System.out.println("wrong credentials");
					return null;
				}
			} else {
				System.out.println("user does not exist");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = Persistence.createEntityManagerFactory("springdb");
			manager = factory.createEntityManager();

			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			System.out.println(bean);
			return bean;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}
	}

	@Override
	public boolean delete(int id) {

		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("springdb");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			EmployeeBean bean = manager.find(EmployeeBean.class, id);
			if (bean != null) {
				manager.remove(bean);
				transaction.commit();
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}	
	}

	@Override
	public List<EmployeeBean> getAllData() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			factory = Persistence.createEntityManagerFactory("springdb");
			manager.getEntityManagerFactory().createEntityManager();
			String query="from EmployeeBean";
			List<EmployeeBean> employeeBean=(List<EmployeeBean>) manager.createQuery(query);
			if (employeeBean != null) {
				return employeeBean;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		finally {
			if (factory != null) {
				factory.close();
			}
			if (manager != null) {
				manager.close();
			}
		}

	}

}
