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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
			
			System.out.println();			
			System.out.println("*********** Using Named Parameter *******");
			
			Query q=s.createQuery("from User u where u.id=:s");
			q.setInteger("s",1);
			List<User> list=q.list();
			Iterator<User> it=list.iterator();
			while(it.hasNext())
			{
				User u=it.next();
				System.out.println(u);
			}
			
			System.out.println();			
			System.out.println("*********** Using Named Query and Positional Parameter *******");
						
			Query q1=s.getNamedQuery("UserBy.ID");
			q1.setInteger(0,2);
			List ls=q1.list();
			Iterator<String> its=ls.iterator();
			while(its.hasNext())
			{
				String name=its.next();
				System.out.println(name);
			}
			
			System.out.println();			
			System.out.println("*********** Using Named Native Query and Positional Paramete *******");
			
			Query q2=s.getNamedQuery("NativeUserBy.NAME");
			q2.setString(0,"Ashu");
			List ls2=q2.list();
			Iterator its2=ls2.iterator();
			while(its2.hasNext())
			{
				Object[] uarr=(Object[])its2.next();
				for(Object o:uarr)
					System.out.print(o+" ");
			}			
			
			System.out.println();			
			System.out.println("*********** Using Criteria  *******");
			
			Criteria cr=s.createCriteria(User.class);
			cr.add(Restrictions.like("name", "%jay"));
			cr.add(Restrictions.eq("id", 1));
			list=cr.list();
			it=list.iterator();
			while(it.hasNext())
			{
				User u=it.next();
				System.out.println(u);
			}
			
			System.out.println();			
			System.out.println("*********** Using Criterion with or condition *******");
			
			Criteria cr2=s.createCriteria(User.class);
			Criterion c1=Restrictions.like("name", "%jay");
			Criterion c2=Restrictions.eq("id", 2);
			cr2.add(Restrictions.or(c1,c2));
			cr2.addOrder(Order.desc("id"));
			list=cr2.list();
			it=list.iterator();
			while(it.hasNext())
			{
				User u=it.next();
				System.out.println(u);
			}
			
			System.out.println();			
			System.out.println("*********** Using Projections with criteria *******");
			
			cr2=s.createCriteria(User.class);
			cr2.setProjection(Projections.sum("id"));
			Iterator<Long> it2=cr2.list().iterator();
			while(it2.hasNext())
			{
				long sum_id=it2.next();
				System.out.println(sum_id);
			}
			
			tr.commit();
			s.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
