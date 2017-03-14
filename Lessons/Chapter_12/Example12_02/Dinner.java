/*  Using JLabels to display text and images
    Anderson, Franceschi
*/

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;

public class Dinner extends JFrame
{
  private Container contents;
  private JLabel labelText;
  private JLabel labelImage;

  // Constructor
  public Dinner( )
  {
    super( "What's for dinner?" );       // call JFrame constructor

    contents = getContentPane( );        // get content pane

    contents.setLayout( new FlowLayout( ) ); // set layout manager

    // use the JLabel constructor with a String argument
    labelText = new JLabel( "Sushi tonight?" );

    // set label properties
    labelText.setForeground( Color.WHITE );
    labelText.setBackground( Color.BLUE );
    labelText.setOpaque( true );

    // use the JLabel constructor with an ImageIcon argument
    labelImage = new JLabel( new ImageIcon( "sushi.jpg" ) );

    // set tooltip text
    labelImage.setToolTipText( "photo of sushi" );

    // add the two labels to the content pane
    contents.add( labelText );
    contents.add( labelImage );

    setSize( 300,200 );
    setVisible( true );
  }

  public static void main( String [] args )
  {
    Dinner dinner = new Dinner( );
    dinner.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
}
