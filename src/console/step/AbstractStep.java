package console.step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Кроха on 19.09.2015.
 */
public abstract class AbstractStep implements IStep {
    protected int getCommand() {

        System.out.println("Enter a command: ");
        String s = readConsoleValue();

        if (s.matches("[0-9]+")) return Integer.parseInt(s);
        else {
            System.out.println("Wrong command. Try again.");
            return getCommand();
        }

    }

    protected void unknownCommand() {
        System.out.println("Unknown Command. Try again");
    }

    protected String readConsoleValue() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Error while reading from console.");
            throw new RuntimeException(e);
        }
    }

   @Override
   public EStepResultStatus executeStep(){
        while (true){
           EStepResultStatus stepResult = doExecute();
            if (stepResult.isExit()){
                return stepResult;
            }
            if (stepResult == EStepResultStatus.ERROR || stepResult == EStepResultStatus.CONTINUE){
                continue;
            }
            if (stepResult == EStepResultStatus.GO_BACK){
                break;
            }
        }
       return EStepResultStatus.GO_BACK;
    }

    protected abstract EStepResultStatus doExecute();


}
