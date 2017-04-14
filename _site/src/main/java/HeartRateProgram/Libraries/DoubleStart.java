package HeartRateProgram.Libraries;

/**
 * Created by ruhana on 4/5/17.
 */
public class DoubleStart extends Exception {
    public DoubleStart() {
    }

    public DoubleStart(String message) {
        super(message);
    }

    public DoubleStart(String message, Throwable cause) {
        super(message, cause);
    }

    public DoubleStart(Throwable cause) {
        super(cause);
    }

    public DoubleStart(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
