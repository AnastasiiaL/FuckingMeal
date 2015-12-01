package console.step;

/**
 * Created by Anastasia on 19.09.2015.
 */
public enum EStepResultStatus {
    CONTINUE,
    GO_BACK,
    ERROR,
    EXIT;

    public boolean isExit() {
        return this == EXIT;
    }
}
