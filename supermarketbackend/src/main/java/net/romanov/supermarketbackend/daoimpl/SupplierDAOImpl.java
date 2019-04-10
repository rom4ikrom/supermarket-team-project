package net.romanov.supermarketbackend.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.romanov.supermarketbackend.dao.SupplierDAO;
import net.romanov.supermarketbackend.dto.Supplier;
import net.romanov.supermarketbackend.dto.SupplierOrderItem;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Supplier getByEmail(String email) {
		
		String selectQuery = "FROM Supplier WHERE email = :email";
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(selectQuery, Supplier.class)
					.setParameter("email", email)
					.getSingleResult();
		} catch(Exception ex) {
			return null;
		}
		
	}
	
	@Override
	public Supplier getById(int id) {
		
		String selectQuery = "FROM Supplier WHERE id = :id";
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(selectQuery, Supplier.class)
					.setParameter("id", id)
					.getSingleResult();
		} catch(Exception ex) {
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> listActive() {
		
		String selectActiveRegion = "FROM Supplier WHERE enabled = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveRegion);
		
		query.setParameter("active", true);
		
		return query.getResultList();
		
	}
	
	@Override
	public List<Supplier> listAll() {

		String selectQuery = "FROM Supplier";
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery(selectQuery, Supplier.class)
					.getResultList();
		} catch(Exception ex) {
			return null;
		}
	}

	@Override
	public List<SupplierOrderItem> getAllSupplierProducts() {
		
		String selectQuery = "FROM SupplierOrderItem";
		
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, SupplierOrderItem.class)
				.getResultList();
		
	}

	@Override
	public List<SupplierOrderItem> getSupplierProductsBySupId(int id) {
		
		String selectQuery = "FROM SupplierOrderItem WHERE supplierId = :id";
		
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery, SupplierOrderItem.class)
				.setParameter("id", id)
				.getResultList();
	}

}
