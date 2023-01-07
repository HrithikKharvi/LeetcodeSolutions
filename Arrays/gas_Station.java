class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0; i< gas.length; i++){
          boolean isValid = canTravel(gas, cost, i+1, i,gas[i] - cost[i]);
          if(isValid)return i;
        }

        return -1;
    }

    public boolean canTravel(int[] gas, int[] cost, int index, int target, int remainingGas){
      if(index == cost.length)index = 0;
      if(remainingGas < 0)return false;
      if(index == target)return true;


      int currentGas = remainingGas + gas[index];

      if(currentGas >= cost[index] && currentGas != 0){
        return canTravel(gas, cost, index+1, target, currentGas - cost[index]);
      }else{
        return false;
      }
    }

}Gas Station
