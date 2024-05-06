package HappyNumber;

public class Main {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
        ;
    }

    //much like finding loop in a linked list, use slow pointer and fast pointer
    //slow = x, fast = f(x)
    // slow = f(x)
    // fast = f(f(x))
    // if slow == fast then there is a loop
    //logic
//    int slow = n; int fast = digitSq(n);
//        while(slow!=fast){
//        slow = digitSq(slow);
//        fast = digitSq(digitSq(fast));
//    }

    static boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        int slow = n; int fast = digitSq(n);
        while(slow!=fast){
            slow = digitSq(slow);
            fast = digitSq(digitSq(fast));
        }

        return slow==1;
    }

    static int digitSq(int n){
        int ans = 0;
        int temp = n;
        while(temp>0){
            int rem = temp%10;
            ans += rem*rem;
            temp/=10;
        }
        return ans;
    }


}
