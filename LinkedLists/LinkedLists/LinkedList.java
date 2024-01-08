package LinkedLists;
public class LinkedList
{
  public Node head = null;
  public Node tail = null;
  public int length = 0;

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
    length ++; //We increment  
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
    length ++; //We increment 
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
    length ++; //We increment 
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

  public void clear()
  {
    head = null;
    tail = null;
    length = 0;
  }

  public void delete(int index)
  {
    if(index == 0)
    {
      if(head!=null)
      {
        head = head.next;
        length--;
      }  
      return;
    }
    if (index>0 && index <length)
    {
      length--;
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
    else
    {
      //We throw error
    }
  }

  public void rFirst()
  {
    head = head.next;
  }

  public void rLast()
  {
    this.delete(this.length-1);
  }
  public void print()
  {
    Node current = head;
    while(current != null)
    {
      System.out.print(current.data + "\t");
      current = current.next;
    }
    System.out.println();
  }

  public void sort()
  {
    //Sorting techniques
    /* Implementation of BubbleSort
     * Best case: O(n)
     * Worst case: O(n2)
     */

    boolean isChanged = false;
    do
    {
      Node current = head;
      Node next = current.next;
      isChanged = false;
      do
      {
        int nextValue = next.data;
        if (current.data > nextValue)
        {
          isChanged = true;
          current.next.data = current.data;
          current.data = nextValue;
          
        }
        current = current.next;
        next = current.next;
      }while(current.next != null);
    }while(isChanged);
    
    /*Implementation of InsertionSort
     * Best case:
     * Worst case:
     */
    
  }

  public boolean search(int value)
  {
    Node current=head;
    while(current.next != null)
    {
      if (current.data == value)
      {
        return true;
      }
      current = current.next;
    }
    return false;
  }
  
  public static LinkedList merge(LinkedList first, LinkedList second)
  {
    Node elderNode, childNode;
    LinkedList parentLinkedList;
    if (first.head.data<second.head.data)
    {
      elderNode = first.head;
      childNode = second.head;
      parentLinkedList = first;
    }
    else
    {
      elderNode = second.head;
      childNode = first.head;
      parentLinkedList = second;
    }
    while(elderNode.next!=null && childNode.next!=null)
    {

      if(elderNode.next.data < childNode.data)
      {
        elderNode = elderNode.next;
        continue;
      }
      Node next = elderNode.next;
      elderNode.next = childNode;
      childNode = childNode.next;
      elderNode.next.next = next;
    }
    if(childNode!=null)
    {
      elderNode.next = childNode;
    }
    return parentLinkedList;
  }
 
  public int detectCycle()
  {
    //TODO
    return 0;
  }
  public static void main(String[] args)
  {
    LinkedList list1 = new LinkedList();
    LinkedList list2 = new LinkedList();
    list1.append(28);
    list1.append(29);
    list1.append(30);
    list1.append(41);
    list1.append(62);
    list2.append(29);
    list2.append(50);
    list2.append(60);
    list2.append(77);
    list2.append(93);
    list1.print();
    list2.print();
    LinkedList mLinkedList = merge(list1, list2);
    mLinkedList.print();
  }
}

