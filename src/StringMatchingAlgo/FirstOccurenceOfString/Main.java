package StringMatchingAlgo.FirstOccurenceOfString;

public class Main {
    public static void main(String[] args) {
        System.out.println(strStr(
                "leetcodecode", "code"
        ));

    }

    public static int strStr(String haystack, String needle) {
        char [] hayC = haystack.toCharArray();
        char [] needC = needle.toCharArray();
        for(int i = 0; i< hayC.length; ++i){
            if(hayC[i]==(needC[0])){
                if(checkIfSeqMatchesAtI(hayC, i, needC)){
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean checkIfSeqMatchesAtI(char[] hayC, int i, char[] needC) {
        int j = 0;
        while(i< hayC.length && j<needC.length){
            if(hayC[i] == needC[j]){
                i++; j++;
            }
            else{
                return false;
            }
        }
        return j == needC.length;
    }
}
