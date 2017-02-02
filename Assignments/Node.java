//********************************************************
//Zachary Mosley                                         *
//Login ID: mosl8748                                     *
//CS102, Winter 2017                                     *
//Programming Assignment 2                               *
//Node: An object class to be used by LinkedList.java    *
//********************************************************

import java.util.*;
import java.io.*;

public class Node
{
   private Station datum;//store Station info
   private Node next;//stores next Node reference
   
//***********************************************************
//Method: Constructor                                       *
//Purpose: To manage the creation of Station Objects        *
//                                                          *
//Paramaters:             n/a                               *
//Returns:Node:           newly built Node                  *
//***********************************************************
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
   public Node(Station input, Node next)
   {
      this();
      setDatum(input);
      setNext(next);
      
   }
  
//****************************************************
//Method: Accessors                                  *
//Purpose: To securely obtain object data            *
//                                                   *
//Paramaters:        N/A                             *
//Returns: String:   Data from requested variable    *
//****************************************************
   public Station getDatum()
   {
      return datum;
   }
   public Node getNext()
   {
      return next;
   }
//****************************************************
//Method:  Mutators                                  *
//Purpose: To securely obtain object data            *
//                                                   *
//Paramaters:                                        *
// Station:input     what to set datum as            *
// Node:next         what to set this.next to        *
//Returns:           void                            *
//****************************************************   
   public void setDatum(Station input)//edit
   {
      datum = input;
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