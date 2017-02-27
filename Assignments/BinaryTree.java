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
   Leaf root;//First leaf
   
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
      else
      {
         current.setLeft(add(target, current.getLeft()));
         return current;
      }
   }
   public void remove(Station target)//May change to ask if that is what should be deleted
   {
      root = remove(target, root);
   }
   private Leaf remove(Station target, Leaf current)
   {
      if(current == null)
         System.out.println("fukin error mate");
      String sTarget = target.getCallsign();
      String sCurrent = current.getDatum().getCallsign();
      if(sCurrent.compareTo(sTarget) < 0)
      {
         current.setRight(remove(target,current.getRight()));
         return current;
      }
      if(sCurrent.compareTo(sTarget) > 0)
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
      current.setLeft(remove(heir.getDatum(), current.getLeft()));
      return current;
   }
}