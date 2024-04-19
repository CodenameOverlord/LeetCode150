package RomanToInteger;

public class UpdatedSoln {
    public String longestCommonPrefix(String[] strs) {
        int smallest = Integer.MAX_VALUE;
        for (int i=0; i<strs.length; i++) {
            smallest = Math.min(smallest, strs[i].length());
        }
        char[] lcp = new char[smallest];
        int i=0;

        for (; i<smallest; i++) {
            boolean common = true;
            char ch = strs[0].charAt(i);
            for (int j=1; j<strs.length; j++) {
                if (strs[j].charAt(i) != ch) {
                    common = false;
                    break;
                }
            }
            if (!common) break;
            else lcp[i] = ch;
        }
        StringBuilder sb = new StringBuilder();
        for (int j=0; j<i; j++) {
            sb.append(lcp[j]);
        }
        return sb.toString();
    }
}
