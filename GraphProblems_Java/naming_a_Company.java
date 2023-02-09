class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] sets = new HashSet[26];
        for(int i=0; i< 26; i++)sets[i] = new HashSet<>();

        for(int i=0; i< ideas.length; i++){
          sets[ideas[i].charAt(0) - 'a'].add(ideas[i].substring(1));
        }

        System.out.println(Arrays.toString(sets));

      long count = 0;
      for(int i=0; i<25; i++){
        for(int j=i+1; j< 26; j++){
          int useless = 0;
            for(String str : sets[i]){
              if(sets[j].contains(str))useless++;
            }

            count += 2*((sets[i].size() - useless) * (sets[j].size() - useless));
        }
      }

      return count;
    }
}
