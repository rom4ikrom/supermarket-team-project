package net.romanov.supermarketbackend.dao;

import java.util.List;

import net.romanov.supermarketbackend.dto.Supplier;
import net.romanov.supermarketbackend.dto.SupplierOrderItem;

public interface SupplierDAO {
	
	Supplier getByEmail(String email);
	Supplier getById(int id);
	
	List<Supplier> listAll();
	List<Supplier> listActive();
	
	List<SupplierOrderItem> getAllSupplierProducts();
	
	List<SupplierOrderItem> getSupplierProductsBySupId(int id);
	
}
