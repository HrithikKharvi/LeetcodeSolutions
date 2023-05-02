class Solution {
    public int arraySign(int[] nums) {
      int product = 0;
      int zeros = 0;
      for(int val : nums){
        if(val < 0)product++;
        if(val == 0)zeros++;
      }

      if(zeros > 0)return 0;

      System.out.println(product);
    return signFunc(product);
    }

public int signFunc(int x){
  if(x % 2 == 0)return 1;
  else return -1;
}

}
