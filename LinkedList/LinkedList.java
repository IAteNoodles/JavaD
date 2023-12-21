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
    Node newNode = new Node(data);//Creates a node with the data
    if(head == null)
    {
      head = newNode;
      tail = newNode;
      return;
    }
    tail.next = newNode;//Connects the next attribute to the tail
    tail = newNode;//Updates the tail to the latest 
  }

  public int length()
  {
    int currentCount = 0;
    Node currentNode = head;
    while(currentNode.next!=null)
    {
      currentCount++;
      currentNode = currentNode.next;
    }
    return currentCount;
  }

  public void prepend(int data)
  {
    Node newNode = new Node(data);//Creates a node with the data
    if(head == null)
    {
      head = newNode;
      tail = newNode;
      return;
    }
    newNode.next = head;//Connects the next attribute to the head
    head = newNode;//Updates the new head
  }
  
  public void insert(int data, int index)
  {
    Node newNode = new Node(data);//Creates the node to be inserted
    if(index == 0)
    {
      prepend(data);
      return;
    }
    Node current = head;
    int curentIndex = 0;
    while(current != null)
    {
      if(curentIndex == index - 1)
      {
        //Since we are inserting the node at the index, 
        //we connect the next attribute of the current node to the next attribute of the new node
        //and the next attribute of the current node to the new node. 
        newNode.next = current.next;
        current.next = newNode;
        return;
      }
      current = current.next;
      curentIndex++;
    }
  }

  public void reverse()
  {

    //Traverse the list
    /* Space and Time Complexity is O(n)
    Node currentNode = head;
    Node revNode = new Node(currentNode.data);
    Node tailNode;
    while(currentNode.next != null)
    {
      currentNode = currentNode.next;
      tailNode = new Node(currentNode.data);
      tailNode.next = revNode;
      revNode = tailNode;
    }
    head = revNode;
    */
    //Space complexity is O(1) and Time Complexity is O(n)
    Node currentNode=head;
    Node nextNode = head.next;
    Node remNode = nextNode.next;
    currentNode.next=null;
    while(true)
    {
      nextNode.next=currentNode;
      currentNode = nextNode;
      if(remNode == null)
      {
        break;
      }
      nextNode = remNode;
      remNode = nextNode.next;
    }
    head = currentNode;
  }


  public void delete(int index)
  {
    if(index == 0)
    {
      head = head.next;
      return;
    }
    Node current = head;
    int curentIndex = 0;
    while(current != null)
    {
      if(curentIndex == index - 1)
      {
        current.next = current.next.next;
        return;
      }
      current = current.next;
      curentIndex++;
    }
  }

  public void print()
  {
    Node current = head;
    System.out.println("The linked list values are:");
    while(current != null)
    {
      System.out.print(current.data + "\t");
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
    list.print();
    list.prepend(0);
    list.print();
    list.reverse();
    list.insert(56,3);
    list.print();
  }
}

