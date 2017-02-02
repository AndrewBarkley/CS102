import java.util.*;
import java.io.*;

public interface ListInterface
{
   public boolean isEmpty();
   public int size();
   public Station get(int index);
   public void add(int index, Station input);
   public Station remove(int index);
   public void removeAll();
   public void sort();
}