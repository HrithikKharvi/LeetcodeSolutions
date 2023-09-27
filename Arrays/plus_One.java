class Solution {
    public int[] plusOne(int[] digits) {
      int rem = 1;
        for(int i=digits.length-1; i>=0; i--){
          int sum = rem + digits[i];
          rem = sum / 10;
          digits[i] = sum % 10;
        }

        int[] result;

        if(rem == 1){
          result = new int[digits.length+1];
          result[0] = 1;
          for(int i=0; i<digits.length; i++)result[i+1] = digits[i];
        }else{
          result = new int[digits.length];
          for(int i=0; i<digits.length; i++)result[i] = digits[i];
        }

        return result;
    }
}
