package controllers;

import model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.IShopRepository;

/**
 * Created by Кроха on 18.11.2015.
 */
@Controller
@RequestMapping("/shop")
public class ShopListController {
    @Qualifier("shopDAOImpl")
    @Autowired
        private IShopRepository shopDAO;

        @RequestMapping(value = "/list", method = RequestMethod.GET)
        public String list(Model model) {
            model.addAttribute("shops", shopDAO.shopList());
            return "shoplist";
        }

        @RequestMapping(value = "/view", method = RequestMethod.GET)
        public String view(@RequestParam("id")String id, Model model){
            Shop shop = shopDAO.findShop(Integer.parseInt(id));
            model.addAttribute("shop", shop);
            return "viewShop";
        }

        @RequestMapping(value = "/update", method = RequestMethod.GET)
        public String update(@RequestParam("id")String id, Model model){
            Shop shop = shopDAO.findShop(Integer.parseInt(id));
            model.addAttribute("shop", shop);
            return "updateShop";
        }

        @RequestMapping(value = "/submitUpdate", method = RequestMethod.POST)
        public String submitUpdate(@ModelAttribute("SpringWeb")Shop shop, Model model){
            shopDAO.updateShop(shop);
            model.addAttribute("name", shop.getName());
            model.addAttribute("location", shop.getLocation());
            model.addAttribute("id", shop.getId());
            return "updateComplete";
        }

        @RequestMapping(value = "/create", method = RequestMethod.GET)
        public String create(Model model){
            model.addAttribute("shop", new Shop());
            return "updateShop";
        }

        @RequestMapping(value = "/delete", method = RequestMethod.GET)
        public String delete(@RequestParam("id")String id, Model model){
            Shop shop = shopDAO.findShop(Integer.parseInt(id));
            shopDAO.delete(Integer.parseInt(id));
            model.addAttribute("shop", shop);
            return "deleteShop";
        }
}
