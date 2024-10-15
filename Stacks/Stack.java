package Stacks;
import LinkedLists.*;
public class Stack {
    int size=0;
    LinkedList stack;
    public Stack()
    {
        stack = new LinkedList();
    }
    public int pop() throws StackException
    {
        if (size==0)
        {
            throw new StackException("Underflow");
        }
        int data = stack.head.data;
        stack.rFirst();
        size--;
        return data;
    }
    public void push(int element)
    {
        stack.prepend(element);
        size++;
    }

    public int peek()
    {
        return stack.head.data;
    }

    public boolean isEmpty()
    {
        if (stack.head == null)
        {
            return true;
        }
        return false;    
    }

    public Stack copyStack()
    {
        return this;
    }

    public void sort()
    {
        
    }

    public void clear()
    {
        stack.clear();
    }

    public void print()
    {
        stack.print();
    }

    public static void main(String[] args) throws StackException {
        Stack stack1 = new Stack();
        stack1.push(1);
        System.err.println(stack1.peek());
        stack1.push(4);
        System.err.println(stack1.pop());
        stack1.print();
        System.err.println(stack1.isEmpty());
        stack1.clear();
        stack1.print();

    }
}
