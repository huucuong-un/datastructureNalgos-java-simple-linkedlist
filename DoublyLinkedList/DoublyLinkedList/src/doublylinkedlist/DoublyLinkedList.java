/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;

import java.util.Iterator;

/**
 *
 * @author Admin
 */
public class DoublyLinkedList {

    class Node<T> {
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
        
        

        @Override
        public String toString() {
            return data.toString();
        }
        
        
        
    }
    
    class MyDoublyLinkedList<T> {
        private int size;
        private Node<T> head = null;
        private Node<T> tail = null; 
        
        
        public void clear() {
            Node<T> currentNode = head;
             while (currentNode != null) {
                 Node<T> nextNode = currentNode.getNext();
                 currentNode.setNext(null);
                 currentNode.setPrev(null);
                 currentNode.setData(null);
                 currentNode = nextNode;
             }
             
             head = tail = null;
             
             size = 0;
                   
        }
        
       public int size() {
           return size;
       } 
       
       public boolean isEmpty() {
           return size() == 0;
       }
       
       public void add(T element) {
           addLast(element);
       }
       
        
        public void addFirst(T element) {
           if(isEmpty()) {
               head = tail = new Node(element, null, null);
           } else {
               Node<T> newest = new Node(element, null, head);
               head.setPrev(newest);
               head = head.getPrev();
           }
           size++;
               
       }
        public void addLast(T element) {
           if(isEmpty()) {
               head = tail = new Node(element, null, null);
           } else {
               Node<T> newest = new Node(element, tail, null);
               tail.setNext(newest);
               tail = tail.getNext();
           }
           size++;
               
       }
        
       public T peekFirst() {
           if(isEmpty()) throw new RuntimeException("Empty linked list");
           return head.getData();
       }
       
       public T peekLast() {
           if(isEmpty()) throw new RuntimeException("Empty linked list");
           return tail.getData();
       }
       
        public T removeFirst() {
            if(isEmpty()) throw new RuntimeException("Empty linked list");
            T data = head.getData();
            head  = head.getNext();
            size--;
            if (isEmpty()) tail = null;
            else head.setPrev(null);
            
            return data;
        }
       
        public T removeLast() {
            if(isEmpty()) throw new RuntimeException("Empty linked list");
            T data = tail.getData();
            tail  = tail.getPrev();
            size--;
            if (isEmpty()) head = null;
            else tail.setNext(null);
            
            return data;
        }
        
        public T remove(Node<T> node) {
            if(node.getPrev() == null) removeFirst();
            if(node.getNext() == null) removeLast();
            
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            
            T data = node.getData();
            size--;
            
            node.setData(null);
            node.setNext(null);
            node.setPrev(null);
            node = null;
            
            return data;
            
        }
        
        public boolean remove(Object object) {
            Node<T> currentNode = head;
            
            if (object == null) {
              
                while (currentNode != null) {
                    if(currentNode.getData() == null) {
                        remove(currentNode);
                        return true;
                    }
                    currentNode = currentNode.getNext();
                }
            } else {
                while (currentNode != null) {
                     if(currentNode.getData() == object) {
                        remove(currentNode);
                        return true;
                    }
                    currentNode = currentNode.getNext();
                }
            }
            
            return false;
        }
        
        public T removeAt(int index) {
            if (index < 0 || index >= size) throw new IllegalArgumentException();
            
            int i;
            
            Node<T> currentNode;
            
            if (index < size / 2) {
                i = 0;
                currentNode = head;
                while (i != index) {
                    currentNode = currentNode.getNext();
                    i++;
                }
            } else {
                i = size - 1;
                currentNode = tail;
                 while (i != index) {
                    currentNode = currentNode.getPrev();
                    i--;
                }
            }
            
            return remove(currentNode);
            
        }
        
        public int indexOf(Object object) {
            int index = 0; 
            
            Node<T> currentNode = head;
            if (object == null) {
                while(currentNode != null) {
                    if(currentNode.getData() == null) {
                        return index;
                    }
                    currentNode = currentNode.getNext();
                    index++;
                }
                
            } else {
                while(currentNode != null) {
                    if(currentNode.getData() == object) {
                        return index;
                    }
                    currentNode = currentNode.getNext();
                    index++;
                }
            }
            return -1;
        }
        
        public boolean contains(Object object) {
            return indexOf(object) != -1;
        }
        
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private Node<T> currentNode = head;
                
                @Override
                public boolean hasNext() {
                    return currentNode != null;
                }

                @Override
                public T next() {
                    T data = currentNode.getData();
                    currentNode = currentNode.getNext();
                    return data;
                }
            };
        }
        
        @Override
        public String toString() {
            if(isEmpty()) return "[]";
            else {
                StringBuilder sb = new StringBuilder(size);
                sb.append("[");
                
                Node<T> currentNode = head;
                
                while (currentNode != null) {
                    sb.append(currentNode.getData());
                    if(currentNode.getNext() != null) sb.append(", ");
                    currentNode = currentNode.getNext();
                }
                sb.append(" ]");
                return sb.toString();
                
            }
        }
       
       
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
