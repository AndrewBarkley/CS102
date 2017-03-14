/* Using GridLayout to organize our window
   Anderson, Franceschi
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessBoard extends JFrame
{
 public static final int SIDE = 8;
 private Container contents;
 private JButton [][] squares;
 private String [][] names =
  { { "a1","a2","a3","a4","a5","a6", "a7", "a8" },
    { "b1","b2","b3","b4","b5","b6", "b7", "b8" },
    { "c1","c2","c3","c4","c5","c6", "c7", "c8" },
    { "d1","d2","d3","d4","d5","d6", "d7", "d8" },
    { "e1","e2","e3","e4","e5","e6", "e7", "e8" },
    { "f1","f2","f3","f4","f5","f6", "f7", "f8" },
    { "g1","g2","g3","g4","g5","g6", "g7", "g8" },
    { "h1","h2","h3","h4","h5","h6", "h7", "h8" } };

 public ChessBoard( )
 {
  super( "Click a square to reveal its position" );
  contents = getContentPane( );

  // set layout to an 8-by-8 Grid
  contents.setLayout( new GridLayout( SIDE, SIDE ) );

  squares = new JButton[SIDE][SIDE];

  ButtonHandler bh = new ButtonHandler( );

  for ( int i = 0; i < names.length; i++ )
  {
   for ( int j = 0; j < SIDE; j++ )
   {
    // instantiate JButton array
    squares[i][j] = new JButton( );

    // make every other square red
    if ( ( i + j ) % 2 == 0 )
      squares[i][j].setBackground( Color.RED );

    // add the JButton
    contents.add( squares[i][j] );

    // register listener on button
    squares[i][j].addActionListener( bh );
   }
  }

  setSize( 400, 400 );
  setVisible( true );
 }

 private class ButtonHandler implements ActionListener
 {
  public void actionPerformed( ActionEvent ae )
  {
    for ( int i = 0; i < SIDE; i++ )
    {
      for ( int j = 0; j < SIDE; j++ )
      {
        if ( ae.getSource( ) == squares[i][j] )
        {
          squares[i][j].setText( names[i][j] );
          return;
        }
      }
    }
  }
 }

 public static void main( String [] args )
 {
   ChessBoard myGame = new ChessBoard( );
   myGame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}
