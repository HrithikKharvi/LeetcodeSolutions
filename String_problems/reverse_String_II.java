class Solution {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();

        for(int i=0; i<s.length(); i = i + (2 * k)){
            if(i + k > s.length()){
              reverse(charArray, i, s.length()-1);
            }else{
              reverse(charArray, i, i + k-1);
            }
        }


        return new String(charArray);

    }

    

    //4 + (2*k)

    public void reverse(char[] array, int start, int end){
      while(start <= end){
        char temp = array[start];
        array[start] = array[end];
        array[end] = temp;

        start++;
        end--;
      }
    }

}
