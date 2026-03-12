package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        // INSERT RECORD
        Transaction tx = session.beginTransaction();

        Inventory inv = new Inventory();
        inv.setName("Laptop");
        inv.setDescription("Dell Laptop");
        inv.setDate(new Date());
        inv.setStatus("Available");

        session.save(inv);

        tx.commit();
        System.out.println("Record Inserted");

        // DELETE RECORD
      //  Transaction tx2 = session.beginTransaction();

       // Inventory obj = session.get(Inventory.class,1);
      //  session.delete(obj);

      //  tx2.commit();
       // System.out.println("Record Deleted");

        session.close();
        sf.close();
    }
}