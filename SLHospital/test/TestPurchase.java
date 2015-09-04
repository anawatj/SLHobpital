
import com.arg.arsoft.siantluis.domains.master.Service;
import com.arg.arsoft.siantluis.domains.product.Product;
import com.arg.arsoft.siantluis.domains.purchase.FlagVat;
import com.arg.arsoft.siantluis.domains.purchase.Purchase;
import com.arg.arsoft.siantluis.domains.purchase.PurchaseItemProduct;
import com.arg.arsoft.siantluis.domains.purchase.PurchaseItemService;
import com.arg.arsoft.siantluis.domains.purchase.PurchaseStatus;
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
public class TestPurchase {

    @Test
    public void testSave() {
        Purchase entity = new Purchase();
        entity.setId(0);
        entity.setStatus(PurchaseStatus.W);

        PurchaseItemService sitem = new PurchaseItemService();
        sitem.setId(0);
        Service service = new Service();
        service.setId(1);
        sitem.setService(service);
        sitem.setFlagVat(FlagVat.I);
        entity.getServices().add(sitem);
        sitem = new PurchaseItemService();
        sitem.setId(0);
        service = new Service();
        service.setId(2);
        sitem.setService(service);
        sitem.setFlagVat(FlagVat.E);
        entity.getServices().add(sitem);
        PurchaseItemProduct pitem = new PurchaseItemProduct();
        pitem.setId(0);
        Product p = new Product();
        p.setId(1);
        pitem.setProduct(p);
        pitem.setFlagVat(FlagVat.I);
        entity.getProducts().add(pitem);

        pitem = new PurchaseItemProduct();
        pitem.setId(0);
        p = new Product();
        p.setId(2);
        pitem.setProduct(p);
        pitem.setFlagVat(FlagVat.I);
        entity.getProducts().add(pitem);
        Configuration config = new Configuration();
        SessionFactory factory = config.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction tran = session.beginTransaction();
        Purchase data = (Purchase) session.get(Purchase.class, entity.getId());
        Purchase result = (Purchase) session.merge(entity);
        tran.commit();
    }
}
