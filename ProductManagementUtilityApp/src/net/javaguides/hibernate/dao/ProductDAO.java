package net.javaguides.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import net.javaguides.hibernate.model.Product;
import net.javaguides.hibernate.util.HibernateUtil; // for product.class only

public class ProductDAO {
   
	//save object in database
    public static void saveProduct(Product prod) {
        Transaction transaction = null;
        Session session2 = HibernateUtil.getsessionfactory().openSession();
        transaction = session2.beginTransaction();
        session2.save(prod);
        transaction.commit();
        session2.close();           
        }
    
    //edit/update product in database - action
    public static void EditProduct(Product prod) {
        Transaction transaction = null;
        Session session = HibernateUtil.getsessionfactory().openSession();
        transaction = session.beginTransaction();
        session.update(prod); //passing the product to be updated
        transaction.commit();    
        session.close();
    }
    
    //delete product in database - action
    public static void deleteProduct(int id) {

        Transaction transaction = null;
        Session session = HibernateUtil.getsessionfactory().openSession();
        transaction = session.beginTransaction();
        Product prod = (Product) session.get(Product.class, id);
        if (prod != null) {
        	session.delete(prod);
            System.out.println("Product is deleted");
            }
        transaction.commit();
        session.close();
    }   
    
    public static Product getProduct(int id) {

        Transaction transaction = null;
        Product prod = null;
        Session session = HibernateUtil.getsessionfactory().openSession();
        transaction = session.beginTransaction();
        prod = (Product) session.get(Product.class, id);
        transaction.commit();
        session.close();
        return prod;
    }

    public List <Product> getAllProducts() {

        Transaction transaction = null;
        List < Product > listOfProducts = null;
        Session session = HibernateUtil.getsessionfactory().openSession();
        transaction = session.beginTransaction();
        listOfProducts = session.createQuery("from Product").list();
        transaction.commit();
        session.close();
        return listOfProducts;
    }

	/*public List<Product> getAllProducts(String username) {
		Transaction transaction = null;
        List < Product > listOfProducts = null;
        Session session = HibernateUtil.getsessionfactory().openSession();
        transaction = session.beginTransaction();
        Query q = session.createQuery("from Product P WHERE P.username = :username");
        q.setParameter("username", username);
        listOfProducts=q.list();
        transaction.commit();
        session.close();
        return listOfProducts;
	}*/

}
