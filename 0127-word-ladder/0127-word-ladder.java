class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        for(String word: wordList){
            set.add(word);
        }
        set.remove(beginWord);
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair p=q.poll();
            String curr=p.Word;
            int val=p.count;
            if(curr.equals(endWord)){
                return val;
            }
            for(int i=0;i<curr.length();i++){
                for(char c='a';c<='z';c++){
                    char[] ch_array=curr.toCharArray();
                    ch_array[i]=c;
                    String temp=new String(ch_array);
                    if(set.contains(temp)==true){
                        set.remove(temp);
                        q.offer(new Pair(temp,val+1));
                    }

                }
            }
        }
        return 0;
        
    }
}
class Pair{
    String Word;
    int count;
    Pair(String a,int b){
        this.Word=a;
        this.count=b;
    }
}