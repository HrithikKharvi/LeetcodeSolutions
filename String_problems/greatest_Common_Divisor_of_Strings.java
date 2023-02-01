class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String currentString = str2;
        int count = str2.length();

        while(count >= 0){
          currentString  = currentString.substring(0, count);
          if(currentString.length() != 0 && currentString.length() <= str2.length() && str1.length() % currentString.length() == 0){
            boolean isValid = find(str1, str2, currentString);
            if(isValid)break;
          }
          System.out.println(currentString);
          count--;
        }

        return currentString;
    }

    public boolean find(String str1, String str2, String divisor){
      // int start = 0;
      for(int i=0; i< str1.length(); i = i + divisor.length()){
        String current = str1.substring(i, i + divisor.length());
        System.out.println(current + "L " + divisor);
        if(!divisor.equals(current))return false;
      }

      for(int i=0; i< str2.length(); i = i + divisor.length()){
        String current = "";
        if(i+divisor.length() < str2.length()){
          current = str2.substring(i, i + divisor.length());
        }else{
          current = str2.substring(i);
        }
        System.out.println(current + "L " + str2);
        if(!divisor.equals(current))return false;
      }

      return true;
    }

}
