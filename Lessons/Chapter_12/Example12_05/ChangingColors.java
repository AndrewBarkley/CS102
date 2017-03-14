/* Select a Color using JRadioButtons
   Anderson, Franceschi
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangingColors extends JFrame
{
 private Container contents;
 private JRadioButton sCallsign, sFrequency, sHome, sFormat;
 private ButtonGroup colorGroup;
 private JLabel label;
 private Color selectedColor = Color.RED;

 public ChangingColors( )
 {
  super( "Selecting a color" );
  contents = getContentPane( );
  contents.setLayout( new FlowLayout( ) );

  sCallsign = new JRadioButton( "Search Callsign", true );
  sFrequency = new JRadioButton( "Search Frequency" );
  sHome = new JRadioButton( "Search Home" );
  sFormat = new JRadioButton( "Search Format" );

  label = new JLabel( "Watch my background" );
  label.setForeground( Color.GRAY );
  label.setOpaque( true );
  label.setBackground( selectedColor );

  contents.add( sCallsign );
  contents.add( sFrequency );
  contents.add( sHome );
  contents.add( sFormat );
  contents.add( label );

  // create button group
  colorGroup = new ButtonGroup( );
  colorGroup.add( sCallsign );
  colorGroup.add( sFrequency );
  colorGroup.add( sHome );
  colorGroup.add( sFormat );

  // create RadioButtonHandler event handler
  // and register it on the radio buttons
  RadioButtonHandler rbh = new RadioButtonHandler( );
  sCallsign.addItemListener( rbh );
  sFrequency.addItemListener( rbh );
  sHome.addItemListener( rbh );
  sFormat.addItemListener( rbh );

  setSize( 600, 400 );
  setVisible( true );
 }

 private class RadioButtonHandler implements ItemListener
 {
  public void itemStateChanged( ItemEvent ie )
  {
   if ( ie.getSource( ) == sCallsign )
      selectedColor = Color.RED;
   else if ( ie.getSource( ) == sFrequency )
      selectedColor = Color.GREEN;
   else if ( ie.getSource( ) == sHome )
      selectedColor = Color.WHITE;
   else if ( ie.getSource( ) == sFormat )
      selectedColor = Color.BLUE;

   label.setBackground( selectedColor );
  }
 }

 public static void main( String [] args )
 {
  ChangingColors cc = new ChangingColors( );
  cc.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}
