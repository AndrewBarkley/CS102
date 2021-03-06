//********************************************************
//Zachary Mosley                                         *
//Login ID: mosl8748                                     *
//CS102, Winter 2017                                     *
//Programming Assignment 5                               *
//BinaryTree: An object class to store station data      *
//********************************************************

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BinaryTree
{
   private Leaf root;//First leaf
   final String SEARCH_CALLSIGN = "1";
   final String SEARCH_FREQUENCY = "2";
   final String SEARCH_HOME = "3";
   final String SEARCH_FORMAT = "4";
   final String ADD_NODE = "5";
   final String REMOVE = "6";
   final String PRINT = "7";
   final String EXPORT = "8";
   final String IMPORT = "9";
   final String QUIT = "0";
   
//**************************************************************
//Method: BinaryTree                                           *
//Purpose: constructs an empty tree where root = null          *
//                                                             *
//Paramaters:          n/a                                     *
//Returns:             void                                    *
//**************************************************************
   public BinaryTree()
   {
      root = null;
   }
   
//******************************************************
//Method: search                                       *
//Purpose: searches if target is in tree               *
//                                                     *
//Paramaters:                                          *
// Station target    The Station you're looking for    *
// Leaf current      Cycles throught the tree looking  *
//Returns:                                             *
// boolean           True if station is there          *
//******************************************************
   public boolean search(Station target)
   {
      return search(target, root);
   }
   private boolean search(Station target, Leaf current)
   {
      if(current==null)
         return false;
         
      String sTarget = target.getCallsign();
      String sCurrent = current.getDatum().getCallsign();
      
      if(sCurrent.equals(sTarget))
         return true;
      if(sCurrent.compareTo(sTarget) > 0)//check '> 0'
         return search(target, current.getLeft());
      else
         return search(target, current.getRight());
   }
    
//*********************************************************
//Method: search                                          *
//Purpose: searches if target is in tree & returns it     *
//                                                        *
//Paramaters:                                             *
// String target    The String you're looking for         *
// String type      Where to look for the target          *
// Leaf current     Cycles throught the tree looking      *
// String list      Holds all stations that match target  *
//Returns:                                                *
// String list       True if station is there             *
//*********************************************************
   public String search(String target,String type)
   {
      String list = "";//Stores the query results
      list += search(target, type, root, list);
      list += "</html>";
      return list;
   }
   private String search(String target,String type,Leaf current,String list)
   {
      String temp = "";
      if(current == null)
      {
         return "";
      }
      String test = "";//gets search subject
      switch (type)
      {
         case SEARCH_CALLSIGN:
            test = current.getDatum().getCallsign();
            break;
         case SEARCH_FREQUENCY:
            test = current.getDatum().getFrequency();
            break;
         case SEARCH_HOME:
            test = current.getDatum().getHome();
            break;
         case SEARCH_FORMAT:
            test = current.getDatum().getFormat();
            break;
         default:
            {
               JOptionPane.showMessageDialog(null, "If you're reading this, my code broke", 
                                    "ERROR", JOptionPane.WARNING_MESSAGE);
               throw new IllegalArgumentException();
            }
      }
         
      temp += search(target, type, current.getLeft(), list);
      if(test.contains(target))// && !list.contains(test))
      {
         temp += current.getDatum().toString() + "<br>";
      }
      temp += search(target, type, current.getRight(), list);
      
      list = temp;
      return list;
   }
   
//************************************************
//Method: add                                    *
//Purpose: adds a Station to the tree            *
//                                               *
//Paramaters:                                    *
// Station target    The Station you're adding   *
// Leaf current      Where to add the station    *
//Returns:               void                    *
//************************************************
   public void add(Station target)
   {
      root = add(target, root);
   }
   private Leaf add(Station target, Leaf current)
   {
      if(current == null)
      {
         Leaf leaf = new Leaf(target, null, null);
         return leaf;
      }
      String sTarget = target.getCallsign();
      String sCurrent = current.getDatum().getCallsign();
      
      if(sCurrent.compareTo(sTarget) < 0)
      {
         current.setRight(add(target, current.getRight()));
         return current;
      }
      else if(sCurrent.compareTo(sTarget) > 0)
      {
         current.setLeft(add(target, current.getLeft()));
         return current;
      }
      else
      {
         JOptionPane.showMessageDialog(null, "Sorry, that callsign is already in use", 
                                    "Warning", JOptionPane.WARNING_MESSAGE);
         return current;
      }
   }
   
//************************************************
//Method: remove                                 *
//Purpose: removes a Station from the tree       *
//                                               *
//Paramaters:                                    *
// Station target    The Station you're removing *
// Leaf current      Where the target is         *
//Returns:               void                    *
//************************************************
   public void remove(String target)
   {
      root = remove(target, root);
   }
   private Leaf remove(String target, Leaf current)
   {
      if(current == null)
      {
         JOptionPane.showMessageDialog(null, "ERROR: Station Does Not Exist", 
                                    "ERROR", JOptionPane.ERROR_MESSAGE);
         throw new IndexOutOfBoundsException();
      }
      String sCurrent = current.getDatum().getCallsign();
      if(sCurrent.compareTo(target) < 0)
      {
         current.setRight(remove(target,current.getRight()));
         return current;
      }
      if(sCurrent.compareTo(target) > 0)
      {
         current.setLeft(remove(target,current.getLeft()));
         return current;
      }
      if(current.getLeft() == null)
         return current.getRight();
      if(current.getRight() == null)
         return current.getLeft();
      Leaf heir = current.getLeft();
      while(heir.getRight() != null)
         heir = heir.getRight();
      current.setDatum(heir.getDatum());
      current.setLeft(remove(heir.getDatum().getCallsign(), current.getLeft()));
      return current;
   }
   
//*********************************************
//Method: print                               *
//Purpose: prints the tree                    *
//                                            *
//Paramaters:                                 *
// Leaf current   Cycles through entire tree  *
//Returns:                                    *
// String temp    holds entire tree           *
//*********************************************
   public String print()
   {
      String temp = "";
      temp += print(root);
      temp += "</html>";
      return temp;
   }
   private String print(Leaf current) // untested
   {
      String temp = "";
      if(current == null)
         return temp;
      temp += print(current.getLeft());
      temp += current.getDatum() + "<br>";
      temp += print(current.getRight());
      
      return temp;
   }
   
//*********************************************
//Method: export                              *
//Purpose: returns the tree in specific order *
//                                            *
//Paramaters:                                 *
// Leaf current   Cycles through entire tree  *
// String list    holds entire tree           *
//Returns:                                    *
// String list    holds entire tree           *
//*********************************************
   public String export()
   { 
      String list = "";
      return export(root, list);
   }
   private String export(Leaf current, String list)
   {
      String temp = "";
      if(current == null)
         return "";
      temp += current.getDatum().export();
      temp += export(current.getLeft(),list);
      temp += export(current.getRight(),list);
      list = temp;
      return list;
   }
}