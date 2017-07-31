package com.hib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.dao.User;
import com.dao.Vehicle;

public class HibTestMain {

	public static void main(String[] args) {
		
		try{
			
			Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
			
			StandardServiceRegistryBuilder srrb=new StandardServiceRegistryBuilder(); 
			srrb.applySettings(cfg.getProperties());
			StandardServiceRegistry sr=srrb.build();
			
			SessionFactory sf=cfg.buildSessionFactory(sr);
			Session s=sf.openSession();
			Transaction tr=s.beginTransaction();
			
			Vehicle v1=new Vehicle();
			v1.setName("BMW");
			
			Vehicle v2=new Vehicle();
			v2.setName("Audi");
			
			User u1=new User();
			u1.setName("Sanjay");
			
			User u2=new User();
			u2.setName("Sanju");
						
			List<User> ulist=new ArrayList<>();
			ulist.add(u1);
			ulist.add(u2);
			
			v1.setUlist(ulist);
			v2.setUlist(ulist);
			
			List<Vehicle> vlist=new ArrayList<>();
			vlist.add(v1);
			vlist.add(v2);
			
			u1.setVlist(vlist);
			u2.setVlist(vlist);
			
			s.save(u1);
			s.save(u2);
			s.save(v1);
			s.save(u2);
			
			tr.commit();
			s.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
