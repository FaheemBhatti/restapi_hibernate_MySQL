package org.restapi.showroom.services;

import java.util.List;
import org.restapi.showroom.hibernate.DAO.BrandsDAO;
import org.restapi.showroom.hibernate.entity.BrandEntity;



public class BrandsService 
{
	BrandsDAO DAO = new BrandsDAO();

	public List<BrandEntity> getBrands() 
	{
		List<BrandEntity> list = DAO.getBrands();
		return list;
	}

	public void addBrand(BrandEntity brand) 
	{
		DAO.addBrands(brand);
	}

	public void updateBrand(BrandEntity updatedBrand) 
	{
		DAO.updateBrand(updatedBrand);
	}

	public void deletedBrand(int brandId) 
	{
		DAO.deleteBrand(brandId);
	}

	public List<BrandEntity> getBrand(int brandId)
	{
		List<BrandEntity> list = DAO.getBrand(brandId);
		return list;
	}
}
