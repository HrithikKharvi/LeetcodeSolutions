class Solution {
    public int longestPalindrome(String s) {
      if(s.length() > 2000)return 0;
        int[] arr = new int[128];
        for(int i=0; i< s.length(); i++){
          System.out.println(Character.valueOf(s.charAt(i)) + 0);
          arr[Character.valueOf(s.charAt(i)) + 0]++;
        }

        System.out.println(Arrays.toString(arr));

        int count = 0;
        boolean isOddFound = false;

      for(int i=0; i<128; i++){
        int length = arr[i];
        if(length % 2 == 1){
          isOddFound = true;
        }

        count += (length / 2) * 2;
      }


      return count + (isOddFound ? 1 : 0);

    }
}
