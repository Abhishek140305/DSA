class Solution {
    public String removeDuplicateLetters(String s) {

        if(s.length()<1){
            return s;
        }
        
        StringBuilder sb = new StringBuilder();

        int[] a1 = new int[26];
        boolean[] a2 = new boolean[26];

        for(int i=0; i<s.length(); i++){
            a1[s.charAt(i)-'a'] = i ;
        }

        for(int i=0; i<s.length(); i++){
            char currChar = s.charAt(i);
            int currIdx = currChar - 'a';

            if(a2[currIdx] == true){
                continue;
            }

            while(sb.length() > 0 && sb.charAt(sb.length()-1) > currChar &&   a1[sb.charAt(sb.length()-1) - 'a'] > i ){
                
                a2[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);   
            }  

            sb.append(s.charAt(i));       
            a2[currIdx] = true;   
        }

        return sb.toString();
    }
}