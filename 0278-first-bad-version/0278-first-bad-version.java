/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int st=1;
        int end=n;
        int valid=-1;
        while(st<end){
            int mid=st+(end-st)/2;
            if(isBadVersion(mid)==false){
                valid=mid;
                st=mid+1;
            }else{
                end=mid;
            }
        }
        if(isBadVersion(st)==true){
            return st;
        }
        return end;
    }
} 