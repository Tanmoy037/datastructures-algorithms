class Solution {
    public double myPow(double x, int n) {
        if (n < 0){
            double ans = myPowHelper( x, -n);
            return 1/ans ;
            
        } else {
            double ans  = myPowHelper( x, n);
            return ans;            
        }
    }
    public double myPowHelper(double x, int n) {
        if (n == 1){
            return x;
        }
        if (n == 0) {  
            return 1;
        }

        double temp = myPowHelper(x , n/2);
        if (n % 2 == 0){
            return temp * temp;
        } else {
            return temp * temp * x;
        }

    }
}