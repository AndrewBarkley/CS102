//********************************************
//Zachary Mosley                             *
//Login ID: mosl8748                         *
//CS102, Winter 2017                         *
//Programming Assignment 2                   *
//LinkedList: creates & manages all nodes    *
//********************************************

import java.util.*;
import java.io.*;

public class LinkedList implements ListInterface
{
   Node head;//first node of each list.
   
//**************************************************************
//Method: LinkedList                                           *
//Purpose: constructs an empty list where head = null          *
//                                                             *
//Paramaters:          n/a                                     *
//Returns:             void                                    *
//**************************************************************
   public LinkedList()
   {
      head = null;
   }
//**************************************************************
//Method: issEmpty                                             *
//Purpose: Returns true if head = null                         *
//                                                             *
//Paramaters:          n/a                                     *
//Returns:boolean:     true if the list is empty               *
//**************************************************************
   public boolean isEmpty()
   {
      return (head == null);
   }
//****************************************************************
//Method: size                                                   *
//Purpose: Returns the number of nodes in a list(Recursive Pair) *
//                                                               *
//Paramaters:                                                    *
// Node:current        current adds nodes to find size           *
//Returns:int:         number of nodes in the list               *
//****************************************************************
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
//****************************************************************
//Method: get                                                    *
//Purpose: Returns the Station at the index(Recursive Pair)      *
//                                                               *
//Paramaters:                                                    *
// int:index           where in the list to pull from            *
// Node:current        current counts nodes to find index        *
//Returns:Station:     the Station in the Node at the index      *
//****************************************************************
   public Station get(int index)
   {
      if(index < 0 || index > size())//should never occur
         throw new IndexOutOfBoundsException();
         
      return get(index, head);
   }
   private Station get(int index, Node current)
   {
      if(index == 0)
         return current.getDatum();
      return get(--index, current.getNext());
   }
//*************************************************************
//Method: add                                                 *
//Purpose: Adds Node at index(Recursive Set)                  *
//                                                            *
//Paramaters:                                                 *
// int:index           where in the list to add to            *
// Station:input       the datum to add to the node           *
// Node:current        what to set as next for the new node   *
//Returns:             void                                   *
//*************************************************************
   public void add(Station input)
   {
      head = add(0, input, head);
   }
   public void add(int index, Station input)
   {
      head = add(index, input, head);
   }
   private Node add(int index, Station input, Node current)
   {
      if(index == 0)
      {
         Node splice = new Node(input, current);//the new node
         return splice;
      }
      if (current == null)//warning you've gone too far
         throw new IndexOutOfBoundsException();
      current.setNext(add(--index, input, current.getNext()));
      return current;
   }
//*****************************************************************
//Method: remove                                                  *
//Purpose: removes Node at index(Recursive Pair)                  *
//                                                                *
//Paramaters:                                                     *
// int:index           where in the list to remove from           *
// Node:current        what to set as next for the previous node  *
//Returns:Station:     the Station that was removed               *
//*****************************************************************
   public Station remove(int index)
   {
      //error handeling
      Station temp = get(index);//Station at index
      remove(index, head);
      return temp;
   }
   private Node remove(int index, Node current)
   {
      if(current == null)//warning nothing here
         throw new IndexOutOfBoundsException();
      if(index == 0)//remove current
      {
         return current.getNext();
      }
      current.setNext(remove(--index,current.getNext()));
      return current;
   }
//*******************************
//Method: removeAll             *
//Purpose: sets head to null    *
//                              *
//Paramaters:          n/a      *
//Returns:             void     *
//*******************************
   public void removeAll()
   {
      head = null;
   }
//*****************************************************************
//Method: sort                                                    *
//Purpose: orders (Recursive Pair)                                *
//                                                                *
//Paramaters:                                                     *
// Node:current        shifts Nodes by one to sort the list       *
//Returns:             void                                       *
//*****************************************************************
   public void sort()
   {
      head = sort(head);
   }
   private Node sort(Node current)
   {
      try//ensures theres more list
      {
         if(current.getNext() == null)
            return current;
      }
      catch (NullPointerException handeled)
      {
         return current;
      }
      Node next = current.getNext();//a node to compare to
      String currentSign = current.getDatum().getCallsign();//current callsign
      String nextSign = next.getDatum().getCallsign();//next callsign
      int compare = currentSign.compareTo(nextSign);//Pos. if in wrong order
      if(compare > 0)//wrong order, switch
      {
         current.setNext(next.getNext());
         next.setNext(sort(current));//do next index
         return next;
      }
      current.setNext(sort(next));//do next index
      return current;
   }
}