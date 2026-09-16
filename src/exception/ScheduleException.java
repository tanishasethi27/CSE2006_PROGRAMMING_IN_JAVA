package exception;

/*
 * Custom exception used for schedule-related errors.
 */
public class ScheduleException extends Exception {

    public ScheduleException(String message) {
        super(message);
    }
}
