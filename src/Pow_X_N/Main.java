package Pow_X_N;

public class Main {
    public static void main(String[] args) {
        System.out.println(myPow(2,-3));
    }

    public static double myPow(double x, int n) {
        if(n==0)
            return (double)1;
        if(n==1)
            return (double)x;
        if(n==-1)
            return (double)1/x;

        if(n%2==0){
            double ans = myPow(x, n/2);
            return ans*ans;
        }
        else{

            if(n<0){
                double ans = myPow(x, (n+1)/2);
                return ans*ans*1/x;

            }
            else{
                double ans = myPow(x, (n-1)/2);
                return ans*ans*x;
            }
        }
    }
}
