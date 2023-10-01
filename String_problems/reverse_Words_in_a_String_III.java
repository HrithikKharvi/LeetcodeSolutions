class Solution {
    public String reverseWords(String s) {
      String[] stringArray = s.split(" ");

      for(int i=0; i< stringArray.length; i++){
        stringArray[i] = reverse(stringArray[i]);
      }

      return String.join(" ", stringArray);

    }

    public String reverse(String s){
      char[] sb = new char[s.length()];

      int i = 0;
      int j = s.length()-1;

      while(i <= j){
        sb[i] = s.charAt(j);
        sb[j] = s.charAt(i);
        i++;
        j--;
      }

      return new String(sb);
    }

}
