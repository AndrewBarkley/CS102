//********************************************************
//Zachary Mosley                                         *
//Login ID: mosl8748                                     *
//CS102, Winter 2017                                     *
//Programming Assignment 2                               *
//BinaryTree: An object class to store station data      *
//********************************************************

import java.util.*;
import java.io.*;

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
    
   public String search(String target,String type)
   {
      String list = "";//Stores the query results
      return search(target, type, root, list);
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
               System.out.print("You should never have come here");
               throw new IllegalArgumentException();
            }
      }
         
      temp += search(target, type, current.getLeft(), list);
      if(test.contains(target) && !list.contains(test))
      {
         temp += current.getDatum().toString();
      }
      temp += search(target, type, current.getRight(), list);
      
      list = temp;
      return list;
   }
   
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
         System.out.println("Sorry but that call sign is already taken\n");
         return current;
      }
   }
   public void remove(String target)//May change to ask if that is what should be deleted
   {
      root = remove(target, root);
   }
   private Leaf remove(String target, Leaf current)
   {
      if(current == null)
         System.out.println("Error target does not exist");
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
   public void print()
   {
      print(root);
   }
   private void print(Leaf current)
   {
      if(current == null)
         return;
      print(current.getLeft());
      System.out.print(current.getDatum());
      print(current.getRight());
   }
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