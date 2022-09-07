class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(' || c == '{' || c == '['){
            st.push(c);
        }else if(c == ')'){
            
            if(st.isEmpty() || st.pop() != '('){
                return false;            }
        }
        else if(c == '}'){
            
            if(st.isEmpty() ||st.pop() != '{'){
                return false;            }
        }else if(c == ']'){
            
            if(st.isEmpty() ||st.pop() != '['){
                return false;            }
        }
	}
	return st.isEmpty();
    }
}