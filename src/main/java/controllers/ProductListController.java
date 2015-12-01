package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.IProductRepository;

/**
 * Created by Кроха on 20.11.2015.
 */
@Controller
@RequestMapping("/product")
public class ProductListController {
    @Qualifier("productDAOImpl")
    @Autowired
    private IProductRepository productDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", productDAO.list());
        return "productlist";
    }

}
