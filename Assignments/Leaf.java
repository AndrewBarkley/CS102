//********************************************************
//Zachary Mosley                                         *
//Login ID: mosl8748                                     *
//CS102, Winter 2017                                     *
//Programming Assignment 2                               *
//Leaf: An object class to be used by BinaryTree.java    *
//********************************************************

import java.util.*;
import java.io.*;

public class Leaf
{
   private Station datum;//store Station info
   private Leaf left;//stores left Leaf reference
   private Leaf right;//stores left Leaf reference
   
//***********************************************************
//Method: Constructor                                       *
//Purpose: To manage the creation of Station Objects        *
//                                                          *
//Paramaters:             n/a                               *
//Returns:Leaf:           newly built Leaf                  *
//***********************************************************
   public Leaf()
   {
      datum = null;
      left = null;
      right = null;
   }
//***********************************************************
//Method: Constructor                                       *
//Purpose: To manage the creation of Station Objects        *
//                                                          *
//Paramaters:                                               *
// Scanner in           reads input file for assigning data *
//Returns: Station:     Data from requested variable        *
//***********************************************************
   public Leaf(Station input, Leaf left, Leaf right)
   {
      this();
      setDatum(input);
      setLeft(left);
      setRight(right);
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
   public Leaf getLeft()
   {
      return left;
   }
   public Leaf getRight()
   {
      return right;
   }
   
//****************************************************
//Method:  Mutators                                  *
//Purpose: To securely obtain object data            *
//                                                   *
//Paramaters:                                        *
// Station:input     what to set datum as            *
// Leaf:left         what to set this.left to        *
// Leaf:right        what to set this.right to       *
//Returns:           void                            *
//****************************************************   
   public void setDatum(Station input)//edit
   {
      datum = input;
   }
   public void setLeft(Leaf left)//edit
   {
      this.left = left;
   }
   public void setRight(Leaf right)//edit
   {
      this.right = right;
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