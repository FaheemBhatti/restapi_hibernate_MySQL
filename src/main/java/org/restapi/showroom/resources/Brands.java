package org.restapi.showroom.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import org.restapi.showroom.hibernate.entity.BrandEntity;
import org.restapi.showroom.services.BrandsService;

@Path("/showroom")
public class Brands 
{
	BrandsService service = new BrandsService();

	@GET
	@Path("/brands")
	@Produces(MediaType.APPLICATION_XML)
	public List<BrandEntity> getBrands() 
	{
		List<BrandEntity> list = service.getBrands(); 
		return list;
	}
	
	@POST
	@Path("/brands")
	@Consumes(MediaType.APPLICATION_XML)
	public void setBrands(BrandEntity brand) 
	{
		service.addBrand(brand);
	}
	
	@PUT
	@Path("/brands/{brandId}")
	@Consumes(MediaType.APPLICATION_XML)
	public void putBrands(@ PathParam("brandId") int brandId, BrandEntity updatedBrand) 
	{
		updatedBrand.setBrandId(brandId);
		service.updateBrand(updatedBrand);
	}
	
	@DELETE
	@Path("/brands/{brandId}")
	public void deleteBrands(@PathParam("brandId") int brandId) 
	{
		service.deletedBrand(brandId);
	}
}
