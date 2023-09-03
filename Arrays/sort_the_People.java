class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();

        for(int i=0; i<names.length; i++){
          String name = names[i];
          int height = heights[i];

          map.put(height, name);
        }


        Arrays.sort(heights);

        String[] result = new String[names.length];
        System.out.println(Arrays.toString(heights));

        int count = 0;
        for(int i=heights.length-1; i>=0; i--){
          result[count++] = map.get(heights[i]);
        }

        return result;
    }
}
