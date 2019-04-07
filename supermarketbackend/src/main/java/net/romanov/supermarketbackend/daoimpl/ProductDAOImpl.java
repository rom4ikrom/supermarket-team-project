package net.romanov.supermarketbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.romanov.supermarketbackend.dao.ProductDAO;
import net.romanov.supermarketbackend.dto.Product;
import net.romanov.supermarketbackend.dto.SupplierOrderItem;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//return single product
	
	@Override
	public Product get(int productId) {
		
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Product> list() {
		
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM Product ", Product.class)
				.getResultList();
		
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			//call the update method
			return this.update(product);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE is_active = :active";

		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true)
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE is_active = :active ORDER BY id", Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByRegionId(int id) {
		String selectActiveProducts = "FROM Product WHERE is_active = :active AND region_id = :id";

		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true)
				.setParameter("id", id)
				.getResultList();
	}

	@Override
	public List<Product> getProductsByRegion(int id, int count) {
		
		String query = "FROM Product WHERE is_active = true AND region_id = :regionId ORDER BY views DESC";
		
		return sessionFactory.getCurrentSession()
				.createQuery(query, Product.class)
				.setFirstResult(0)
				.setParameter("regionId", id)
				.setMaxResults(count)
				.getResultList();
		
	}

	@Override
	public boolean addSupOrderItem(SupplierOrderItem supOrderItem) {
		try {
			sessionFactory.getCurrentSession().persist(supOrderItem);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public SupplierOrderItem getSupOrderItemByProductId(int productId) {
		
		String query = "FROM SupplierOrderItem WHERE product_id = :productId";
		
		try {
			return sessionFactory.getCurrentSession()
					.createQuery(query, SupplierOrderItem.class)
					.setParameter("productId", productId)
					.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
		
	}

}
