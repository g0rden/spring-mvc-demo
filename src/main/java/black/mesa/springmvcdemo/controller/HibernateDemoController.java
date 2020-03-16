package black.mesa.springmvcdemo.controller;

import black.mesa.springmvcdemo.entity.CustomerEntity;
import black.mesa.springmvcdemo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hibernate-demo")
public class HibernateDemoController {
    //private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping("/user/create")
    public void createCustormer() {
        Session session =  sessionFactory.openSession();

        session.beginTransaction();

        CustomerEntity customer = new CustomerEntity();

        customer.setId(101);
        customer.setName("Nick The King");

        session.save(customer);
        session.getTransaction().commit();
    }
}
