class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1]!=9){
            digits[digits.length-1]=digits[digits.length-1]+1;
            return digits;
        }
        List<Integer> list=new ArrayList<>();
        int ten=1;
        list.add(0,0);
        for(int i=digits.length-2;i>=0;i--){
          int temp=digits[i]+ten;
           if(temp==10){
            list.add(0,0);
           }else{
            list.add(0,temp);
            ten=0;
           }
        }
        if(ten==1){
            list.add(0,1);
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}