package TrappingRainWater;

public class Main {
    public static void main(String[] args) {
        System.out.println(trap(new int [] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
        int [] leftMax = new int[height.length];
        int [] rightMax = new int [height.length];
        int ans = 0;
        //calculate leftMax
        leftMax[0]=height[0];
        for(int i=1; i< leftMax.length; ++i){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }
        //calculate rightMax
        rightMax[rightMax.length-1]= height[height.length-1];
        for(int i = rightMax.length-2; i>=0; --i){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }
        //calculate difference between min(leftMax[i], rightMax[i]) and height[i] and add to ans
        for(int i =1; i< height.length-1; ++i){
            int min = Math.min(rightMax[i], leftMax[i]);
            ans+= min >height[i]
                    ? min - height[i]:0;
        }

        return ans;
    }
}
