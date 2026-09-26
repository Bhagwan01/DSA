class Solution {
    public boolean isHappy(int n) {
        // HashSet<Integer> set=new HashSet<>();
        // Hash
        while(n!=1){
            if(n!=1 && n!=7 && n>=0 && n<=9){
                return false;
            }
            //System.out.println(n);
            int temp=0;
            int num=n;
            while(num!=0){
                int t=num%10;
                temp+=Math.pow(t,2);
                num=num/10;
            }
            n=temp;
        }
        return true;
        
    }
}