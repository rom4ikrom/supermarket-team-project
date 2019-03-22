package net.romanov.supermarketbackend.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.romanov.supermarketbackend.dao.RegionDAO;
import net.romanov.supermarketbackend.dto.Region;

@Repository("regionDAO")
@Transactional
public class RegionDAOImpl implements RegionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Region get(int id) {
		
		return sessionFactory.getCurrentSession().get(Region.class, Integer.valueOf(id));
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> list() {
		
		String selectActiveRegion = "FROM Region WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveRegion);
		
		query.setParameter("active", true);
		
		return query.getResultList();
		
	}

	@Override
	public boolean add(Region region) {
		
		try {
			sessionFactory.getCurrentSession().persist(region);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Region region) {
		
		try {
			sessionFactory.getCurrentSession().update(region);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Region region) {
		
		try {
			sessionFactory.getCurrentSession().delete(region);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

}
