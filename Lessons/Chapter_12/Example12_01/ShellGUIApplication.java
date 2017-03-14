/*  A Shell GUI Application
    Anderson, Franceschi
*/

import javax.swing.JFrame;
import java.awt.Container;
// other import statements here as needed

public class ShellGUIApplication extends JFrame
{
   private Container contents;
   // declare other instance variables

   // constructor
   public ShellGUIApplication( )
   {
     // call JFrame constructor with title bar text
     super( "A Shell GUI Application" );

     // get container for components
     contents = getContentPane( );

     // set the layout manager

     // instantiate GUI components and other instance variables

     // add GUI components to the content pane

     // set original size of window
     setSize( 300, 200 );

     // make window visible
     setVisible( true );
  }

  public static void main( String [] args )
  {
    ShellGUIApplication basicGui = new ShellGUIApplication( );
    basicGui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
}
