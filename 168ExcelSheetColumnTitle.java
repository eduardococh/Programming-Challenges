		//My solution, better than 100%
		//Memory better than 100%
		//Simple problem but tricky, because it's not like normal numeric systems
		//dividing by 26 wont work because every 26 digits you add 1
		
class Solution {
    public String convertToTitle(int n) {
        StringBuilder result=new StringBuilder("");
        while(n>0){
            if(n%26==0){
                result.insert(0,'Z');
                n--;
            }else{
                result.insert(0,(char)(n%26+64));
            }
            
            n=n/26;
        }
        return result.toString();
    }
}

		//Same approach than me, more elegant solution
		//By leetcode's murat

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.insert(0, (char)('A' + n % 26));
            n /= 26;
        }

        return result.toString();
    }
}