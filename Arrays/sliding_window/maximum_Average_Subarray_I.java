class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        boolean isChanged = false;

        int i = 0;
        int j = 0;
        int count = 0;
        double sum = 0;

        while(i < nums.length){
          count++;
          sum += nums[i];

          if(count == k){
            double avg = sum / k;
            if(!isChanged){
              isChanged = true;
              max = avg;
            }else
            max = (double)(sum / k) > max ? ((double) sum / k) : max;

            sum -= nums[j];
            j++;
            count--;
          }{
            i++;
          }
        }

        return max;
    }
}
