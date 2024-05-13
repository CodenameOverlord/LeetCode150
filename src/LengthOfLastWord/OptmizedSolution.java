package LengthOfLastWord;

public class OptmizedSolution {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("HellO     World         "));
    }

    public static int lengthOfLastWord(String s) {
        char [] c= s.toCharArray();
        int i = c.length-1;
        while(i>=0 && c[i]==' '){
            i--;
        }
        int count =0;
        while(i>=0 && c[i]!=' '){
            count++; i --;
        }
        return count;
    }
}
