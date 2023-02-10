class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = merge(nums1, nums2);
        System.out.println(Arrays.toString(result));
        if(result.length % 2 == 1)return (double)(result[result.length/2]);
        else{
          int right = result.length/2;
          int left = (result.length/2) -1;

          System.out.println((result[right] + result[left])/2);
          return (double)(result[right] + result[left])/2.0;
        }
    }

    public int[] merge(int[] num1, int[] num2){
      int i = 0;
      int j = 0;

      int m = num1.length;
      int n = num2.length;

      int temp = 0;
      int[] result = new int[m+n];

      while(i < m && j < n){
        result[temp++] = num1[i] < num2[j] ? num1[i++] : num2[j++];
      }

      System.arraycopy(num1, i, result, temp, m-i);
      System.arraycopy(num2, j, result, temp, n-j);

      return result;
    }
}
