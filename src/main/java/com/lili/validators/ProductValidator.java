package com.lili.validators;

/**
 * This class is not being used.
 * For using the product validator we need to add
 * the following lines below:
 */

    //@Autowired
	//private ProductValidator productValidator;
	
	//@InitBinder
	//private void initBinder (WebDataBinder binder) {
		//binder.setValidator(productValidator);
	//}
/**
 * When you are using a validator class, the domain constraints
 * will not be executed.
 *  order of restrictions execution:
 *  1-java script
 *  2-validator class
 *  3-defined constrainsts in domain
 */	

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import com.lili.domains.Product;

@Component
public class ProductValidator implements Validator {
	

	@Override
	public void validate(Object target, Errors errors) {
		final Product product = (Product) target;
		validateProductInformation(product, errors);
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}
	
    private void validateProductInformation(Product product, Errors errors) {
    	
    	String productId = product.getProductId() + "";
    	
    	 if (productId.length() != 5) {
	    	 	errors.rejectValue("productId", "invalid.product.productid.length", "product id length should be 5 digits");
	     } else if (!productId.matches("^\\d+$")) {
	    	 errors.rejectValue("productId", "invalid.product.productid.length", "product id should be only digits");
	     }
    	 
     } 

} 