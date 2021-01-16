package org.restapi.showroom.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "products")
@Table(name = "products")
public class ProductEntity 
{
	@Id
	@Column(name = "productsId")
	private int productId;
	
	@ManyToOne(targetEntity = BrandEntity.class)
	@JoinColumn(name = "brandId")
	BrandEntity brandEntity;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "cost")
	private double cost;

	public ProductEntity() {
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public BrandEntity getBrandEntity() {
		return brandEntity;
	}

	public void setBrandEntity(BrandEntity brandEntity) {
		this.brandEntity = brandEntity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
