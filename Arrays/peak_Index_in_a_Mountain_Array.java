class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length < 3)return -1;
        int i = 1;
        int j = arr.length-2;

        while(i < j){
          if(arr[i] < arr[j])i++;
          else j--;
        }
        return i;
    }
}

//array length < 3 return -1;
//1,| 2, 3, 5, 3, 2,| 1
