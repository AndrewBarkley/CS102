//***********************************************
//Zachary Mosley                                *
//Login ID: mosl8748                            *
//CS102, Winter 2017                            *
//Programming Assignment 5                      *
//Prog4: GUI                                    *
//***********************************************

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display extends JFrame
{
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
   public Database database;
   private Container contents;
   private JPanel optionPanel;
   private JButton [] optionButtons;
   private String [] optionNames = {
            "Search Callsign",
            "Search Frequency",
            "Search Home",
            "Search Format",
            "Add",
            "Remove",
            "Export",
            "Import",
            "Print" };


   public Display(Database database)
   {
      super( "Radio Database" );
      this.database = database;
   
      contents = getContentPane( );
      contents.setLayout( new GridLayout() );
   
      optionPanel = new JPanel( );
      optionPanel.setLayout( new GridLayout( 5, 2 ) );
   
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

   private class OptionButtonHandler
                        implements ActionListener
   {
      String input = "";
      public void actionPerformed( ActionEvent ae )
      {
         if ( ae.getSource( ) == optionButtons[SEARCH_CALLSIGN] )//done
         {
            input = JOptionPane.showInputDialog("Enter Callsign");
            if(input != null && !input.equals(""))
            {
               print(database.search( input,SEARCH_S_CALLSIGN,"am"),
                     database.search( input,SEARCH_S_CALLSIGN,"fm"));
            }
         }
         else if ( ae.getSource( ) == optionButtons[SEARCH_FREQUENCY] )//done
         {
            input = JOptionPane.showInputDialog("Enter Frequency");
            if(input != null && !input.equals(""))
            {
               print(database.search( input,SEARCH_S_FREQUENCY,"am"),
                     database.search( input,SEARCH_S_FREQUENCY,"fm"));
            }
         }
         else if ( ae.getSource( ) == optionButtons[SEARCH_HOME] )//done
         {
            input = JOptionPane.showInputDialog("Enter Home");
            if(input != null && !input.equals(""))
            {
               print(database.search( input,SEARCH_S_HOME,"am"),
                     database.search( input,SEARCH_S_HOME,"fm"));
            }
         }
         else if ( ae.getSource( ) == optionButtons[SEARCH_FORMAT] )//done
         {
            input = JOptionPane.showInputDialog("Enter Format");
            if(input != null && !input.equals(""))
            {
               print(database.search( input,SEARCH_S_FORMAT,"am"),
                     database.search( input,SEARCH_S_FORMAT,"fm"));
            }
         }
         else if ( ae.getSource( ) == optionButtons[ADD_NODE] )//done
         {
            String test = "";
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
         else if ( ae.getSource( ) == optionButtons[REMOVE] )//done
         {
            String test = "";//tests to ensure actual input
            String band = JOptionPane.showInputDialog("Enter Station Band");
            input += band;
            if(input != null && !input.equals(""))
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
                     if(test.equals("Are You Sure? Remove:\n"))
                        throw new IndexOutOfBoundsException();
                                 
                     int removeBool;
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
         else if ( ae.getSource( ) == optionButtons[EXPORT] )//done
         {
            input = JOptionPane.showInputDialog("Enter Your Filename (without .txt)");
            if(input != null && !input.equals(""))
            {
               int exportBool;
               exportBool = JOptionPane.showConfirmDialog(null,"Save as:\n"+input+".txt", 
                                             "Exporting", JOptionPane.YES_NO_OPTION, 
                                             JOptionPane.WARNING_MESSAGE);
               if(exportBool == 0)
                  database.export(input);  
            }                                         
         }
         else if ( ae.getSource( ) == optionButtons[IMPORT] )//done
         {
            input = JOptionPane.showInputDialog("Enter Full Filename");
            if(input != null && !input.equals(""))
            {
               int importBool;
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
         else //done
         {
            print( database.print("am"),database.print("fm") );  
         }
      }
   }
  
   public void print( String amString, String fmString )
   {
         //Create Window with Dual Column Layout
      JFrame frame = new JFrame( "Station Data" );
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