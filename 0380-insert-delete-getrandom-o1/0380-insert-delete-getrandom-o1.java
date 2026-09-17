class RandomizedSet {
  HashMap<Integer,Integer> map;
  List<Integer> list;
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<>();
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
         list.add(val);
        map.put(val,list.size()-1);
       
        
        return true;
        
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int idx=map.get(val);
        int value=list.get(list.size()-1);
        list.set(idx,value);
        list.remove(list.size()-1);
        map.put(value,idx);
        map.remove(val);
        return true;
        
    }
    
    public int getRandom() {
        int min = 0;
        int max = list.size()-1;
        int randomNum = (int)(Math.random() * ((max - min) + 1)) + min;
        return list.get(randomNum);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */