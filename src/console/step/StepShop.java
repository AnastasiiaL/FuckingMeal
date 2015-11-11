package console.step;

import model.Shop;
import repository.FileSystemShopRepository;
import repository.IShopRepository;

/**
 * Created by Кроха on 19.09.2015.
 */
public class StepShop extends AbstractStep {
    IShopRepository shopRepository = new FileSystemShopRepository();
    @Override
    public void back() {

    }

    @Override
    public EStepResultStatus doExecute() {
        System.out.println("Select an option:\n 1 - add a shop\n 2 - show all shops\n " +
                "3 - find a shop\n 4 - delete a shop\n 0 - exit.");
        int command = getCommand();

        switch (command)
        {
            case 1:
                shopRepository.add(getShop());
                break;
            case 2:
                for (Shop shop : shopRepository.shopList()){
                    System.out.println(shop.name + " " + shop.location);
                }
                break;
            case 3:
                String shopName = getShopName();
                shopRepository.findShop(shopName);
                break;
            case 4:
                shopName = getShopName();
                shopRepository.deleteShop(shopName);
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
    public Shop getShop() {
        System.out.println("Add a new shop name:  ");
        String name = readConsoleValue();
        System.out.println("Add a shop location:  ");
        String location = readConsoleValue();
        Shop shop = new Shop(name, location);
        return shop;
    }

    public String getShopName() {
        System.out.println("Enter a shop name: ");
        String s = readConsoleValue();
        return s;
    }
}


