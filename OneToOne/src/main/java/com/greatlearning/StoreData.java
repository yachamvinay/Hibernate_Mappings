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
 
        
        
        Answers ans3=new Answers();
        ans3.setAnswername("Spring core");
        ans3.setPostedBy("Gladwin");
        Answers ans5=new Answers();
        ans5.setAnswername("spring Boot");
        ans5.setPostedBy("Gerald");
        
       
        
        Question q1=new Question();
        q1.setQname("Java realted question");
        q1.setAnswers(ans5);
        Question q2=new Question();
        q2.setQname("Advance Questions");
        
        q2.setAnswers(ans3);
        ans3.setQuestion(q2);
        ans5.setQuestion(q1);
        session.persist(q1);
        session.persist(q2);
        t.commit();
        session.close();

	}

}
