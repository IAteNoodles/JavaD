package Queues;
import LinkedLists.*;
public class Queue {
    
    LinkedList queue;
    int size = 0;
    Node front = null;
    Node rear = null;

    public Queue() {
        queue = new LinkedList();
    }

    public boolean isEmpty() //Check if queue is empty
    {
        return front==null;
    }

    public void enqueue(int data) //Insert at the end
    {
        queue.append(data);
        if(front==null)
        {
            front = queue.head;
            rear = queue.tail;
        }
        else
        {
            rear = queue.tail;
        }
        size++;
    }

    public int dequeue() //Remove element from the first
    {
        if(isEmpty())
        {
            //Do something
        }
        int data = front.data;
        front = front.next;
        if(front==null)
        {
            rear=null;
        }
        size--;
        return data;
    }

    public int peek() //Returns element from the first 
    {
        if(isEmpty())
        {
            //Something
        }
        return front.data;
    }

    public void clear()
    {
        front = null;
        rear = null;
        size = 0;
    }

    public void display() //Prints the elements in the queue
    {
        queue.print();
    }

    public boolean contains(int data)
    {
        return queue.search(data);
    }

    public void rotate(int index)
    {
        index = index % size;
        if(isEmpty())
        {
            //Do something
        }
        do
        {
            enqueue(dequeue()); //Removes the first element and slides it to the last
            index--;
        }while(index!=0);
    }
    
    public void reverse()
    {
        queue.reverse();
        front = queue.head;
        rear = queue.tail;
    }

    public void sort()
    {
        queue.sort();
    }

    public void merge(Queue otherQueue)
    {
        while(!otherQueue.isEmpty())
        {
            enqueue(otherQueue.dequeue());
        }
    }
}
