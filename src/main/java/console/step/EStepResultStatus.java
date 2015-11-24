package console.step;

/**
 * Created by Кроха on 19.09.2015.
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
