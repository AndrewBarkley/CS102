//********************************************************
//Zachary Mosley                                         *
//Login ID: mosl8748                                     *
//CS102, Winter 2017                                     *
//Programming Assignment 1                               *
//Node: An object class to be used by LinkedList.java    *
//********************************************************

import java.util.*;
import java.io.*;

public class Node
{
   private Station datum;
   private Node next;
   
   public Node()
   {
      datum = null;
      next = null;
   }
   
//***********************************************************
//Method: Constructor                                       *
//Purpose: To manage the creation of Station Objects        *
//                                                          *
//Paramaters:                                               *
// Scanner in           reads input file for assigning data *
//Returns: Station:     Data from requested variable        *
//***********************************************************
   public Node(Scanner input, Node next)
   {
      this();
      setDatum(input);
      setNext(next);
      
   }
  
//****************************************************
//Method: Accessors/Mutators                         *
//Purpose: To securely obtain object data            *
//                                                   *
//Paramaters:        N/A                             *
//Returns: String:   Data from requested variable    *
//****************************************************
   public Station getDatum()
   {
      return datum;
   }
   
   public void setDatum(Scanner input)//edit
   {
      datum = new Station(input);
   }
   
   public Node getNext()
   {
      return next;
   }
   
   public void setNext(Node next)//edit
   {
      this.next = next;
   }
   
//*********************************************************
//Method: toString                                        *
//Purpose: To return a string representing the Object     *
//                                                        *
//Paramaters:           N/A                               *
//Returns: String:      Represents the Object as a String *
//*********************************************************
   public String toString()
   {
      return datum.toString();
   }
}