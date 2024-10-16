package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.model.Product;

@Component
public class ProductDao {

	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	//Create Product 
	@Transactional
	public void createProduct(Product product)
	{
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	
	//Get all product
	public List<Product> getProduct()
	{
		List<Product> products =this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	
	//delete poduct
	@Transactional
	public void deleteProduct(int pid)
	{
		Product p=this.hibernateTemplate.load(Product.class,pid);
		this.hibernateTemplate.delete(p);
		
	}
	
	
	//getSingal Product
	public Product getProduct(int pid)
	{
		return this.hibernateTemplate.get(Product.class,pid);
	}
}
