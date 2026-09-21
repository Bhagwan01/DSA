class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> q=new LinkedList<>();
        HashSet<String> set=new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }
        set.remove(beginWord);
        q.offer(new pair(beginWord,1));
        while(!q.isEmpty()){
            pair p=q.poll();
            String curr=p.str;
            int count=p.c;
            if(curr.equals(endWord)){
                return count;
            }
            for(int i=0;i<curr.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] curr_arr=curr.toCharArray();
                    curr_arr[i]=ch;
                    String temp=new String(curr_arr);
                    if(set.contains(temp)){
                        set.remove(temp);
                        q.offer(new pair(temp,count+1));
                    }
                }
            }
        }
        return 0;

    }
}
class pair{
    String str;
    int c;
    pair(String s,int a){
        str=s;
        c=a;
    }
}