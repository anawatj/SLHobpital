
import com.arg.arsoft.siantluis.domains.employee.Education;
import com.arg.arsoft.siantluis.domains.employee.Employee;
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
public class TestEmployee {
    
    
    @Test
    public void saveEmployee()
    {
        Configuration config = new Configuration();
      SessionFactory factory=  config.configure("hibernate.cfg.xml").buildSessionFactory();
      Session session =factory.openSession();
      Transaction tran = session.beginTransaction();
       Employee entity = new Employee();
       entity.setId(0);
       Education item = new Education();
       item.setId(0);
       item.setEmployeeId(null);
       item.setEducationLevel(null);
       entity.getEducations().add(item);
      Employee data = (Employee) session.get(Employee.class, entity.getId());
      Employee result = (Employee) session.merge(entity);
      System.out.println(result.getId());
      tran.commit();
     
      //Employee data =(Employee) session.get(Employee.class, 0);
      //Employee employee = (Employee) session.get(Employee.class, 3);
      //System.out.println(employee.getId());
      
    }
}
