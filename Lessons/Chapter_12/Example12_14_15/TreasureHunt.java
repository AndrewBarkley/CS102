/* TreasureHunt class
   Anderson, Franceschi
*/

import java.awt.*;
import java.util.Random;

public class TreasureHunt
{
 public static int GAME_SIZE = 300; // side of window
 public static int SIDE = 40; // side of treasure

 private int xCtr; // x coordinate of center of treasure
 private int yCtr; // y coordinate of center of treasure
 private int x; // current x mouse position
 private int y; // current y mouse position
 private String status = ""; // message
 private boolean gameOver = false;

 /** Constructor
 */
 public TreasureHunt( )
 {
  Random random = new Random( );
  xCtr = SIDE / 2 + random.nextInt( GAME_SIZE - SIDE );
  yCtr = SIDE / 2 + random.nextInt( GAME_SIZE - SIDE );
 }

 /** isGameOver
 * @return gameOver
 */
 public boolean isGameOver( )
 {
  return gameOver;
 }

 /** play
 * @param x the x coordinate of the play
 * @param y the y coordinate of the play
 */
 public void play( int x, int y )
 {
  // is mouse within treasure?
  if ( Math.abs( x - xCtr ) < SIDE / 2
       && Math.abs( y - yCtr ) < SIDE / 2 )
  {
   gameOver = true;
   status = "Found";
  }
  // is mouse within half-length of the treasure?
  else if ( Math.abs( x - xCtr ) < ( 1.5 * SIDE )
            && Math.abs( y - yCtr ) < ( 1.5 * SIDE ) )
   status = "Hot";
  // is mouse within 1 length of the treasure?
  else if ( Math.abs( x - xCtr ) < ( 2 * SIDE )
            && Math.abs( y - yCtr ) < ( 2 * SIDE ) )
   status = "Warm";
  // is mouse within 2 lengths of the treasure?
  else if ( Math.abs( x - xCtr ) < ( 3 * SIDE )
            && Math.abs( y - yCtr ) < ( 3 * SIDE ) )
   status = "Lukewarm";
  else // mouse is not near treasure
   status = "Cold";
 }

 /** draw
 * @param g a Graphics object
 * @param x the x coordinate of the play
 * @param y the y coordinate of the play
 */
 public void draw( Graphics g, int x, int y )
 {
  g.setColor( Color.BLUE );

  if ( status.equals( "Found" ) ) // if found, draw treasure
  {
   g.setColor( Color.RED );
   g.fillRect( xCtr - SIDE / 2, yCtr - SIDE / 2, SIDE, SIDE );
   g.setColor( Color.GREEN );
   g.drawString( "$$$", xCtr - SIDE / 4, yCtr );
  }
  else
   g.drawString( status, x, y ); // display current status
 }
}
