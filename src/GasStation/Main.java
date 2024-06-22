package GasStation;

public class Main {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        long gasSum = getSumOfElements(gas);
        long costSum = getSumOfElements(cost);
        if(gasSum<costSum)
            return -1;
        int total = 0; int index = 0;
        for(int i =0; i< gas.length; ++i){
            total+=(gas[i]-cost[i]);
            if(total<0){
                total = 0;
                index = i+1;
            }
        }
        return index;
    }
    public long getSumOfElements(int [] ar){
        int ans = 0;
        for(int i =0; i<ar.length; ++i){
            ans+=ar[i];
        }
        return ans;
    }
}
