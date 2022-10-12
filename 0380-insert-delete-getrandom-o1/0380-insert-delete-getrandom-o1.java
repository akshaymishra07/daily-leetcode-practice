class RandomizedSet {
    
    Map<Integer, Integer> map;
    List<Integer> li;
    Random random;

    public RandomizedSet() {
        
        map = new HashMap<>();
        li = new ArrayList<>();
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
        
        int index = map.get(val);
        
        if(index != li.size()-1){
            
            int temp = li.get(index);
            li.set(index, li.get(li.size()-1));
            li.set(li.size()-1, temp);
            
            map.put(li.get(index), index);
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