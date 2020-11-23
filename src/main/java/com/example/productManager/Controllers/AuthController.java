package com.example.productManager.Controllers;

import com.example.productManager.Models.Product;
import com.example.productManager.Models.User;
import com.example.productManager.Services.ProductService;
import com.example.productManager.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private ProductService productService;

    @Autowired
    UserService userService;

    @RequestMapping(value = { "/login" })
    public String login() {
        return "login";
    }

    @RequestMapping(value = { "/logout" })
    public String logout() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        User user = new User();
        // By using ModelAndView

        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.addObject("user", user);
        //modelAndView.setViewName("register");

        // By using Model

        model.addAttribute("user",user);
        return "register";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
        List<Product> listProducts=productService.listAllProducts();
        model.addAttribute("listProducts",listProducts);
        return "index";
    }

    @RequestMapping(value = "/index1", method = RequestMethod.GET)
    public String userOrd(Model model) {
        List<Product> listProducts=productService.listAllProducts();
        model.addAttribute("listProducts",listProducts);
        return "index1";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Validated User user, Model model){
        userService.saveUser(user);
        // By using ModelAndView

        //ModelAndView modelAndView = new ModelAndView();
        //modelAndView.addObject("user",new User());
        //modelAndView.setViewName("login");
        //return modelAndView;

        // By using Model

        model.addAttribute("user",new User());
        return "login";
    }
}

