class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strArray = s.split(" ");
        Map<String, String> map = new HashMap<String, String>();
        if(pattern.length() != strArray.length)return false;
        for(int i=0; i<strArray.length; i++){
          String currentPattern = pattern.charAt(i) + "";
          String currentString = strArray[i];

          System.out.println(currentPattern + ":" + currentString);
          if(map.containsKey(currentPattern)){
            if(!map.get(currentPattern).equals(currentString))return false;
          }else{
            if(map.containsValue(currentString))return false;
            map.put(currentPattern, currentString);
          }
        }

        return true;

    }
}
