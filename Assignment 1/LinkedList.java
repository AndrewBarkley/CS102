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
   
   public Object get(int index)
   {
      if(index < 0 || index > size())
         throw new IndexOutOfBoundsException();
      return get(index, head);
   }
   private Object get(int index, Node current)
   {
      if(index == 0)
         return current;
      return get(--index, current.getNext());
   }
   
   //Dont know the recursive yet but this is a test
   public void add(int index, Scanner input)
   {
      //error handeling
      add(index, input, head);
   }
   private void add(int index, Scanner input, Node current)
   {
      if(index == 1)
      {
         Node added = new Node(input, current.getNext());
         current.setNext(added);
      }
      add(--index, input, current.getNext());
   }
   
   //Expiremental recursive remove
   public void remove(int index)
   {
      //error handeling
      add(index, head);
   }
   private void add(int index, Node current)
   {
      if(index == 1)
      {
         
      }
      add(--index, current.getNext());
   }
}