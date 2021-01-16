package org.restapi.showroom.services;

import java.util.List;
import org.restapi.showroom.hibernate.DAO.ProductDAO;
import org.restapi.showroom.hibernate.entity.ProductEntity;

public class ProductsService {

	
	ProductDAO productDAO = new ProductDAO();
	
	public List<ProductEntity> getProductsByBrand(int brandId) 
	{
		List<ProductEntity> productList = productDAO.getProductsByBrand(brandId);
		return productList;
	}

}
