package net.romanov.supermarketbackend.dao;

import java.util.List;

import net.romanov.supermarketbackend.dto.Product;
import net.romanov.supermarketbackend.dto.SupplierOrderItem;

public interface ProductDAO {
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	List<Product> listActiveProducts();
	List<Product> getLatestActiveProducts(int count);
	List<Product> listActiveProductsByRegionId(int id);
	List<Product> getProductsByRegion(int id, int count);
	
	boolean addSupOrderItem(SupplierOrderItem supOrderItem);
	
	SupplierOrderItem getSupOrderItemByProductId(int productId);

}
