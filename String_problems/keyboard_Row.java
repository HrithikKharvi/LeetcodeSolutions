class Solution {
    public String[] findWords(String[] words) {
        ArrayList<String> finalArray = new ArrayList<>();

        for(int i=0; i<words.length; i++){
          String currentString = words[i];
          if(currentString.matches("^[qwertyuiopQWERTYUIOP]*$") || currentString.matches("^[asdfghjklASDFGHJKL]*$") || currentString.matches("^[zxcvbnmZXCVBNM]*$")){
            finalArray.add(currentString);
          }
        }

        String[] a = new String[finalArray.size()];
        for(int i=0; i< a.length; i++){
          a[i] = finalArray.get(i);
        }

        return a;
    }
}
