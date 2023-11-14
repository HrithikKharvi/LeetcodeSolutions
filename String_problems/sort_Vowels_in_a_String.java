class Solution {
    public String sortVowels(String s) {
        int[] vowelsCount = new int[11];
        int[] vowelsIndexArray = new int[128];
        char[] vowelsArray = "AEIOUaeiou".toCharArray();
        char[] result = s.toCharArray();

        for(int i=1; i<vowelsCount.length; i++){
          vowelsIndexArray[vowelsArray[i-1]] = i;
        }

        for(char ch : result){
          vowelsCount[vowelsIndexArray[ch]]++;
        }

        int i=0;
        int j = 1;

        while( j < vowelsCount.length ){
          if(vowelsCount[j] > 0){

            while(i < s.length()){
              if(vowelsIndexArray[result[i]] == 0){
                i++;
                continue;
              }
              vowelsCount[j]--;
              result[i++] = vowelsArray[j-1];
              break;
            }

          }else{
            j++;
          }
        }

        return new String(result);

    }
}
