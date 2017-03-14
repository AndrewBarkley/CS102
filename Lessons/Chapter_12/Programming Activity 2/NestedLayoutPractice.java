/*  Practice using layouts
    Anderson, Franceschi
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NestedLayoutPractice extends JFrame
{
 private Container contents;
 private Game game;

 private BorderLayout bl;

 private JLabel bottom;

 // ***** Task 1: declare a JPanel named top
 // also declare three JButton instance variables
 // that will be added to the JPanel top
 // these buttons will determine the grid size of the game:
 //  3-by-3, 4-by-4, or 5-by-5



 // task 1 ends here

 public NestedLayoutPractice( )
 {
  super( "Practicing layout managers" );
  contents = getContentPane( );

  // ***** Task 2: student code starts here
  // instantiate the BorderLayout manager bl


  // set the layout manager of the content pane contents to bl


  game = new Game( 3 ); // instantiating the GamePanel object
  // add panel to the center of the content pane


  // task 2 ends here

  bottom = new JLabel( "Have fun playing this Tile Puzzle game",
                        SwingConstants.CENTER );

  // ***** Task 3: Student code restarts here
  // instantiate the JPanel component named top


  // set the layout of top to a 1-by-3 grid


  // instantiate the JButtons that determine the grid size




  // add the buttons to JPanel top





  // add JPanel top to the content pane as its north component


  // task 3 ends here

  // ***** Task 5: Student code restarts here
  // Note: search for and complete Task 4 before performing this task
  // declare and instantiate an ActionListener


  // register the listener on the 3 buttons
  // that you declared in Task 1




  // task 5 ends here

  contents.add( bottom, BorderLayout.SOUTH );

  setSize( 325, 325 );
  setVisible( true );
 }

 // ***** Task 4: Student code restarts here
 // create a private inner class that implements ActionListener
 // your method should identify which of the 3 buttons
 //    was the source of the event
 // depending on which button was pressed,
 //    call the setUpGame method of the Game class
 //    with arguments 3, 4, or 5
 // the API of that method is:
 //   public void setUpGame( int nSides )










 // task 4 ends here

 public static void main( String [] args )
 {
  NestedLayoutPractice nl = new NestedLayoutPractice( );
  nl.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}
