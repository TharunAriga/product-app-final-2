package com.training.pms.galaxe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.training.pms.galaxe.dao.ProductDAO;
import com.training.pms.galaxe.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	ProductDAO productDAO;
	
	public ProductServiceImpl () {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String saveProduct(Product product) {
		String message=null;
		if(product.getPrice()<0|product.getQuantityOnHand()<0) {
			message = "Product Price Or QOH Cannot Be Negative";
		}
		else {
			message = "Product Added";
			productDAO.save(product);
		}
		return message;
	}

	@Override
	public String updateProduct(Product product) {
		String message=null;
		if(product.getPrice()<0|product.getQuantityOnHand()<0) {
			message = "Product Price Or QOH Cannot Be Negative";
		}
		else {
			message = "Product updated";
			productDAO.save(product);
		}
		return message;
	}

	@Override
	public String deleteProduct(int productId) {
		productDAO.deleteById(productId);
		return "Product deleted successfully";
	}

	@Override
	public Product getProduct(int productId) {	//199
		Optional<Product> pr  = productDAO.findById(productId);
		return pr.get();
	}

	@Override
	public List<Product> getProduct() {		//get all products
		
		return (List<Product>)productDAO.findAll();
	}

	@Override
	public boolean isProductExists(int productId) {
		Optional<Product> pr  = productDAO.findById(productId);
		return pr.isPresent();
	}

//	@Override
//	public List<Product> getProduct(String productName) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public List<Product> searchProductByName(String productName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Product> getProduct(int min, int max) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String checkProductInventory(int productId, int quantityRequired) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Product> getProductByPrice(int price) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	  
	  @Override
		public List<Product> getProduct(String productName) {
			return productDAO.findByProductName(productName);
		}



		@Override
		public List<Product> getProduct(int min, int max) {
			// TODO Auto-generated method stub
			return productDAO.findByPriceBetween(min, max);
		}

		@Override
		public String checkProductInventory(int productId, int quantityRequired) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Product> getProductByPrice(int price) {
			// TODO Auto-generated method stub
			return productDAO.findByPrice(price);
		}

		@Override
		public List<Product> searchProductByName(String productName) {
			// TODO Auto-generated method stub
			return null;
		}
	
}
