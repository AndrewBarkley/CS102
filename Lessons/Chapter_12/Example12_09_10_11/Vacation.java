/* Vacation class
   Anderson, Franceschi
*/

import java.text.DecimalFormat;

public class Vacation
{
 public final DecimalFormat MONEY
                   = new DecimalFormat( "$#,##0.00" );

 private String location;
 private String organization;
 private String description;
 private double price;

 /** Constructor
 *  @param  startLocation     location
 *  @param  startOrganization     organization
 *  @param  startDescription  description
 *  @param  startPrice            price
 */
 public Vacation( String startLocation,
                  String startOrganization,
                  String startDescription,
                  double startPrice )
 {
  location = startLocation;
  organization = startOrganization;
  description = startDescription;
  price = startPrice;
 }

 /** getLocation
 *  @return location
 */
 public String getLocation( )
 {
  return location;
 }

 /** toString
 *  @return location, organization, description, and price
 */
 public String toString( )
 {
  return "Location: " + location + "\n"
         + "Organization: " + organization + "\n"
         + "Description: " + description + "\n"
         + "Price: " + MONEY.format( price );
 }
}
