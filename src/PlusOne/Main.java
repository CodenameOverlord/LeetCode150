package PlusOne;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int ans [] = plusOne(new int[]{
                1,2,3,4
        });
        Arrays.stream(ans).forEach(System.out::println);
    }
    public static int[] plusOne(int[] digits) {
        int carryOver = 0;
        int j = digits.length-1;
        digits[j]= digits[j]+1;
        while(j>=0){
            if(digits[j]+carryOver< 10){
                digits[j] = digits[j]+carryOver;
                carryOver = 0;
                j--;
            }
            else{
                int temp = (digits[j]+ carryOver)/10;
                digits[j]= (digits[j]+ carryOver)%10;
                carryOver = temp;
                j--;
            }
        }
        if(carryOver>0){
            int [] result = new int [digits.length+1];
            for(int i =1; i< result.length; ++i){
                result[i]= digits[i-1];
            }
            result[0]= carryOver;
            return result;
        }else{
            return digits;
        }
    }

}
