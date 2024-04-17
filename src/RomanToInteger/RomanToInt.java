package RomanToInteger;

public class RomanToInt {

    // Learn to see the pattern, once you see the pattern, their fate is yours to decide
    // Find the pattern:
    // 1. taken a string where the priority is non increasing: we see we can process 2 string eg:
    // xx = 20 and xi = 11;
    // 2. if the pattern is decreasing: then, we take the last element and deduct the first element
    // eg: ix = 10-1 = 9;
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String s) {
        if(s.length()==1){
            return charToInt(s.charAt(0));
        }
        char [] charArr = s.toCharArray();
        int i =0;
        int j = 1;
        int ans = 0;
        while(j<charArr.length && i< charArr.length){
            int intI = charToInt(charArr[i]);
            int intJ = charToInt(charArr[j]);

            if(intI<intJ){
                ans+= intJ-intI;
                i+=2;j+=2;

            }
            else{
                ans += intI;
                i++; j++;
            }
        }
        if(i<charArr.length){
            ans+= charToInt(charArr[i]);
        }
        return ans;

    }

    public static int charToInt(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }

    }

}
