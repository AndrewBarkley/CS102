/* Using a JComboBox to display dynamic data
   Anderson, Franceschi
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VacationSpecials extends JFrame
{
 private VacationList vacations;

 private Container contents;
 private JComboBox places;
 private JTextArea summary;

 public VacationSpecials( String fileName )
 {
  super( "Spring Break Vacations Specials" );
  vacations = new VacationList( fileName );

  contents = getContentPane( );
  contents.setLayout( new FlowLayout( ) );

  // instantiate components
  places = new JComboBox( vacations.getLocationList( ) );
  places.setMaximumRowCount( 4 );
  summary = new JTextArea( vacations.getDescription( 0 ) );

  // add components to content pane
  contents.add( places );
  contents.add( summary );

  // set up event handler
  ItemListenerHandler ilh = new ItemListenerHandler( );
  places.addItemListener( ilh );

  setSize( 350, 150 );
  setVisible( true );
 }

 private class ItemListenerHandler implements ItemListener
 {
  public void itemStateChanged( ItemEvent ie )
  {
   int index = places.getSelectedIndex( );
   summary.setText( vacations.getDescription( index ) );
  }
 }

 public static void main( String [] args )
 {
  VacationSpecials vs = new VacationSpecials( "specials.txt" );
  vs.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}
