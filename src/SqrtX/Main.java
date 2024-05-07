package SqrtX;

public class Main {
    public static void main(String[] args) {
        System.out.println(mySqrt(24));
    }
    public static int mySqrt(int x) {
        long start = 1, end = x;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long prod = mid * mid;
            if (prod <= x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int)end;
    }
}
