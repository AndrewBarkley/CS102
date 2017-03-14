/** Using BorderLayout to display Bridge bidding
*   Anderson, Franceschi
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BridgeBiddingClient extends JFrame
{
 private Container contents;
 private JButton north, east, south, west;
 private JLabel bid;

 private BridgeBidding bidding;

 public BridgeBiddingClient( )
 {
  super( "Learn Bridge Bidding with BorderLayout" );
  bidding = new BridgeBidding( 0 );

  contents = getContentPane( );
  contents.setLayout( new BorderLayout( ) ); // optional

  // instantiate button objects
  north = new JButton( bidding.getPlayer( 0 ) );
  east = new JButton( bidding.getPlayer( 1 ) );
  south = new JButton( bidding.getPlayer( 2 ) );
  west = new JButton( bidding.getPlayer( 3 ) );

  // instantiate JLabel
  bid = new JLabel( "No bid", SwingConstants.CENTER );

  // order of adding components not important
  contents.add( north, BorderLayout.NORTH );
  contents.add( east, BorderLayout.EAST );
  contents.add( south, BorderLayout.SOUTH );
  contents.add( west, BorderLayout.WEST );
  contents.add( bid, BorderLayout.CENTER );

  ButtonHandler bh = new ButtonHandler( );
  north.addActionListener( bh );
  east.addActionListener( bh );
  south.addActionListener( bh );
  west.addActionListener( bh );

  setSize( 350, 250 );
  setVisible( true );
 }

 private class ButtonHandler implements ActionListener
 {
  public void actionPerformed( ActionEvent ae )
  {
   int source = 0;
   if ( ae.getSource( ) == north )
    source = 0;
   else if ( ae.getSource( ) == east )
    source = 1;
   else if ( ae.getSource( ) == south )
    source = 2;
   else if ( ae.getSource( ) == west )
    source = 3;

   if ( source == bidding.getBidder( )
        && bidding.isBiddingAllowed( ) )
    bid.setText( bidding.nextBid( ) ); // set label to current bid
  }
 }

 public static void main( String [] args )
 {
  BridgeBiddingClient bbGui = new BridgeBiddingClient( );
  bbGui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}
