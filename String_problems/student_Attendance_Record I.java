class Solution {
    public boolean checkRecord(String s) {

      int aCount = 0;
      int lCount = 0;

        for(int i=0; i<s.length(); i++){
          char ch = s.charAt(i);

          if(ch == 76){
            lCount++;
            if(lCount >= 3)return false;
          }else if(ch == 65){
            lCount = 0;
            aCount++;
            if(aCount >= 2)return false;
          }else{
            lCount = 0;
          }
        }

        return true;
    }
}
