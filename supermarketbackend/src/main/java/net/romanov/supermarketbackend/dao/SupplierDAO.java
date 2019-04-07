package net.romanov.supermarketbackend.dao;

import java.util.List;

import net.romanov.supermarketbackend.dto.Supplier;

public interface SupplierDAO {
	
	Supplier getByEmail(String email);
	
	List<Supplier> list();

}
