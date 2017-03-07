//Merge Sort

import java.io.*;

public class quickSort
{
   public void quickSort(int[] data, int start, int end)
   {
      if(start >= end)
         return;
      int pivot = data[start];
      int front = start;
      int back = end;
      while(true)
      {
         while(front <= end && data[front] <= pivot)
            front++;
         while(back >= start && data[back] > pivot)
            back--;
         if(front > back)
            break;
         int temp = data[front];
         data[front] = data[back];
         data[back] = temp;
      }
      int temp = data[start];
      data[start] = data[back];
      data[back] = temp;
      quickSort(data, start, back-1);
      quickSort(data, back+1, end);
   }
}