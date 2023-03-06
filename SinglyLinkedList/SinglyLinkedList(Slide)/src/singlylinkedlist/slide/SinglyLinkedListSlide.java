/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlist.slide;

import java.util.LinkedList;
import singlylinkedlist.slide.SinglyLinkedListSlide.MyList;

/**
 *
 * @author Admin
 */
public class SinglyLinkedListSlide {

    static class Node {

        int info;
        Node next;

        Node() {
        }

        Node(int x, Node p) {
            info = x;
            next = p;
        }

        public int getInfo() {
            return info;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            next = n;
        }

        public void setInfo(int info) {
            this.info = info;
        }
        

        @Override
        public String toString() {
            return String.format("(%d))", info);
        }

    }

    static class MyList {

        private Node head = null;
        private Node tail = null;

        private int size = 0;

        MyList() {

        }

        public int comupute_length() {
            return size;
        }

        boolean isEmpty() {
            return size == 0;
        }
        
        void clear() {
            Node currentNode = head;
            while (currentNode != null) {
                 Node nextNode = currentNode.getNext();
                 currentNode.setNext(null);
                 
             
                 currentNode = nextNode;
             }
            
          
        
            head = tail = null;
              size = 0;
            
        }

        public void add_first(int x) {    //adds element e to the front of the list
            head = new Node(x, head);         //create and link a new node
            if (size == 0) {
                tail = head;             //special case: new node becomes tail also    
            }
            size++;
        }

        public void add(int x) {
            add_last(x);
        }

        public void add_last(int x) {     //adds element e to te end of the list
            Node newest = new Node(x, null);    //node will eventually be the tail
            if (isEmpty()) {
                head = newest;          //special case: previous empty list
            } else {
                tail.setNext(newest);   //new node after existing tail
            }
            tail = newest;              //new node becomes the tail
            size++;
        }

        public void delete_first() {        //removes and returns the first element

            if (isEmpty()) {
                System.err.println("Does not exist");
            }
            Node answer = head;
            head = head.getNext();      //will become null if list had only 1 node
            size--;

            if (size == 0) {
                tail = null;
            }

        }

        public void delete_last() {
            Node newest = head;
            if (isEmpty()) {
                System.err.println("Does not exist");
            }
            while (newest != null) {
                if (newest.next == tail) {
                    newest.next = null;
                    tail = newest;
                    break;
                }

                if (newest.next == null) { //TH chỉ có 1 node
                    head = tail = null;
                    break;
                }

                newest = newest.next;
            }
            size--;

        }

        public void delete_node(int x) {
            Node current = head;
            

            if (isEmpty()) {
                System.err.println("Empty");
            } else {
               
                    
                    if (current.info == x) delete_first();    
                    while (current != null) {
                        if (current.next == null) {
                            break;
                        }
                        
                        if (current.next.info == x) {

                            current.next = current.next.next;
                          
                            size--;
                            continue;

                        }

                        current = current.next; //xét các phần tử của List

                    
                    }
                    
                    
            }
            
        }

        

        public void add_before(int x, int y) {
            Node current = head;
            Node newest = new Node(x, null);
            if (current.getInfo() == y) {
                add_first(x);
            } else {
                while (current != null) {
                    if (current.next.info == y) {
                        newest.next = current.next;
                        current.next = newest;
                        size++;
                        break;
                    }
                    current = current.next;
                }
            }

        }
        
        public void add_after(int x, int y) {
            Node currentFromHead = head;
            Node currentFromTail = tail;
            
            Node newest = new Node(x, null);
            if(currentFromTail.info == y) {
                add_last(x);
                
            } else {
                while (currentFromHead != null) {
                    if(currentFromHead.info == y) {
                        newest.next = currentFromHead.next;
                        currentFromHead.next  = newest;
                        size++;
                        break;
                    }
                    currentFromHead = currentFromHead.next;
                }
            }
            
        }

        public boolean search(int x) {
            Node current = head; // Initialize current pointer
            while (current != null) {
                if (current.info == x) {
                    return true; // data found
                }
                current = current.next;
            }
            return false; // data not found
        }
        
        public void display() {
            Node current = head;
            if (isEmpty()) {
                System.out.println("List now empty");
            } else {
                while (current != null) {
                    if (current.next != null) {
                        System.out.println(current.info);

                    } else {
                        System.out.println(current.info);
                        break;
                    }

                    current = current.next;
                }

            }
        }

        @Override
        public String toString() {
            return "MyList{" + "head=" + head + ", tail=" + tail + ", size=" + size + '}';
        }

    }

    public static void main(String[] args) {

        MyList ml = new MyList();

        ml.add_last(10);
        ml.add_last(5);
        ml.add_last(5);
        ml.add_last(9);
       
        
        ml.add_before(8, 5);
        ml.add_last(0);
        ml.add_after(19, 5);
        ml.delete_node(19);
        ml.add_last(0);
        ml.add_first(0);
        ml.add_last(0);
        ml.delete_node(0);
       
        ml.display();
        

    }

}
