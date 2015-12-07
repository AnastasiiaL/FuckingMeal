package controllers;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.IProductRepository;
import service.ServiceProduct;

/**
 * Created by Кроха on 20.11.2015.
 */
@Controller
@RequestMapping("/product")
public class ProductListController {
    @Autowired
    private ServiceProduct service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", service.list());
        return "productlist";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(@RequestParam("id")String id, Model model){
        Product product = service.find(Integer.parseInt(id));
        model.addAttribute("product", product);
        return "viewProduct";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(@RequestParam("id")String id, Model model){
        Product product = service.find(Integer.parseInt(id));
        model.addAttribute("product", product);
        return "updateProduct";
    }

    @RequestMapping(value = "/submitUpdate", method = RequestMethod.POST)
    public String submitUpdate(@ModelAttribute("SpringWeb")Product product, Model model){
        service.update(product);
        model.addAttribute("product", product);
        return "productUpdateComplete";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("product", new Product());
        return "updateProduct";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam("id")String id, Model model){
        Product product = service.find(Integer.parseInt(id));
        service.delete(Integer.parseInt(id));
        model.addAttribute("product", product);
        return "deleteProduct";
    }

}
