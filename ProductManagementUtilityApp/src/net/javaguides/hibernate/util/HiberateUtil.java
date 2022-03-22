package net.javaguides.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import net.javaguides.hibernate.model.User;

//for user / login class
public class HiberateUtil {
	private static SessionFactory sessionfactory=null;
	public static SessionFactory getsessionfactory()
	{  
		if(sessionfactory==null) {
			Configuration con = new Configuration().configure("Configuration.xml").addAnnotatedClass(User.class);
			ServiceRegistry reg  = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
			SessionFactory sessionfactory = con.buildSessionFactory(reg);
			return sessionfactory;
		}
		return sessionfactory;
	}

}
