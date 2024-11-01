package part01;

public class TimeIsNegativeException extends Exception{
    // Parameterless Constructor
    public TimeIsNegativeException() {}

    // Constructor that accepts a message
    public TimeIsNegativeException(String message)
    {
       super(message);
    }
}
