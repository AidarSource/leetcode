class Solution {
    
    class Pair{
        char c;
        int idx;
        
        Pair(char cc, int idx){
            this.c = cc;
            this.idx = idx;
        }
    }
    public boolean canChange(String start, String target) {
        
        int idx = 0;
        int n = start.length();
        Stack<Pair> s1 = new Stack<>();
        Stack<Pair> s2 = new Stack<>();
        
        // Fill the stacks
        for(int i = n-1; i >=  0; i--){
            
            if(start.charAt(i) == 'L' || start.charAt(i) == 'R'){
                s1.push(new Pair(start.charAt(i), i));
            }
            
            if(target.charAt(i) == 'L' || target.charAt(i) == 'R'){
                s2.push(new Pair(target.charAt(i), i));
            }
            
        }
        
        // Early return 
        if(s1.size() != s2.size()){
            return false;
        }
        
        // Validates both the sequinces
        while(!s1.isEmpty()){
            
            Pair s = s1.pop();
            Pair e = s2.pop();
            
            if(s.c != e.c){
                return false;
            }
            
            if(s.c == 'L' && e.c == 'L'){
                if(e.idx > s.idx){
                    return false;
                }
            }
            
            
            if(s.c == 'R' && e.c == 'R'){
                if(e.idx < s.idx){
                    return false;
                }
            }
        }
        
        
        return true;
    }
}