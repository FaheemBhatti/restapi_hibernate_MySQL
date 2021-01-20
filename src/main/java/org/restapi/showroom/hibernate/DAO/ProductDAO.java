package org.restapi.showroom.hibernate.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.restapi.showroom.hibernate.entity.BrandEntity;
import org.restapi.showroom.hibernate.entity.ProductEntity;

public class ProductDAO 
{
	SessionFactory factory = (SessionFactory) new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(ProductEntity.class)
			.addAnnotatedClass(BrandEntity.class)
			.buildSessionFactory();

	public List<ProductEntity> getProductsByBrand(int brandId) 
	{
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		String sqlQuery = "from products where brandId = '" +brandId+"'";
		@SuppressWarnings("unchecked")
		List<ProductEntity>productList = session.createQuery(sqlQuery).getResultList();
		return productList;
	}

	public List<ProductEntity> getProductsByBrandAndCategory(int brandId, String category) 
	{
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		String HQL = "from products where brandId ='" + brandId +"'and category = '" +category +"'";
		@SuppressWarnings("unchecked")
		List<ProductEntity> productList = session.createQuery(HQL).getResultList();
		return productList;
	}
}
