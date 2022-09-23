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
        Answers ans2=new Answers();
        ans2.setAnswername("Hibernate");
        ans2.setPostedBy("vijay");
        
        
        Answers ans3=new Answers();
        ans3.setAnswername("Spring core");
        ans3.setPostedBy("siva");
        Answers ans5=new Answers();
        ans5.setAnswername("spring Boot");
        ans5.setPostedBy("bobby");
        
        ArrayList<Answers> list1=new ArrayList<Answers>();
        list1.add(ans1);
        list1.add(ans2);
        
        ArrayList<Answers> list2=new ArrayList<Answers>();
        list2.add(ans3);
        list2.add(ans5);
        
        Question q1=new Question();
        q1.setQname("Java realted question");
        q1.setAnswers(list1);
        Question q2=new Question();
        q2.setQname("Advance Questions");
        q2.setAnswers(list2);
        Question q3=new Question();
        q3.setQname("Advance Questions");
        q3.setAnswers(list2);
        session.persist(q1);
        session.persist(q2);
        session.persist(q3);
        t.commit();
        session.close();

	}

}
