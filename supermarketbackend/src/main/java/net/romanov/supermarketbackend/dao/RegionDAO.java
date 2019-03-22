package net.romanov.supermarketbackend.dao;

import java.util.List;

import net.romanov.supermarketbackend.dto.Region;

public interface RegionDAO {
	
	Region get(int id);
	List<Region> list();
	
	boolean add(Region region);
	boolean update(Region region);
	boolean delete(Region region);

}
