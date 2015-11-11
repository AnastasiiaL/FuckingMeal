package console.step;

/**
 * Created by Кроха on 19.09.2015.
 */
public class EntryStep extends AbstractStep {


    @Override
    public void back() {

    }

    @Override
    protected EStepResultStatus doExecute() {
        System.out.println("Select an option: 1 - products, 2 - shops, 0 - exit.");
        int command = getCommand();

        switch (command){
            case 1:
                new StepProduct().executeStep();
                break;
            case 2:
                new StepShop().executeStep();
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
}
