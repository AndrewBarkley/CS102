import java.util.*;
import java.io.*;

public interface DatabaseInterface
{
   public void initialize(Scanner input);
   public String searchCall(String in);
   public String searchFreq(String in);
   public String searchHome(String in);
   public String searchFormat(String in);
   public void print();
   public void interpret(boolean quit);
}