class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        List<Integer> queue = new ArrayList<>();
        int[] visited = new int[n];

        for(int i=0; i< n; i++){
          int left = leftChild[i];
          int right = rightChild[i];

          if(left != -1)visited[left]++;
          if(right != -1)visited[right]++;
        }

        boolean isFound = false;

        for(int i=0; i<n; i++){
          if(visited[i] == 0 && !isFound){
            queue.add(i);
            isFound = true;
          }else if(visited[i] == 0 && isFound)return false;
        }

      visited = new int[n];
            while(queue.size() > 0){
            int removedElement = queue.remove(0);
            
            int left = leftChild[removedElement];
            int right = rightChild[removedElement];

            if(left != -1){
              visited[left]++;
              if(visited[left] < 2)queue.add(left);
            }

            if(right != -1){
              visited[right]++;
              if(visited[right] < 2)queue.add(right);
            }
          }

          
        int zeroCount = 0;
        System.out.println(Arrays.toString(visited));

        for(int i=0; i<n; i++){
          if(visited[i] == 0)zeroCount++;
          if(zeroCount > 1)return false;

          if(visited[i] > 1)return false;
        }

        return true;


    }
}
