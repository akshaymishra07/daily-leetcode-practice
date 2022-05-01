class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            
            if(s.charAt(i) == '#'){
                if(!s1.isEmpty()){
                    s1.pop();
                }
            }
            else{
                s1.push(s.charAt(i));
            }
        }
        
        for(int i = 0; i < t.length(); i++){
            
            if(t.charAt(i) == '#'){
                if(!s2.isEmpty()){
                    s2.pop();
                }
            }
            else{
                s2.push(t.charAt(i));
            }
            
        }
        
        String r1 = "";
        String r2 = "";
        
        while(!s1.isEmpty()){
            r1 += s1.pop();
        }
        
        while(!s2.isEmpty()){
            r2 += s2.pop();
        }
        
        return r1.equals(r2);
    }
}