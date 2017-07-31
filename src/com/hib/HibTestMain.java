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

import com.dao.Movie;
import com.dao.Song;

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
			
			Song s1=new Song();
			s1.setName("Jane kyu..");
			
			Song s2=new Song();
			s2.setName("Dil Chahata Hai");
			
			List<Song> slist=new ArrayList<>();
			slist.add(s1);
			slist.add(s2);
			
			Movie mv=new Movie();
			mv.setName("Dil Chahata Hai");
			mv.setSongs(slist);
			
			s.save(mv);
			
			tr.commit();
			s.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
