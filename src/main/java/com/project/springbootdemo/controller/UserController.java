package com.project.springbootdemo.controller;

import com.project.springbootdemo.model.Address;
import com.project.springbootdemo.model.Product;
import com.project.springbootdemo.model.dto.AddressDTO;
import com.project.springbootdemo.model.dto.ProductDTO;
import com.project.springbootdemo.model.dto.UserDTO;
import com.project.springbootdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public ModelAndView registrationView() {
        return new ModelAndView("registration", "newUser", new UserDTO());
    }

    @PostMapping("/registration")
    public String registerNewUser(@ModelAttribute UserDTO userDTO) {
        System.out.println(userDTO.getName() + " " + userDTO.getSurname());
        userService.addUser(userDTO);
        return "/login";
    }

    @GetMapping("/myproducts")
    public ModelAndView getAllProducts(){
        List<ProductDTO> productDTOList = userService.getAllProducts();
        return new ModelAndView("myproducts", "productList", productDTOList);
    }

    @PostMapping("/deleteproduct")
    public String deleteProduct(@ModelAttribute ProductDTO productDTO){
        userService.deleteProduct(productDTO.getId());
        return "redirect:/myproducts";
    }
}
