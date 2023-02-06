class Solution {
    public void sortColors(int[] nums) {
        merge(nums, 0, nums.length);
    }

    public void merge(int[] nums, int start, int end){
      if(end-start < 2)return;

      int mid = (start+end) / 2;
      merge(nums, start, mid);
      merge(nums, mid, end);
      sort(nums, start, mid, end);
    }

    public void sort(int[] nums, int start, int mid, int end){
      if(nums[mid] > nums[mid-1])return;
      int i=start;
      int j=mid;

      int temp = 0;
      int[] tempArray = new int[nums.length];

      while(i < mid && j<end){
        tempArray[temp++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
      }

      System.arraycopy(nums, i, nums, start+temp, mid-i);
      System.arraycopy(tempArray, 0, nums, start, temp);

    }


}
