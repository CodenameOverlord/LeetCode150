package HIndex;

import java.util.Arrays;

public class Main {
    public int hIndex(int[] citations) {
        if(citations.length==1){
            if(citations[0]>0){
                return 1;
            }
            return 0;
        }
        Arrays.sort(citations);
        int n = citations.length;
        int h =0;
        for(int i = 0; i< n;++i){
            int curr = citations[i];
            if(n-i>=curr){
                h=curr;
            }
            if(curr>n-i){
                h= Math.max(h, n-i);
            }
        }
        return h;
    }
}
