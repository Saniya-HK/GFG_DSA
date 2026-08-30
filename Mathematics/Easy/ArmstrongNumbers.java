class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        int original = n;
        int ans =0;
        while(n!=0){
            int rem=n%10;
            ans +=rem*rem*rem;
            n=n/10;
        }
        return (original==ans);
    }
}
