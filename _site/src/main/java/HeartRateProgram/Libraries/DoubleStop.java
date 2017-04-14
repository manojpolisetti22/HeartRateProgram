package HeartRateProgram.Libraries;

/**
 * Created by ruhana on 4/5/17.
 */
public class DoubleStop extends Exception{
    public DoubleStop() {
    }

    public DoubleStop(String message) {
        super(message);
    }

    public DoubleStop(String message, Throwable cause) {
        super(message, cause);
    }

    public DoubleStop(Throwable cause) {
        super(cause);
    }

    public DoubleStop(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
