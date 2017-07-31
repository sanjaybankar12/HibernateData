package com.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dao.Address;
import com.dao.Employee;

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
			
			Address ad=new Address();
			ad.setCity("Pune");
			ad.setState("MH");
			
			Employee e=new Employee();
			e.setId(1);
			e.setName("Sanjay");
			e.setSal(60000);
			e.setAddr(ad);
						
			s.save(e);
			
			tr.commit();
			s.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
