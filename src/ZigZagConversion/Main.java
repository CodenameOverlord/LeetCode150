package ZigZagConversion;

public class Main {
    public static void main(String[] args) {
        System.out.println(convert("paypalishiring",3));
    }
    public static String convert(String s, int numRows) {
        if(numRows == 1 || numRows == s.length()){
            return s;
        }
        StringBuffer [] sArr = new StringBuffer[numRows];
        for(int i = 0; i< sArr.length; ++i){
            sArr[i]=  new StringBuffer();
        }
        int count = 0; boolean incFlag = true;
        for(int i =0; i<s.length(); ++i){
            if(count == numRows-1){
                incFlag = false;
            }
            if(count == 0){
                incFlag = true;
            }
            sArr[count].append(s.charAt(i));
            if(incFlag){
                count++;
            }else{
                count--;
            }
        }
        StringBuffer sB = new StringBuffer();
        for(int i=0; i< sArr.length; ++i){
            sB.append(sArr[i].toString());
        }
        return sB.toString();
    }
}
