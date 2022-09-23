package com.greatlearning;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {

	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build(); 
        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();
        Answers ans1=new Answers();
        ans1.setAnswername("Java preeee");
        ans1.setPostedBy("vinay");
        
        
         
        
        Question q1=new Question();
        q1.setQname("Java realted question");
        q1.setAnswers(ans1);
        Question q2=new Question();
        q2.setQname("Advance Questions");
        q2.setAnswers(ans1);
     
        session.persist(q1);
        session.persist(q2);
        t.commit();
        session.close();

	}

}
