package net.romanov.supermarketbackend.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.romanov.supermarketbackend.dao.SupplierDAO;
import net.romanov.supermarketbackend.dto.Supplier;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> list() {
		
		String selectActiveRegion = "FROM Supplier WHERE enabled = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveRegion);
		
		query.setParameter("active", true);
		
		return query.getResultList();
		
	}

}
