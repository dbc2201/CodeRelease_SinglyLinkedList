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

    //  add constructor for the Node class to initialize the objects
    public Node(int data, Node nextNode) {
      this.data = data;
      this.nextNode = nextNode;
    }
  }

  //  this reference variable will hold the reference to the first node, 'head'
  public Node head = null;

  //  this variable will hold the size for the current singly linked list
  public int size = 0;

  /*
  * main method, this method is written here just for the demo of the linked list.
  * Usually this main method will be outside of the linked list class file
  * */
  public static void main(String[] args) {
    //  create an object for the SinglyLinkedList class
    SinglyLinkedList linkedList = new SinglyLinkedList();

    //  display the linkedlist via println() method
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
      temp = temp.nextNode;
    }

    //  append a ] for the end of the list
    result.append("]");
    return result.toString();
  }

  private void insertHead(int data) {
    this.head = new Node(data, this.head);
    size++;
  }

}
