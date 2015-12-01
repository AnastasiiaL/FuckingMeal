package console.step;

/**
 * Created by Anastasia on 19.09.2015.
 */
public class EntryStep extends AbstractStep {
    private StepProduct stepProduct;
    private StepShop stepShop;

    public void back() {

    }

    @Override
    protected EStepResultStatus doExecute() {
        System.out.println("Select an option: 1 - products, 2 - shops, 0 - exit.");
        int command = getCommand();

        switch (command){
            case 1:
                stepProduct.executeStep();
                break;
            case 2:
                stepShop.executeStep();
                break;
            case 0:
                back();
                return EStepResultStatus.EXIT;
            default:
                unknownCommand();
                return EStepResultStatus.ERROR;
        }
        return EStepResultStatus.CONTINUE;

    }

    public StepProduct getStepProduct() {
        return stepProduct;
    }

    public void setStepProduct(StepProduct stepProduct) {
        this.stepProduct = stepProduct;
    }

    public StepShop getStepShop() {
        return stepShop;
    }

    public void setStepShop(StepShop stepShop) {
        this.stepShop = stepShop;
    }
}
