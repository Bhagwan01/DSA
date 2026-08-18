class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] outdegree=new int[graph.length];
        for(int i=0;i<outdegree.length;i++){
            outdegree[i]=graph[i].length;
        }
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,List<Integer>> map=new HashMap<>();
       
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                if(!map.containsKey(graph[i][j])){
                    map.put(graph[i][j],new ArrayList<>());
                }
                map.get(graph[i][j]).add(i);
            }
            
        }
       Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<outdegree.length;i++){
            if(outdegree[i]==0){
               q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.poll();
            list.add(node);
            for(Integer next:map.getOrDefault(node,new ArrayList<>())){
                outdegree[next]--;
                if(outdegree[next]==0){
                    q.offer(next);
                }
            }
        }
        Collections.sort(list);
        return list;
        
        
    }
}