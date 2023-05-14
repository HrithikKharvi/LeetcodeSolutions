class Solution {
    public List<String> letterCombinations(String digits) {
      if(digits.length() == 0)return new ArrayList<>();
        List<List<String>> charlist = new ArrayList<>();
        for(int i=0; i<digits.length(); i++){
          int digit = Integer.parseInt(digits.charAt(i) + "");
          digit = digit - 2;
          List<String> list = formList(digit);
          charlist.add(list);
        }
        List<String> result = getCombination(0, charlist);

        return result;
    }

    public List<String> getCombination(int index, List<List<String>> list){
      if(index == list.size()){
        List<String> result = new ArrayList<>();
        result.add("");
        return result;
      }

      List<String> res = getCombination(index+1, list);
      List<String> resultArray = new ArrayList<>();

      List<String> currentList = list.get(index);
      for(String characters: res){
        for(String currentChar : currentList){
          resultArray.add(currentChar + characters);
        }
      }

      return resultArray;

    }


    public List<String> formList(int digit){
      int diff = digit == 5 || digit == 7 ? 4 : 3;
      int startChar = 97 + (digit * 3);
      startChar += digit > 5 ? 1 :0;

      int endChar = startChar + diff;
      System.out.println(digit + "->" + diff);
      List<String> charArray = new ArrayList<>();

      for(int i=startChar; i<endChar; i++){
        char character = (char) i;
        charArray.add(character + "");
      }

      return charArray;
    }

}
