class Solution {
   
    
    static void pp(int n, int l, int r, String str,List<String> res){
        
        if(l == 0 && r == 0){
           
            res.add(str);
            return;
        }
        
        if(l != 0){
           
        pp(n,l-1,r,str+"(",res);
        }
        
        if(r > l){
          pp(n,l,r-1,str+")",res);     
        }
        
    }
    public List<String> generateParenthesis(int n) {
        
        String str = "";
        List<String> result = new ArrayList<>();
        
        int l = n;
        int r = n;
        
        pp(n,l,r,str,result);
        
        return result;
        
    }
}