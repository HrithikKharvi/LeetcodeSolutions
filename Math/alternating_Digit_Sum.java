class Solution {
    public int alternateDigitSum(int n) {
        boolean isPositive = true;
        if(n >= 10){
          isPositive = getCount(n) % 2 == 0 ? false : true; 
        }
        int sum = 0;
        while(n > 0){
          int currNumber = n % 10;
          if(isPositive){
            sum += currNumber;
            isPositive = false;
          }else{
            sum -= currNumber;
            isPositive = true;
          }
          n = n / 10;
        }
        return sum;
    }

    public int getCount(int n){
      int  count = 0;

      while(n > 0){
        count++;
        n = n / 10;
      }

      return count;
    }
}
