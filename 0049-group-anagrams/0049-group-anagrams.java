class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<Integer>> map=new HashMap<>();
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            char ch[]=strs[i].toCharArray();
            Arrays.sort(ch);
            String sorted=new String(ch);
            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>());
            }
            map.get(sorted).add(i);
        }
        for(Map.Entry<String,List<Integer>> entry:map.entrySet()){
            List<Integer> item=entry.getValue();
            List<String> temp=new ArrayList<>();
            for(int i=0;i<item.size();i++){
              temp.add(strs[item.get(i)]);
            }
            ans.add(temp);
        }
        return ans;
    }
}