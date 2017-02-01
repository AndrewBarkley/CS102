//********************************************
//Zachary Mosley                             *
//Login ID: mosl8748                         *
//CS102, Winter 2017                         *
//Programming Assignment 1                   *
//Database: Stores all Stations in an array  *
//********************************************

import java.util.*;
import java.io.*;

public class LinkedList implements ListInterface
{
   Node head;
   
   public LinkedList()
   {
      head = null;
   }
   public boolean isEmpty()
   {
      return (head == null);
   }
   public int size()
   {
      return size(head);
   }
   private int size(Node current)
   {
      if(current == null)
         return 0;
      return size(current.getNext()) + 1;
   }
   //get
   public Station get(int index)
   {
      if(index < 0 || index > size())
         throw new IndexOutOfBoundsException();
      return get(index, head);
   }
   private Station get(int index, Node current)
   {
      if(index == 0)
         return current.getDatum();
      return get(--index, current.getNext());
   }
   //add
   public void add(int index, Scanner input)
   {
      //error handeling
      head = add(index, input, head);
   }
   private Node add(int index, Scanner input, Node current)
   {
      if(index == 0)
      {
         Node splice = new Node(input, current);
         return splice;
      }
      if (current == null)
         throw new IndexOutOfBoundsException();
      current.setNext(add(--index, input, current.getNext()));
      return current;
   }
   //remove
   public Station remove(int index)
   {
      //error handeling
      Station temp = get(index);
      remove(index, head);
      return temp;
   }
   private Node remove(int index, Node current)
   {
      if(current == null)
         throw new IndexOutOfBoundsException();
      if(index == 0)
      {
         return current.getNext();
      }
      current.setNext(remove(--index,current.getNext()));
      return current;
   }
   public void removeAll()
   {
      head = null;
   }
   //sort
   public void sort()
   {
      head = sort(head);
   }
   private Node sort(Node current)
   {
      Node next = current.getNext();
      if(next == null)
         return current;
      String currentSign = current.getDatum().getCallsign();
      String nextSign = next.getDatum().getCallsign();
      int compare = currentSign.compareTo(nextSign);
      if(compare > 0)
      {
         current.setNext(next.getNext());
         next.setNext(current);
         return sort(current);
      }
      return sort(next);
      
   }
}