package LengthOfLastWord;

public class Main {
    public static void main(String[] args) {
        lengthOfLastWord("Hello      World!!!");
    }

    public static int lengthOfLastWord(String s) {
        String [] sArr = s.split(" ");
        int i = sArr.length-1;
        while(i>0 && sArr[i].length()==0){
            i--;
        }
        return sArr[i].length();

    }

}
