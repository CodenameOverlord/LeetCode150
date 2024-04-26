package CountPrimes;

public class OptimizedSoln {
    public static void main(String[] args) {
        System.out.println(countPrimes(240));
    }

    public static int countPrimes(int n) {
        if(n<3){
            return 0;
        }
        int [] arr = new int [n];
        for(int i = 2; i*i<n; ++i){
            if(arr[i]==0)
            for(int j = i*i; j<n; j+=i){
                arr[j]=-1;
            }
        }
        int count = 0;
        for(int i = 2; i<arr.length; ++i){
            if(arr[i]!=-1)
                count++;
        }

        return count;
    }
}
