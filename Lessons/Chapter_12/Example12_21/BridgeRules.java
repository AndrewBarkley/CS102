/** Nesting components using layout managers
*   Anderson, Franceschi
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BridgeRules extends JFrame
{
 private Container contents;

 // 1st row, column 1
 private JPanel optionPanel;
 private JButton [] optionButtons;
 private String [] optionNames = {
            "Search Callsign",
            "Search Frequency",
            "Search Home",
            "Search Format",
            "Remove",
            "Add",
            "Print",
            "Export",
            "Import" };

 // 1st row, column 2
 private JPanel gamePanel;
 private JLabel gameTable;
 private JLabel [] gameLabels;

 public BridgeRules( )
 {
  super( "At the Bridge Table" );

  contents = getContentPane( );
  contents.setLayout( new GridLayout( 1, 2 ) );

  // 1st row, col 1: option buttons
  optionPanel = new JPanel( );
  optionPanel.setLayout( new GridLayout( 9, 1 ) );

  OptionButtonHandler obh = new OptionButtonHandler( );
  optionButtons = new JButton[optionNames.length];

  for ( int i = 0; i < optionNames.length; i ++ )
  {
     optionButtons[i] = new JButton( optionNames[i] );
     optionButtons[i].addActionListener( obh );
     optionPanel.add( optionButtons[i] );
  }

  // 1st row, column 2: gamePanel contains the players and table
  gamePanel = new JPanel( );
  gamePanel.setLayout( new BorderLayout( 3, 3 ) );
  gameLabels = new JLabel[4];
  gameLabels[0] = new JLabel( "North", SwingConstants.CENTER );
  gameLabels[1] = new JLabel( "East", SwingConstants.CENTER );
  gameLabels[2] = new JLabel( "South", SwingConstants.CENTER );
  gameLabels[3] = new JLabel( "West", SwingConstants.CENTER );

  gameTable = new JLabel( );
  gameTable.setBackground( Color.GREEN );
  gameTable.setOpaque( true );

  gamePanel.add( gameLabels[0], BorderLayout.NORTH );
  gamePanel.add( gameLabels[1], BorderLayout.EAST );
  gamePanel.add( gameLabels[2], BorderLayout.SOUTH );
  gamePanel.add( gameLabels[3], BorderLayout.WEST );
  gamePanel.add( gameTable, BorderLayout.CENTER );

  // add panels to content pane
  contents.add( optionPanel );
  contents.add( gamePanel );

  setSize( 350, 300 );
  setVisible( true );
 }

 private class OptionButtonHandler
                        implements ActionListener
 {
  public void actionPerformed( ActionEvent ae )
  {
   for ( int i = 0; i < optionButtons.length; i++ )
   {
     if ( ae.getSource( ) == optionButtons[i] )
       gameLabels[i].setVisible( false );
     else
       gameLabels[i].setVisible( true );
   }
  }
 }

 private class ResetButtonHandler
                           implements ActionListener
 {
   public void actionPerformed( ActionEvent ae )
   {
      for ( int i = 0; i < gameLabels.length; i++ )
         gameLabels[i].setVisible( true );
   }
 }

 public static void main( String [] args )
 {
   BridgeRules myNestedLayout = new BridgeRules( );
   myNestedLayout.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}