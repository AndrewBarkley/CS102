//***********************************************
//Zachary Mosley                                *
//CS102, Winter 2017                            *
//Programming Assignment 1                      *
//Database: Stores all Stations in an array     *
//***********************************************

public class Database
{
   public static int DATABASE_ARRAY_SIZE = 50;
   private Station[] archive = new Station[50];
   
   public void initialize(String echo)
   {
      Scanner in = new Scanner(echo);
      count = 0;
      while(in.hasNextLine())
      {
         archive[count] = Station(in);
      }
   }
   
   ///Each search method will notify the user if the query returns empty
   public String searchCall(String in)
   {
      String temp = "";
      for(int count = 0; count < archive.length();count++)
      {
         if(archive[count].callsign == in)
         {
            temp += archive[count] + "\n";
         }
      }
      if(temp == "")
      {
         temp = "Sorry, query empty";
      }
      return temp;
   }
   public String searchFreq(String in)
   {
      String temp = "";
      for(int count = 0; count < archive.length();count++)
      {
         if(archive[count].frequency == in)
         {
            temp += archive[count] + "\n";
         }
      }
      if(temp == "")
      {
         temp = "Sorry, query empty";
      }
      return temp;
   }
   public String searchHome(String in)
   {
      String temp = "";
      for(int count = 0; count < archive.length();count++)
      {
         if(archive[count].home == in)
         {
            temp += archive[count] + "\n";
         }
      }
      if(temp == "")
      {
         temp = "Sorry, query empty";
      }
      return temp;
   }
   public String searchFormat(String in)
   {
      String temp = "";
      for(int count = 0; count < archive.length();count++)
      {
         if(archive[count].format.Contains(in))
         {
            temp += archive[count] + "\n";
         }
      }
      if(temp == "")
      {
         temp = "Sorry, query empty";
      }
      return temp;
   }
   
}