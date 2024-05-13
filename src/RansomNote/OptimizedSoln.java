package RansomNote;

public class OptimizedSoln {
    public static void main(String[] args) {
        System.out.println(canConstruct("acnsdlf", "acnsdlfacnsdlf"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char [] ransomChar = getCharArrFromString(ransomNote);
        char [] magChar = getCharArrFromString(magazine);
        return checkIfSubSetCharArr(ransomChar, magChar);
    }
    public static char [] getCharArrFromString(String s){
        char [] alpha  = new char [26];
        for(int i =0; i< s.length(); ++i){
            alpha[s.charAt(i) - 'a']++;
        }
        return alpha;
    }

    public static  boolean checkIfSubSetCharArr(char [] c, char [] p){
        for(int i = 0; i< c.length; ++i){
            if(c[i]>p[i]){
                return false;
            }
        }
        return true;
    }
}
