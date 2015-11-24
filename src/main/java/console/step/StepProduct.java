package console.step;

import model.Product;
import model.Shop;
import repository.IProductRepository;
import repository.IShopRepository;
import repository.ShopDbRepository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ����� on 19.09.2015.
 */
public class StepProduct extends AbstractStep {
    public IProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private IProductRepository productRepository;
    @Override
    public void back() {

    }

    @Override
    public EStepResultStatus doExecute() {
        System.out.println("Select an option:\n 1 - add a product\n 2 - show products\n " +
                "3 - find a product\n 4 - delete a product\n 0 - exit.");
        int command = getCommand();

        switch (command){
            case 1:
                productRepository.add(getMeal());
                break;
            case 2:
                for (Product product : productRepository.productList()){
                    System.out.println(product.name);
                }
                break;
            case 3:
                String productName = getProductName();
                productRepository.findProduct(productName);
                break;
            case 4:
                productName = getProductName();
                //productRepository.delete(productName);
                break;
            case 0:
                back();
                return EStepResultStatus.GO_BACK;
            default:
                unknownCommand();
                return EStepResultStatus.ERROR;
        }
        return EStepResultStatus.CONTINUE;
    }
    private Product getMeal() {
        System.out.println("Add a new product name:  ");
        String name = readConsoleValue();
        System.out.println("Add a product brand:  ");
        String brand = readConsoleValue();
        System.out.println("Add a product amount:  ");
        double amount = Double.parseDouble(readConsoleValue());
        System.out.println("Add a product amount type");
        String amount_type = readConsoleValue();
        System.out.println("Add a product price:  ");
        double price = Double.parseDouble(readConsoleValue());
        System.out.println("Select a shop:");
        Shop shop = addShop();
        Product product = new Product(brand, name, amount,amount_type);
        return product;
    }

    private Shop addShop() {
        IShopRepository shopRepository = new ShopDbRepository();
        List<Shop> list = shopRepository.shopList();
        int i = 1;
        HashMap<Integer, Shop> mapShop = new HashMap<>();
        for (Shop shop : list){
            System.out.println(i + " - " + shop);
            mapShop.put(i, shop);
            i++;
        }
        System.out.println(++i + "Add a new one");
        int selection = Integer.parseInt(readConsoleValue());
        if (selection == i){
            Shop shop = new StepShop().getShop();
            shopRepository.add(shop);
            return shop;
        }
        else {
            Shop shop = mapShop.get(selection);
            return shop;
        }
    }


    private String getProductName() {
        System.out.println("Enter a product name: ");
        String s = readConsoleValue();
        return s;
    }
}
