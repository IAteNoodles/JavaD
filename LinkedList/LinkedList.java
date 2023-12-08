class Node
  {
    int data;
    Node next;
    Node(int data)
    {
      this.data = data;
      this.next = null;
    }
  }
class LinkedList
{
  Node head = null;
  Node tail = null;
  public void append(int data)
  {
    Node newNode = new Node(data);
    if(head == null)
    {
      head = newNode;
      tail = newNode;
      return;
    }
    tail.next = newNode;
    tail = newNode;
  }

  public void print()
  {
    Node current = head;
    System.out.println("The linked list values are:");
    while(current != null)
    {
      System.out.print(current.data + ", ");
      current = current.next;
    }
    System.out.println();
  }
  public static void main(String[] args)
  {
    LinkedList list = new LinkedList();
    list.append(1);
    list.append(2);
    list.append(3);
    list.append(4);
    list.append(5);
    list.print();
  }
}

