package com.hib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.dao.User;

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
			
			Query q=s.createQuery("from User u");
			List<User> list=q.list();
			Iterator<User> it=list.iterator();
			while(it.hasNext())
			{
				User u=it.next();
				System.out.println(u);
			}
			
			Criteria cr=s.createCriteria(User.class);
			cr.add(Restrictions.like("name", "%jay"));
			list=cr.list();
			it=list.iterator();
			while(it.hasNext())
			{
				User u=it.next();
				System.out.println(u);
			}
			
			
			tr.commit();
			s.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
