package org.dorukt.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    /*
    Standart olarak config dosyasi eger resources altinda hibernate.cfg.xml ise asagidaki adimlar yeterli.
    Configuration() metodu standart olarak o dizinde o isimle dosyayi arar.
     */
    private static SessionFactory SESSION_FACTORY;

    static {
        try {
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Hibernate SessionFactory Hatası: " + e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }
}
