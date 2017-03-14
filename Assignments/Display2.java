/** Nesting components using layout managers
*   Anderson, Franceschi
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display extends JFrame
{
   final int SEARCH_CALLSIGN = 0;
   final int SEARCH_FREQUENCY = 1;
   final int SEARCH_HOME = 2;
   final int SEARCH_FORMAT = 3;
   final int ADD_NODE = 4;
   final int REMOVE = 5;
   final int EXPORT = 6;
   final int IMPORT = 7;
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


   public Display( )
   {
      super( "Radio Database" );
   
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
      Database database = new Database();//to run everything
      String input = "";
      public void actionPerformed( ActionEvent ae )
      {
         if ( ae.getSource( ) == optionButtons[SEARCH_CALLSIGN] )
         {
            input = JOptionPane.showInputDialog("Searching Callsign","Enter desired Callsign here");
         }
         else if ( ae.getSource( ) == optionButtons[SEARCH_FREQUENCY] )
         {
            input = JOptionPane.showInputDialog("Searching Frequency","Enter desired Frequency here");
         }
         else if ( ae.getSource( ) == optionButtons[SEARCH_HOME] )
         {
            input = JOptionPane.showInputDialog("Searching Home","Enter desired Home here");
         }
         else if ( ae.getSource( ) == optionButtons[SEARCH_FORMAT] )
         {
            input = JOptionPane.showInputDialog("Searching Format","Enter desired Format here");
         }
         else if ( ae.getSource( ) == optionButtons[ADD_NODE] )
         {
            JFrame frame = new JFrame("New Station Data");
            Container panel = new Container();
            panel.setLayout( new GridLayout(11,1) );
            frame.add(panel);
            
            JLabel callsign = new JLabel("Enter Callsign:");
            JTextField callsignIn = new JTextField();
            JLabel band = new JLabel("Enter Band:");
            JTextField bandIn = new JTextField();
            JLabel frequency = new JLabel("Enter Frequency:");
            JTextField frequencyIn = new JTextField();
            JLabel home = new JLabel("Enter Home:");
            JTextField homeIn = new JTextField();
            JLabel format = new JLabel("Enter Format:");
            JTextField formatIn = new JTextField();
            JButton add = new JButton("ADD");
            
            panel.add(callsign);
            panel.add(callsignIn);
            panel.add(band);
            panel.add(bandIn);
            panel.add(frequency);
            panel.add(frequencyIn);
            panel.add(home);
            panel.add(homeIn);
            panel.add(format);
            panel.add(formatIn);
            panel.add(add);
            
            frame.setSize(300, 400);
            frame.setVisible(true);
         }
         else if ( ae.getSource( ) == optionButtons[REMOVE] )
         {
            input = JOptionPane.showInputDialog("Removing","Enter desired Callsign here");
            if(input != null)
            {
               input = "Are You Sure? Remove:\n" + input;
               JOptionPane.showConfirmDialog(null,input, "Removing", JOptionPane.YES_NO_OPTION, 
                                             JOptionPane.WARNING_MESSAGE);//may need bool to give answer to
               //remove()
            }
         }
         else if ( ae.getSource( ) == optionButtons[EXPORT] )
         {
            //export
            //may add filename option
         }
         else if ( ae.getSource( ) == optionButtons[IMPORT] )
         {
            input = JOptionPane.showInputDialog("Enter Filename","Enter Filename here");
         }
         else 
         {
            JOptionPane.showMessageDialog(null, "data", "AM Stations", JOptionPane.INFORMATION_MESSAGE);//maybe one box 2 columns
            JOptionPane.showMessageDialog(null, "data", "FM Stations", JOptionPane.INFORMATION_MESSAGE);
         }
      }
   }


   public static void main( String [] args )
   {
      Display myNestedLayout = new Display( );
      myNestedLayout.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }
}