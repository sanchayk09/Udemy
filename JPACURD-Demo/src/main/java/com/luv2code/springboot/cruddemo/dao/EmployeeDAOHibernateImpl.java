package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

	private EntityManager entityManager;
	
	@Autowired
	 public EmployeeDAOHibernateImpl(EntityManager theentityManager) {
		
		 entityManager=theentityManager;
	}
	
	@Override
	
	public List<Employee> findAll() {
		
		//create the current hibernate session
		Session currentSession=entityManager.unwrap(Session.class);
		//create the query
		Query<Employee> theQuery =currentSession.createQuery("from Employee",Employee.class);
		//excecute the query ang get result
		List<Employee> empList=theQuery.getResultList();
		
		//return the result
		return empList;
	}

	@Override
	public Employee findByID(int id) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		Employee emp=currentSession.get(Employee.class,id);
		return emp;
	}

	@Override
	public void save(Employee theEmployee) {
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.save(theEmployee);
		
	}

	@Override
	public void deleteByID(int id) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query theQuery=currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId",id);
		theQuery.executeUpdate();
	}

}
