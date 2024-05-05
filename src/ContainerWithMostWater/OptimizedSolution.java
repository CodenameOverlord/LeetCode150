package ContainerWithMostWater;

public class OptimizedSolution {
    public static void main(String[] args) {
        System.out.println(maxArea(new int [] {1,8,6,2,5,4,8,3,7}));

    }

    public static int maxArea(int[] height) {
        int ans = 0;
        // for(int i =0; i< height.length; ++i){
        //     for(int j = i+1; j< height.length; ++j){
        //         ans = Math.max(ans, Math.min(height[i], height[j])* (j-i));
        //     }
        // }

        // we use 2 pointer approach, with pointer at the either end. and we calculate the max
        //now we move the pointer depending on the height of the current pointer, ie,
        //if height of start> end then move end pointer
        //else move start pointer
        int start = 0; int end = height.length-1;
        while(start<end){
            ans = Math.max(ans, (end-start)*(Math.min(height[end], height[start])));
            if(height[start]>height[end]){
                end--;
            }
            else{
                start++;
            }
        }


        return ans;

    }
}

