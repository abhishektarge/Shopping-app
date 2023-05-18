package Shopping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ShoppingDriver 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Abhishek");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Customer customer=new Customer();
		customer.setId(1);
		customer.setEmail("abhi@gmail.com");
		customer.setPassword("abhi123");
		
		Cart cart=new Cart();
		cart.setId(1);
		cart.setCprice(1650);
		
		Product product1=new Product();
		product1.setId(1);
		product1.setPname("T-shirt");
		product1.setPprice(400);
		
		Product product2=new Product();
		product2.setId(2);
		product2.setPname("cap");
		product2.setPprice(150);
		
		Product product3=new Product();
		product3.setId(3);
		product3.setPname("jeans");
		product3.setPprice(1100);
		
		List<Product> products= new ArrayList<Product>();
		products.add(product1);
		products.add(product2);
		products.add(product3);
		
		cart.setProduct(products);
		
		
		customer.setCart(cart);
		cart.setCustomer(customer);
		
		
		product1.setCart(cart);
		product2.setCart(cart);
		product3.setCart(cart);
		
		
		et.begin();
		em.persist(customer);
		em.persist(cart);
		em.persist(product1);
		em.persist(product2);
		em.persist(product3);
		et.commit();
		
		
		
		
	}
}
