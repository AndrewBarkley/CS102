//***********************************************
//Zachary Mosley                                *
//Login ID: mosl8748                            *
//CS102, Winter 2017                            *
//Programming Assignment 5                      *
//Display: GUI                                  *
//***********************************************

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display extends JFrame
{
   //These are constants to label each button
   final int SEARCH_CALLSIGN = 0;
   final String SEARCH_S_CALLSIGN = "1";
   final int SEARCH_FREQUENCY = 1;
   final String SEARCH_S_FREQUENCY = "2";
   final int SEARCH_HOME = 2;
   final String SEARCH_S_HOME = "3";
   final int SEARCH_FORMAT = 3;
   final String SEARCH_S_FORMAT = "4";
   final int ADD_NODE = 4;
   final int REMOVE = 5;
   final String S_REMOVE = "5";
   final int EXPORT = 6;
   final int IMPORT = 7;
   public Database database;//holds station data
   private Container contents;//holds the window panel
   private JPanel optionPanel;//holds layout
   private JButton [] optionButtons;//main buttons
   private String [] optionNames = {//button names
            "Search Callsign",
            "Search Frequency",
            "Search Home",
            "Search Format",
            "Add",
            "Remove",
            "Export",
            "Import",
            "Print" };

   //****************************************************
   //Method: Display                                    *
   //Purpose: GUI Constructor                           *
   //                                                   *
   //Paramaters:                                        *
   // Database database     holds all station data      *
   //Returns:               Display object              *
   //****************************************************
   public Display(Database database)
   {
      super( "Radio Database" );//titles the window
      this.database = database;//database is now a class variable
   
      //setup the layout
      contents = getContentPane( );
      contents.setLayout( new GridLayout() );
   
      optionPanel = new JPanel( );
      optionPanel.setLayout( new GridLayout( 5, 2 ) );
   
      //create buttons and add them to a common listeners
      OptionButtonHandler obh = new OptionButtonHandler( );
      optionButtons = new JButton[optionNames.length];
   
      for ( int i = 0; i < optionNames.length; i ++ )
      {
         optionButtons[i] = new JButton( optionNames[i] );
         optionButtons[i].addActionListener( obh );
         optionPanel.add( optionButtons[i] );
      }
   
   // add panels to content pane
      contents.add( optionPanel );
   
      setSize( 350, 300 );
      setVisible( true );
   }

   //****************************************************
   //Class: OptionButtonHandler                         *
   //Purpose: Waits for a button press                  *
   //****************************************************
   private class OptionButtonHandler
                        implements ActionListener
   {
      String input = "";//contains the input data for most options
      public void actionPerformed( ActionEvent ae )
      {
         if ( ae.getSource( ) == optionButtons[SEARCH_CALLSIGN] )
         {
            input = JOptionPane.showInputDialog("Enter Callsign");
            if(input != null && !input.equals(""))
            {
               print(database.search( input,SEARCH_S_CALLSIGN,"am"),
                     database.search( input,SEARCH_S_CALLSIGN,"fm"));
            }
         }
         else if ( ae.getSource( ) == optionButtons[SEARCH_FREQUENCY] )
         {
            input = JOptionPane.showInputDialog("Enter Frequency");
            if(input != null && !input.equals(""))
            {
               print(database.search( input,SEARCH_S_FREQUENCY,"am"),
                     database.search( input,SEARCH_S_FREQUENCY,"fm"));
            }
         }
         else if ( ae.getSource( ) == optionButtons[SEARCH_HOME] )
         {
            input = JOptionPane.showInputDialog("Enter Home");
            if(input != null && !input.equals(""))
            {
               print(database.search( input,SEARCH_S_HOME,"am"),
                     database.search( input,SEARCH_S_HOME,"fm"));
            }
         }
         else if ( ae.getSource( ) == optionButtons[SEARCH_FORMAT] )
         {
            input = JOptionPane.showInputDialog("Enter Format");
            if(input != null && !input.equals(""))
            {
               print(database.search( input,SEARCH_S_FORMAT,"am"),
                     database.search( input,SEARCH_S_FORMAT,"fm"));
            }
         }
         else if ( ae.getSource( ) == optionButtons[ADD_NODE] )
         {
            String test = "";//compares against input to prevent empty input
            input = JOptionPane.showInputDialog("Enter Band");
            if(input != null && !input.equals(""))
            {
               input += "/";
               test = input;
               input += JOptionPane.showInputDialog("Enter Callsign");
               if(!input.equals(test))
               {
                  input += "/";
                  test = input;
                  input += JOptionPane.showInputDialog("Enter Frequency");
                  if(!input.equals(test))
                  {
                     input += "/";
                     test = input;
                     input += JOptionPane.showInputDialog("Enter Home");
                     if(!input.equals(test))
                     {
                        input += "/";
                        test = input;
                        input += JOptionPane.showInputDialog("Enter Format");
                        if(!input.equals(test))
                        {
                           database.add(input);
                        }
                     }
                  }
               }
            }
         }
         else if ( ae.getSource( ) == optionButtons[REMOVE] )
         {
            input = "";//Resets input String
            String test = "";//tests to ensure non-empty input
            String band = JOptionPane.showInputDialog("Enter Station Band");
            input += band;
            if(!input.equals("null") && !input.equals(""))
            {
               input += "/";
               test = input;
               String call = JOptionPane.showInputDialog("Enter Station Callsign");
               input += call;
               if(!input.equals(test))
               {
                  try
                  {
                     test = database.search( call,SEARCH_S_CALLSIGN,band);
                     //remove excess title data from test
                     test = test.replace("<html>AM Stations","");
                     test = test.replace("<html>FM Stations","");
                     test = test.replace("</html>","");
                     test = test.replace("<br>","");
                     test = "Are You Sure? Remove:\n" + test;
                     if(test.equals("Are You Sure? Remove:\n"))//search() found no station
                        throw new IndexOutOfBoundsException();
                                 
                     int removeBool;//asks for confirmation
                     removeBool = JOptionPane.showConfirmDialog(null,test, "Removing", 
                                                   JOptionPane.YES_NO_OPTION, 
                                                   JOptionPane.WARNING_MESSAGE);
                  
                     if(removeBool == 0)
                     {
                        database.remove(input);
                        JOptionPane.showMessageDialog(null, "Station Removed", 
                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                     }
                  }
                  catch(IndexOutOfBoundsException handeled)
                  {
                     JOptionPane.showMessageDialog(null, "Station Not Found", "ERROR", JOptionPane.ERROR_MESSAGE);
                  }
               }
            }
         }
         else if ( ae.getSource( ) == optionButtons[EXPORT] )
         {
            input = JOptionPane.showInputDialog("Enter Your Filename (without .txt)");
            if(input != null && !input.equals(""))
            {
               int exportBool;//confirmation
               exportBool = JOptionPane.showConfirmDialog(null,"Save as:\n"+input+".txt", 
                                             "Exporting", JOptionPane.YES_NO_OPTION, 
                                             JOptionPane.WARNING_MESSAGE);
               if(exportBool == 0)
                  database.export(input);  
            }                                         
         }
         else if ( ae.getSource( ) == optionButtons[IMPORT] )
         {
            input = JOptionPane.showInputDialog("Enter Full Filename");
            if(input != null && !input.equals(""))
            {
               int importBool;//confirmation
               importBool = JOptionPane.showConfirmDialog(null,
                                 "Erase Current Database and Import:\n"+input, 
                                 "Exporting", JOptionPane.YES_NO_OPTION, 
                                 JOptionPane.WARNING_MESSAGE);
               if(importBool == 0)
               {
                  database.initialize(input);
                  JOptionPane.showMessageDialog(null, "Import Successful", 
                                    "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
               }
            }
         }
         else 
         {
            print( database.print("am"),database.print("fm") );  
         }
      }
   }
   
   //*****************************************************
   //Method: print                                       *
   //Purpose: creates window to display all station data *
   //                                                    *
   //Paramaters:                                         *
   // String amString   holds data for am stations       *
   // String fmString   holds data for fm stations       *
   //Returns:           void                             *
   //*****************************************************
   public void print( String amString, String fmString )
   {
         //Create Window with Dual Column Layout
      JFrame frame = new JFrame( "Station Data" );
         //setup layouts
      Container bands = new Container( );
      bands.setLayout( new GridLayout( 1,2,5,0 ) );
      frame.add( bands );
      Container am = new Container( );
      Container fm = new Container( );
      am.setLayout( new FlowLayout( ) );
      fm.setLayout( new FlowLayout( ) );
      bands.add( am );
      bands.add( fm );
            
         //Add Labels
      JLabel amData = new JLabel( amString );
      JLabel fmData = new JLabel( fmString );
      am.add( amData );
      fm.add( fmData );
      
         //Show Frame
      frame.setSize( 600 , 675 );
      frame.setVisible( true );
   }

}