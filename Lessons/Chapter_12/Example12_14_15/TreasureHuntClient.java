/* A Treasure Hunt using MouseMotionListener
   Anderson, Franceschi
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TreasureHuntClient extends JFrame
implements MouseMotionListener
{
 private int x; // current x mouse position
 private int y; // current y mouse position
 private TreasureHunt hunt;

 public TreasureHuntClient( )
 {
  super( "Move the mouse to find the treasure" );

  hunt = new TreasureHunt( );
  // application registers on itself
  // since it is a MouseMotionListener itself
  addMouseMotionListener( this );

  setSize( hunt.GAME_SIZE, hunt.GAME_SIZE );
  setVisible( true );
 }

 public void mouseDragged( MouseEvent me )
 { } // we do not want to process mouse drag events

 public void mouseMoved( MouseEvent me )
 {
  // get location of mouse
  x = me.getX( );
  y = me.getY( );
  hunt.play( x, y );
  repaint( );
 }

 public void paint( Graphics g )
 {
  super.paint( g );
  hunt.draw( g, x, y );
  if ( hunt.isGameOver( ) )
   removeMouseMotionListener( this );
 }

 public static void main( String [] args )
 {
  TreasureHuntClient th_gui = new TreasureHuntClient( );
  th_gui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}
