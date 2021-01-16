package org.restapi.showroom.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.restapi.showroom.hibernate.entity.ProductEntity;
import org.restapi.showroom.services.ProductsService;

@Path("/showroom/brands")
public class Products 
{
	ProductsService productsService = new ProductsService();

	@GET
	@Path("/{brandId}/products")
	@Produces(MediaType.APPLICATION_XML)
	public List<ProductEntity> getProductsByBrand(@PathParam("brandId") int brandId ,  
			@QueryParam ("category") String category ) 
	{
		List<ProductEntity> list;
		if(category != null)
		{
			list = productsService.getProductsByBrandAndCategory(brandId , category);
			return list;
		}else
		{
			list = productsService.getProductsByBrand(brandId); 
			return list;
		}
	}
}
