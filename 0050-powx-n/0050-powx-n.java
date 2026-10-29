class Solution {
    public double myPow(double x, int n) {
        double ans = 1.0;
        long pow = n;
        boolean negative=pow<0;
        if (negative) {
            pow = -(pow);
        }
        while (pow > 0) {
            if ((pow & 1)== 1) {
                ans = ans * x;
            }
            x = x * x;
            pow = pow>>1;
        }
        return negative ? 1.0 / ans : ans;
        
    }
}