package part01;
/**
 * Exception thrown whenever a value for a time is made negative
 */
public class TimeIsNegativeException extends Exception{
   /**
    * Constructor 
    */
    public TimeIsNegativeException() {}

   /**
    * 
    * @param message - string exception message
    */
    public TimeIsNegativeException(String message)
    {
       super(message);
    }
}
