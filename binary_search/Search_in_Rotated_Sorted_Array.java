class Solution {
    public int search(int[] nums, int target) {
      int pivot = findPivot(nums);

      int leftValue = search(nums, 0, pivot, target);
      if(leftValue != -1)return leftValue;

      return search(nums, pivot, nums.length, target);
      // int searchRight
      //   return customBinarySearch(nums, 0, nums.length, target);
    }

    public int search(int[] nums, int start, int end, int target){
      while(start < end){
        int mid = (start + end) / 2;

        if(nums[mid] == target)return mid;
        else if(target < nums[mid])end = mid;
        else start = mid + 1;
      }

      return -1;
    }

    public int findPivot(int[] nums){
      if(nums[0] <= nums[nums.length-1])return 0;

      int start = 0;
      int end = nums.length-1;
      while(start < end){
        if(nums[start] < nums[end])return end+1;
        // start++;
        end--;
      }

      return end+1;
    }


    public int customBinarySearch(int[] nums, int start, int end, int target){
      
      while(start < end){
        int mid = (start + end) / 2;
        System.out.println(mid);
        if(nums[mid] == target)return mid;
        else if(nums[start] < nums[end-1]){
          if(target < nums[mid]){
            end = mid;
          }else{
            start = mid + 1;
          }
        }
        else if(target >= nums[start]){
          end = mid;
        }else{
          start = mid + 1;
        }
      }

      return -1;
    }

}
