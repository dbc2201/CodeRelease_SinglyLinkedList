package main;

public class SinglyLinkedList {

  /*
   * Specifications for the Singly Linked List Class:
   * 1. A pointer to the first node of the list called 'Head' of 'Node' type.
   * 2. A variable to store the current number of node in the list called 'size'.
   * 3. A specification class for the 'Node' type for the main.SinglyLinkedList
   * 4. Private helper methods for the methods
   * 5. Public methods for the main.SinglyLinkedList class to serve as the functions of the list.
   * */

  private static class Node {

    /*
     * Specifications for the Node Class:
     * 1. A variable/container to hold the data for the node.
     * 2. A reference of the next node of the current node of type 'Node'.
     * */

    //  this variable will hold the data for the current node
    private int data;

    // this reference variable will hold the reference to the next node
    private Node nextNode;

    //  method to return the 'data' of the current node
    public int getData() {
      return data;
    }

    //  method to return the 'next node' of the current node
    public Node getNextNode() {
      return nextNode;
    }

    //  method to set the value of data for a node
    public void setData(int data) {
      this.data = data;
    }

    //  method to set the reference of a new node as the next node
    public void setNextNode(Node nextNode) {
      this.nextNode = nextNode;
    }

    //  add constructor for the Node class to initialize the objects
    public Node(int data, Node nextNode) {
      this.data = data;
      this.nextNode = nextNode;
    }
  }

  //  this reference variable will hold the reference to the first node, 'head'
  private Node head = null;

  //  this variable will hold the size for the current singly linked list
  private int size = 0;

  /*
   * main method, this method is written here just for the demo of the linked list.
   * Usually this main method will be outside of the linked list class file
   * */
  public static void main(String[] args) {
    //  create an object for the SinglyLinkedList class
    SinglyLinkedList linkedList = new SinglyLinkedList();

    System.out.println("Printing the list first time:");
    //  display the linkedlist via println() method
    System.out.println(linkedList);

    System.out.println("Inserting 5 values in the linked list");
    //  iterate a loop 5 times to insert 5 values in the linked list
    for (int i = 0; i < 5; i++) {
      linkedList.insert(i);
      System.out.println(linkedList);
    }

    int randomNumber = (int) (Math.random() * 10);

    int deleted = linkedList.remove(randomNumber);

    if (deleted == -1) {
      System.out.println(randomNumber + " was not found in the linked list.");
    } else {
      System.out.println(deleted + " was deleted.");
    }

    System.out.println(linkedList);

  }

  @Override
  public String toString() {
    //  create a new StringBuilder for returning as the result
    StringBuilder result = new StringBuilder();

    //  append a [ for the start of the list
    result.append("[");

    //  create a copy for the current 'head' node for the list
    Node temp = this.head;

    //  travers the current linked list
    while (temp != null) {

      //  append the data of the current node to the result
      result.append(temp.getData());

      // check if the current node has a next node
      if (temp.getNextNode() != null) {
        //  append an arrow to depict the single reference between two nodes
        result.append(" --> ");
      }

      //  update the reference of temp to the next node
      temp = temp.getNextNode();
    }

    //  append a ] for the end of the list
    result.append("]");
    return result.toString();
  }

  /*
   * Helper method to insert a new node at head
   * DO NOT CALL HELPER METHODS FROM THE MAIN METHOD FOR THE LINKED LIST CLASS!
   * THEY ARE SUPPOSED TO BE INVISIBLE TO THE DEV/USER ALIKE.
   * */
  private void insertHead(int data) {
    this.head = new Node(data, this.head);
    size++;
  }

  /*
   * Helper method to insert a new node after a given node
   * */
  private void insertAfter(int data, Node node) {
    node.setNextNode(new Node(data, node.getNextNode()));
    size++;
  }

  /*
   * Actual method to insert a new node in the singly linked list
   * THIS IS THE ONLY METHOD THAT IS VISIBLE TO THE DEV/USER TO INSERT A NEW NODE
   * */
  public void insert(int data) {
    /*
     * check whether the head points to a null reference,
     * if true, it means that the linked list is empty
     * */
    if (this.head == null) {
      //  insert the data as a new node at the head
      insertHead(data);
    } else {
      //  traverse the linked list to the end

      //  create a copy of the current head
      Node temp = this.head;

      //  check whether the next node of the current node is null
      while (temp.getNextNode() != null) {
        //  update the reference of the temp node
        temp = temp.getNextNode();
      }
      insertAfter(data, temp);
    }
  }

  /*
   * Helper method to delete the first node of a linked list
   * */
  private int deleteHead() {
    //  flag variable to hold the value of deleted head or -1 to show nothing deleted
    int response = -1;

    //  check whether the list has a head node to delete
    if (this.head != null) {

      //  set the response var to the value of the current head
      response = this.head.getData();

      //  create a copy of the current head of the linked list
      Node temp = this.head;

      //  point the head pointer to the next node of old head
      this.head = temp.getNextNode();
    }

    //  update the size of the list
    size--;
    return response;
  }

  private int deleteAfter(Node node) {
    int response = -1;

    //  create a copy of the next node
    Node temp = node.getNextNode();

    // check if the temp node is null
    if (temp != null) {
      response = temp.getData();
      node.setNextNode(temp.getNextNode());
    }

    size--;
    return response;
  }

  public int remove(int data) {
    int response = -1;

    //  check whether the head node is the node to be deleted
    if (this.head.data == data) {
      response = deleteHead();
    } else {
      //  create a copy of the current head
      Node temp = this.head;
      while (temp != null) {
        if (temp.getNextNode().getData() == data) {
          response = deleteAfter(temp);
          break;
        }
        temp = temp.getNextNode();
      }
    }
    return response;
  }

}
