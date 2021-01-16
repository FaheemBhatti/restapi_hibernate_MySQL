package org.restapi.showroom.hibernate.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.restapi.showroom.hibernate.entity.BrandEntity;


public class BrandsDAO {


	SessionFactory factory = (SessionFactory) new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(BrandEntity.class)
			.buildSessionFactory();
	
	public List<BrandEntity> getBrands() 
	{
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<BrandEntity> list = session.createQuery("from brands").getResultList();
		return list;
	}

	public void addBrands(BrandEntity brand) 
	{
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(brand);
		session.getTransaction().commit();
	}

	public void deleteBrand(int brandId) 
	{
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		BrandEntity brand = session.get(BrandEntity.class,brandId);
		session.delete(brand);
		session.getTransaction().commit();
	}

	public void updateBrand(BrandEntity updatedBrand) 
	{
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		BrandEntity brand = session.get(BrandEntity.class, updatedBrand.getBrandId());
		brand.setBrandName(updatedBrand.getBrandName());
		session.getTransaction().commit();
	}
}
