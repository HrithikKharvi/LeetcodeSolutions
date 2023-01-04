class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        for(int i=0; i< grid.length; i++){
            list.add(new ArrayList<Integer>());
            for(int j=0; j<grid[0].length; j++){
                list.get(i).add(grid[i][j]);
            }
        }

        int m = list.get(0).size();
        int n = list.size();
        for(int i=0; i< list.size(); i++){
            for(int j=0; j<list.get(0).size(); j++){
                int ele = grid[i][j];
                int c = (i*m) + j;
                int nextJ = (c + k) % m;
                int nextI = (c + k) / m;
                System.out.println(nextI + ":" + nextJ);

                if(nextI >= n){
                    nextI = nextI % n;
                }

                list.get(nextI).set(nextJ, ele);
            }
        }

        return list;
    }
}
