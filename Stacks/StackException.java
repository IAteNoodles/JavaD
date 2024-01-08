package Stacks;

public class StackException extends Exception 
{
    public StackException(String message)
    {
        super(message);
    }
    public StackException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
