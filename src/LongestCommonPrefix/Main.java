package LongestCommonPrefix;

public class Main {
    public static void main(String[] args) {
        String [] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String begin = strs[0];
        String maxCommon = begin;
        for(int i = 1; i< strs.length; ++i){
            maxCommon = compare(maxCommon, strs[i]);
            if(maxCommon.equals(""))
                return maxCommon;
            ;
        }
        return maxCommon;
    }

    static String compare(String s1, String s2){
        int i = 0;
        StringBuilder s = new StringBuilder();
        while(i<s1.length() && i<s2.length()){
            if(s1.charAt(i)==s2.charAt(i)){
                s.append(s1.charAt(i)+"");
            }
            else{
                return s.toString();
            }
            i++;
        }
        return s.toString();
    }

}
