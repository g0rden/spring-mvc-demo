package black.mesa.springmvcdemo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

import java.io.File;


public class HibernateUtil {
    //// SessionFactory is heavy, thread-safe,
    // best practise is to build one instance only for one schema connection
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            File f = new File("E:\\code\\github\\g0rden\\spring-mvc-demo\\src\\main\\resources\\hibernate.cfg.xml");
            return new Configuration().configure(f).buildSessionFactory();
        }catch (Exception ex) {
            System.out.println("SessionFactory creatie failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        sessionFactory.close();
    }
}
