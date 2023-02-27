class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);//O(n log n)

        Set<String> set = new HashSet<>();

        for(int i=0; i< nums.length-1; i++){
          int findElement = nums[i] + k;
          if(binarySearch(nums, i+1, nums.length, findElement)){
            set.add(nums[i] + ":" + findElement);
            System.out.println(nums[i] + "L" + findElement);
          }
        }

        System.out.println(set);
        return set.size();

    }

    public boolean binarySearch(int[] nums, int start, int end, int element){
      System.out.println(start + "-> " + end + ":" + element);

      while(start < end){
        int mid = (start + end) / 2;
        
        if(nums[mid] == element)return true;
        else if(nums[mid] > element)end = mid;
        else if(nums[mid] < element)start = mid+1;
      }

      return false;
    }

}
