package com.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dao.Employee;
import com.dao.SalesPerson;
import com.dao.WageEmp;

public class HibMain {

	public static void main(String[] args) {

		try{
			
			Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
			
			StandardServiceRegistryBuilder srrb=new StandardServiceRegistryBuilder(); 
			srrb.applySettings(cfg.getProperties());
			StandardServiceRegistry sr=srrb.build();
			
			SessionFactory sf=cfg.buildSessionFactory(sr);
			Session s=sf.openSession();
			Transaction tr=s.beginTransaction();
			
			Employee e=new Employee();
			e.setId(1);
			e.setName("Sanjay");
			e.setSal(60000);
			
			WageEmp we=new WageEmp();
			we.setId(2);
			we.setName("Ashu");
			we.setSal(25000);
			we.setHr(12);
			we.setRt(20);
			
			SalesPerson sp=new SalesPerson();
			sp.setId(3);
			sp.setName("Ravi");
			sp.setSal(30000);
			sp.setComm(2500);
			
			s.save(e);
			s.save(we);
			s.save(sp);
			
			tr.commit();
			s.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
