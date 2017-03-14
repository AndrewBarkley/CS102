/* Using JList to show a sampling of international foods
   Anderson, Franceschi
*/

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class FoodSamplings extends JFrame
{
 private Container contents;
 private JList countries;
 private JLabel foodImage;

 private String [] countryList =
            { "France", "Greece", "Italy", "Japan", "USA" };
 private ImageIcon [] foods =
            {  new ImageIcon( "cheese.jpg" ),
               new ImageIcon( "fetaSalad.jpg" ),
               new ImageIcon( "pizza.jpg" ),
               new ImageIcon( "sushi.jpg" ),
               new ImageIcon( "hamburger.jpg" ) };

 public FoodSamplings( )
 {
  super( "Food samplings of various countries" );
  contents = getContentPane( );
  contents.setLayout( new FlowLayout( ) );

  // instantiate the components
  countries = new JList( countryList );
  foodImage = new JLabel( foods[0] );

  // allow single selections only
  countries.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
  countries.setSelectedIndex( 0 );

  // add components to the content pane
  contents.add( countries );
  contents.add( foodImage );

  // set up event handler
  ListHandler lslh = new ListHandler( );
  countries.addListSelectionListener( lslh );

  setSize( 350, 150 );
  setVisible( true );
 }

 private class ListHandler implements ListSelectionListener
 {
  public void valueChanged( ListSelectionEvent lse )
  {
   foodImage.setIcon( foods[countries.getSelectedIndex( )] );
  }
 }

 public static void main( String [] args )
 {
  FoodSamplings fs = new FoodSamplings( );
  fs.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}
