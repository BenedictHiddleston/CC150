public class Solution {
    public boolean isValid(String s) {
    	// HashMap for parenthese pairs
    	HashMap<Character, Character> hm = new HashMap<Character, Character> () ;
    	hm.put('(',')');
    	hm.put('[',']');
    	hm.put('{','}');

    	int len = s.length() ;

    	// create stack
    	Stack<Character> stack = new Stack<Character>() ;

    	// push left parenthese and check right one, pop() if they are pair
    	for(int i = 0; i < len ;i++) {
    		char current = s.charAt(i) ;
    		if(hm.containsKey(current)){
    			// current is left
    			stack.push(current) ;
    		}else{
    			if(!stack.isEmpty() && hm.get(stack.peek()) == current) {
    				stack.pop() ;
    			}else{
    			    return false ;
    			}
    		}
    	}
    	// return true if stack is empty
        return stack.isEmpty() ;
    }
}
