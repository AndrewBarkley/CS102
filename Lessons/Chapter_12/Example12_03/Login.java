/* Using JTextFields, JTextArea, and JPasswordField
   Anderson, Franceschi
*/

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame
{
 private Container contents;
 private JLabel idLabel, passwordLabel, message;
 private JTextField id;
 private JPasswordField password;
 private JTextArea legal;

 // Constructor
 public Login( )
 {
  super( "Login Screen" );
  contents = getContentPane( );
  contents.setLayout( new FlowLayout( ) );

  idLabel = new JLabel( "Enter id" ); // label for ID
  id = new JTextField( "", 12 );      // instantiate ID text field

  passwordLabel = new JLabel( "Enter password" ); // password label
  password = new JPasswordField( 8 ); // instantiate password field
  password.setEchoChar( '?' );        // set echo character to '?'

  message = new JLabel( "Log in above" );  // label to hold messages

  // instantiate JTextArea with legal warning
  legal = new JTextArea( "Warning: Any attempt to illegally\n"
           + "log in to this server is punishable by law.\n"
           + "This corporation will not tolerate hacking,\n"
           + "virus attacks, or other malicious acts." );
  legal.setEditable( false );        // disable typing in this field

  // add all components to the window
  contents.add( idLabel );
  contents.add( id );
  contents.add( passwordLabel );
  contents.add( password );
  contents.add( message );
  contents.add( legal );

  // instantiate event handler for the text fields
  TextFieldHandler tfh = new TextFieldHandler( );

  // add event handler as listener for ID and password fields
  id.addActionListener( tfh );
  password.addActionListener( tfh );

  setSize( 250,200 );
  setVisible( true );
 }

 // private inner class event handler
 private class TextFieldHandler implements ActionListener
 {
  public void actionPerformed( ActionEvent e )
  {
   if ( id.getText( ).equals( "open" )
    && ( new String( password.getPassword( ) ) ).equals( "sesame" ) )
   {
    message.setForeground( Color.BLACK );
    message.setText( "Welcome!" );
   }
   else
   {
    message.setForeground( Color.RED );
    message.setText( "Sorry: wrong login" );
   }
  }
 }

 public static void main( String [] args )
 {
  Login login = new Login( );
  login.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 }
}
