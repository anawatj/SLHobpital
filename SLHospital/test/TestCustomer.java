
import com.arg.arsoft.siantluis.domains.customer.Customer;
import com.arg.arsoft.siantluis.domains.customer.CustomerType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anawatj
 */
public class TestCustomer {
    @Test
    public void saveCustomer()
    {
          Configuration config = new Configuration();
      SessionFactory factory=  config.configure("hibernate.cfg.xml").buildSessionFactory();
      Session session =factory.openSession();
      Transaction tran =session.beginTransaction();
      Customer entity = new Customer();
      entity.setId(0);
      entity.setCustomerType(CustomerType.P);
      Customer data = (Customer) session.get(Customer.class, entity.getId());
      Customer result = (Customer) session.merge(entity);
      tran.commit();
      System.out.print(result.getId());
    }
}
