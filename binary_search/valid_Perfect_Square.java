class Solution {
    public boolean isPerfectSquare(int num) {
      if(num == 1)return true;
      if(num >= Integer.MAX_VALUE)return false;
      return binarySearch(num);        
    }

    public boolean binarySearch(int num){
      int start = 1;
      int end = num;

      while(start <= end){
        long mid = (start+end) / 2;
        System.out.println(mid*mid);
        if(mid * mid == num)return true;
        if(mid*mid < num)start = (int)mid+1;
        else end = (int)mid-1;
      }

      return false;
    }

}
