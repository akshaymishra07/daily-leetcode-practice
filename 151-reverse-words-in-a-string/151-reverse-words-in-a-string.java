class Solution {
    
    // function to reverse just the words in the string not the whole string
    String solve(String s){
        
        String ans = "";
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            
            if(s.charAt(i) == ' '){
                String temp = "";
                while(!st.isEmpty()){
                    
                    temp += st.pop();
                }
                
                temp += " ";
                ans += temp;
                continue;
            }
            
            st.push(s.charAt(i));
        }
        
        String temp = "";
                while(!st.isEmpty()){
                    
                    temp += st.pop();
                }
         ans += temp;
        return ans;
    }
    
    //function for the actual problem mentioned in the description
     String solve(String s, int n){
        
        String ans = "";
        String[] arr = s.split(" ");
         
         System.out.println(Arrays.toString(arr));
      
        for(int i = arr.length-1; i >= 0; i--){
            if(arr[i].equals("") && ans.substring(ans.length()-1, ans.length()).equals(" ")){
              continue;   
            }
            
            ans += arr[i]+" ";
        } 
         
        return ans.substring(0,ans.length()-1);
    }
    public String reverseWords(String s) {
        s = s.trim();
        return solve(s, s.length());
    }
}