package com.lili.domains;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Version
	private Integer version;
	
	@NotEmpty (message = "product id may not be empty")
	@Pattern (regexp="^\\d+$", message="product id should be only digits")	
	private String productId;
	
	@NotEmpty(message = "description may not be empty")
	private String productDesc;
	
	@NumberFormat(pattern = "#,###,###,###.##")
	@NotNull (message = "price may not be empty")	
	private BigDecimal price;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@NotNull(message="expired date may not be empty")
	@Future (message="expired date can not be in past")
	private Date expDate;
	
	public Integer getId() {		
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getExpDate() {
		return expDate;
	}
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
	@Override
	public String toString() {
		return "Product(ProductId: " + this.productId + ", Desc: " + this.productDesc +
				", Price: " + this.price + 	", Exp Date: " +  this.expDate + ")";
	}	
}
