package Shopping;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ShoppingFind
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Abhishek");
		EntityManager em=emf.createEntityManager();
		
		Product product=em.find(Product.class, 1);
		
		System.out.println(product.getId());
		System.out.println(product.getPname());
		System.out.println(product.getPprice());
		
		
		Cart cart=product.getCart();
		System.out.println(cart.getId());
		System.out.println(cart.getCprice());
		
		Customer customer=cart.getCustomer();
		System.out.println(customer.getId());
		System.out.println(customer.getEmail());
		System.out.println(customer.getPassword());
		
		
		
	}
	
}
