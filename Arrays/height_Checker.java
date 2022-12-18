class Solution {
    public int heightChecker(int[] heights) {
       int count = 0;

      int[] expected = new int[heights.length];
      for(int i=0; i<heights.length; i++){
        expected[i] = heights[i];
      }
       mergeSort(expected, 0, expected.length); 

       for(int i=0; i< heights.length; i++){
         if(expected[i] != heights[i])count++;
       }

       return count;
    }

    public void mergeSort(int[] arr, int start, int end){
      if(end-start < 2)return;

      int mid = (start + end) / 2;
      mergeSort(arr, start, mid);
      mergeSort(arr, mid, end);
      sort(arr, start, mid, end);
    }

    public void sort(int[] arr, int start, int mid, int end){
      int i = start;
      int j = mid;
      int[] tempArray = new int[arr.length];
      int temp = 0;

    while(i < mid && j < end){
      tempArray[temp++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
    }

    System.arraycopy(arr, i, arr, start + temp,  mid-i);
    System.arraycopy(tempArray, 0, arr, start, temp);

    }

}
