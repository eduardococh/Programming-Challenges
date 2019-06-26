		//My slow, terrible solution
		//Terrible runtime of 71ms, faster than only 5%
		//Average memory better than 63.63%
		//It seemed like a good solution to me but it seems it is not
class Solution {
    public String reverseVowels(String s) {
        StringBuilder manipulable=new StringBuilder(s);
        int start=0,end=s.length()-1;
        Character[] vows={'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> vowels=new HashSet(Arrays.asList(vows));
        boolean st=false,ed=false;
        while(start<end){
            if(vowels.contains(s.charAt(start))){
                st=true;
            }else{
                st=false;
                start++;
            }
            if(vowels.contains(s.charAt(end))){
                ed=true;
            }else{
                ed=false;
                end--;
            }
            if(st==true && ed==true){
                char aux=s.charAt(start);
                manipulable.replace(start,start+1,s.charAt(end)+"");
                manipulable.replace(end,end+1,aux+"");
                st=false;
                ed=false;
                start++;
                end--;
            }
        }
        return manipulable.toString();
    }
}

		//Much better solution using my same approach
		//Usage of a string as the place to store vowels
		//Bad runtime of 8ms faster than 25%
		//Good memory of 37.7mb better than 92.73%
		//Good implementation of my solution
public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length()==0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start<end){

            while(start<end && !vowels.contains(chars[start]+"")){
                start++;
            }

            while(start<end && !vowels.contains(chars[end]+"")){
                end--;
            }

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }
}

		//A much much better solution than both up there, uses a one by one comparison that i wanted to
		//avoid, but it's way better
		//Amazing runtime of 2ms better than 98.60%
		//Good memory better than 95.29%
		//1ms solution was an overkill i think, this is simple and works
class Solution {
    public String reverseVowels(String s) {
        char[] res = s.toCharArray();
        for(int l=0, r=s.length()-1; l<r;) {
            while(l < r && !isVowel(res[l])){l++;}
            while(l < r && !isVowel(res[r])){r--;}
            
            char temp = res[l];
            res[l++] = res[r];
            res[r--] = temp;
        }
        return new String(res);
    }
    
    private boolean isVowel(char c) {
        return (c == 'a') ||  (c == 'e') || (c == 'i') || (c == 'o') || (c == 'u') || (c == 'A') ||  (c == 'E') || (c == 'I') || (c == 'O') || (c == 'U') ;
    }
    
}