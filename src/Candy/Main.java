package Candy;

public class Main {

    public int candy(int[] ratings) {
        int ans = ratings.length;
        int choco[] = new int[ratings.length];
        for(int i =1; i< ratings.length; ++i){
            if(ratings[i]>ratings[i-1]){
                choco[i]= choco[i-1]+1;
            }
        }

        for(int i =ratings.length-2; i>=0; --i){
            if(ratings[i]>ratings[i+1]){
                choco[i]= Math.max(choco[i+1]+1, choco[i]);
            }
        }

        for(int i =0; i< choco.length;++i){
            ans+=choco[i];
        }

        return ans;
    }

}
