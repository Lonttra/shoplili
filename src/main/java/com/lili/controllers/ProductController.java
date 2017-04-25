package com.lili.controllers;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lili.domains.Product;
import com.lili.services.ProductService;


@Controller
public class ProductController {

	private ProductService productService;
	private String submitAction = "ADD";
	

	@Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
	
		
	@RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model, Pageable pageable){
        
		Page<Product> productPage = productService.findAll(pageable);
        
        PageWrapper<Product> page = new PageWrapper<Product>(productPage, "/products");
        
        model.addAttribute("products", page.getContent());
        model.addAttribute("page", page);
        
        return "products";
    }
		
	
	@RequestMapping("product/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "productshow";
    }
	
	@RequestMapping("product/edit/{id}")
	    public String edit(@PathVariable Integer id, Model model){
		submitAction = "UPDATE";
		model.addAttribute("submitAction", submitAction);
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }
	
	@RequestMapping("product/remove/{id}")
	public String remove (@PathVariable Integer id, Model model) {
		submitAction = "DELETE";
		model.addAttribute("product", productService.getProductById(id));
		model.addAttribute("submitAction", submitAction);
		return "productform";
	}
			
	@RequestMapping("/product/new")
    public String newProduct(Model model){
		submitAction = "ADD";
		model.addAttribute("submitAction", submitAction);
        model.addAttribute("product", new Product());
        return "productform";
    }
	
	
	@RequestMapping(value = "product", method = RequestMethod.POST)
    public String submitProduct(@Valid Product product, BindingResult bindingResult){
		
		if (submitAction.equals("DELETE")) {
			productService.deleteProduct(product);	
			System.out.println("product is being deleted");
		} else { // product will be either created or updated
			//Here show the product ...
			System.out.println(product.toString());
						
			if (bindingResult.hasErrors()) {
				return "productform";
			}						
		    productService.saveProduct(product);
		        
		}
		
		return "redirect:/products";
    }	
} 

