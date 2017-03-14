/* Simple Math Operations Using JButtons
   Anderson, Franceschi
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleMath extends JFrame
{
 private Container contents;
 private JLabel operandLabel, resultLabel, result;
 private JTextField operand;
 private JButton square, cube;

 public SimpleMath( )
 {
  super( "Simple Math" );
  contents = getContentPane( );
  contents.setLayout( new FlowLayout( ) );

  operandLabel = new JLabel( "Enter a number" ); // text field label
  operand = new JTextField( 5 ); // text field is 5 characters wide

  // instantiate buttons
  square = new JButton( "Square" );
  cube = new JButton( "Cube" );

  resultLabel = new JLabel( "Result:" ); // label for result
  result = new JLabel( "???" );          // label to hold result

  // add components to the window
  contents.add( operandLabel );
  contents.add( operand );
  contents.add( square );
  contents.add( cube );
  contents.add( resultLabel );
  contents.add( result );

  // instantiate our event handler
  ButtonHandler bh = new ButtonHandler( );

  // add event handler as listener for both buttons
  square.addActionListener( bh );
  cube.addActionListener( bh );

  setSize( 175,150 );
  setVisible( true );
 }

 // private inner class event handler
 private class ButtonHandler implements ActionListener
 {
  // implement actionPerformed method
  public void actionPerformed( ActionEvent ae )
  {
   try
   {
    double op = Double.parseDouble( operand.getText( ) );

    // identify which button was pressed
    if ( ae.getSource( ) == square )
      result.setText( ( new Double( op * op ) ).toString( ) );
    else if ( ae.getSource( ) == cube )
      result.setText( ( new Double( op * op * op ) ).toString( ) );
   }
   catch( NumberFormatException e )
   {
    operandLabel.setText( "Enter a number" );
    operand.setText( "" );
    result.setText( "???" );
   }
  }
 }

 public static void main( String [] args )
 {
  SimpleMath sm = new SimpleMath( );
  sm.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}
