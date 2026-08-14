class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        HashMap<String,Integer> map=new HashMap<>();
        map.put(beginWord,1);
        int ans=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
            String curr=q.poll();
            //System.out.println(curr);
            if(curr.equals(endWord)){
                return ans;
            }
            for(String word:wordList){
               if(!map.containsKey(word)){
                 int count=0;
             for(int k=0;k<word.length();k++){
                if(word.charAt(k)!=curr.charAt(k)){
                    count++;
                } 
             }
             if(count==1){
                map.put(word,1);
                q.offer(word);
             }
               }
             
            }

            }
            ans++;

        } 
        return 0;

    }
}