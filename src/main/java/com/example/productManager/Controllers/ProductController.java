package com.example.productManager.Controllers;

import com.example.productManager.Models.Product;
import com.example.productManager.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        return "login";
    }

    @RequestMapping("/new")
    public String refreshForm(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "new_product";
    }

    //To map new inputs from the form, hence the usage of modelAttribute, automatically populate the values into a product object
    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/home";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView refreshEdit(@PathVariable(name="id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit_product");
        Product product = productService.getSingleProduct(id);
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String refreshDelete(@PathVariable(name="id") Long id){
        productService.deleteSingleProduct(id);
        return "redirect:/home";
    }
}
