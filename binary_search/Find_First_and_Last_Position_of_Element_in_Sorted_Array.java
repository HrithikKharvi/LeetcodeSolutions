//

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] resultArray = new int[]{-1,-1};
        return binarySearch(nums, target, 0, nums.length, resultArray);
    }

    public int[] binarySearch(int[] nums, int target, int i, int j, int[] result){
      int start = i;
      int end = j;


      while(start < end){
        int mid = (end + start) / 2;


        if(target > nums[mid]){
          start = mid + 1;
        }else if(target < nums[mid]){
          end = mid;
        }else{
          if(result[0] == -1 && result[1] == -1){
            result[0] = mid;
            result[1] = mid;
          }else if(result[0] == -1 || mid <= result[0]){
            result[0] = mid;
          }else if(mid >= result[1]){
            result[1] = mid;
          }
          binarySearch(nums, target, start, mid, result);
          binarySearch(nums, target, mid+1, end, result);
          return result;
        }
      }

      return result;
    }

}
