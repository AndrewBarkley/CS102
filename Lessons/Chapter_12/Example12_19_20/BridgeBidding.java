/** BridgeBidding class
*   Anderson, Franceschi
*/

public class BridgeBidding
{
 private String [] suitNames =
   { "Club", "Diamond", "Heart", "Spade", "No trump" };
 private String [] players =
   { "North", "East", "South", "West" };
 // next bidder
 private int bidder;         // the next bidder
 private int dealer;         // the dealer

 // bidding will open at 1 Club
 private int level = 1;            // current level
 private int suit = 0;             // index of current suit

 /** Constructor
 * @param newDealer dealer
 */
 public BridgeBidding( int newDealer )
 {
  if ( newDealer >= 0 && newDealer < players.length )
   dealer = newDealer;
  else
   dealer = 0;
  players[dealer] += " - Dealer";
  bidder = dealer;
 }

 /** getPlayer
 * @param player the index of the player
 * @return a String, the name of the player
 */
 public String getPlayer( int player )
 {
  return players[player];
 }

 /** getBidder
 * @return bidder
 */
 public int getBidder( )
 {
  return bidder;
 }

 /** isBiddingAllowed
 * @return true if level is strictly less than 8, false otherwise
 */
 public boolean isBiddingAllowed( )
 {
  return ( level >= 1 && level <= 7 );
 }

 /** nextBid
 * Returns current bid and sets up next bid
 * @return a String, the current bid
 */
 public String nextBid( )
 {
  if ( isBiddingAllowed( ) )
  {
   String currentBid = level + " " + suitNames[suit];

   // add an "s" if level > 1 and suit is not No trump
   if ( level > 1 && suit != suitNames.length - 1 )
    currentBid += "s";

   // set up next bid
   bidder = ( bidder + 1 ) % players.length;
   suit = ( suit + 1 ) % suitNames.length;
   if ( suit == 0 )
    level++;

   return currentBid;
  }
  else
   return "Pass";
 }
}
