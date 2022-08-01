class RandomizedSet {

    List<Integer> li;
    Map<Integer, Integer> map;
    Random random;
    
    public RandomizedSet() {
        li = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val, li.size());
        li.add(val);
        return true;
    }
    
    public boolean remove(int val) {

        if(!map.containsKey(val)){
            return false;
        }
        
        int idx = map.get(val);
        
        if(idx != li.size()-1){
            
            int last = li.get(li.size()-1);
            li.set(idx, last);
            map.put(last, idx);
        }
        
        map.remove(val);
        li.remove(li.size()-1);
        return true;
        
    }
    
    public int getRandom() {
        
        int i = random.nextInt(li.size());
        
        return li.get(i); 
    }
    
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */