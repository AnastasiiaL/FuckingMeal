package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.IProductRepository;

/**
 * Created by Кроха on 20.11.2015.
 */
@Controller
public class ProductListController {
    @Autowired
    private IProductRepository productDbRepository;
    @RequestMapping("/product/list")
    public String list(Model model) {
        //model.addAttribute("shops", shopDbRepository.shopList());
        return "shoplist";
    }

}
