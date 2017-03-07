//Merge Sort

import java.io.*;

public class mergeSort
{
   public void mergeSort(int[] data, int start, int end)
   {
      if(start >= end)
         return;
      
      int mid = (start + end) / 2;
   
      mergeSort(data, start, mid);
      mergeSort(data, mid+1, end);
   
      int[] sorted = new int[end-start+1];
      int left = start;
      int right = mid+1;
      int copy = 0;
   
      while(left <= mid && right <= end)
      {
         if(data[left] < data[right])
            sorted[copy++] = data[left++];
         else
            sorted[copy++] = data[right++];
      }
      while(left <= mid)
         sorted[copy++] = data[left++];
      while(right <= end)
         sorted[copy++] = data[right++];
      for(copy = 0;copy < sorted.length;copy++)
         data[start+copy] = sorted[copy];
   }
}