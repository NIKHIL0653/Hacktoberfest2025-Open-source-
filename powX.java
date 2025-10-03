class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long nn = n; // storing a copy of n

        if(nn<0) nn = -1*nn; // if power is negative convert to positive
        while(nn > 0){ // for n is positive
            if(nn%2 == 1){ // if n is odd multiply the number to answer for n time(usual calculation)
                ans = ans*x;
                nn = nn-1;
            }
            else{ // if n is even 
                x = x*x;
                nn = nn/2;
            }
        }
        //if n is negative we 1/x^n;
        if(n < 0) ans = (double)(1.0)/(double)(ans);
        return ans;
    }
}
