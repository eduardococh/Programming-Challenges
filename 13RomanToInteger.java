class Solution {
		//My solution, very clear, runtime o(n) better than 92% 	
		//Memory o(1), only better than 34%
		//Done in 15minutes
		//Using switch case is a better approach than my if's,  clear with multiple ifs 
		//And switch case seems to be better approach
    public int romanToInt(String s) {
        int result=0,length=s.length();
        for(int i=0;i<length;i++){
            if(s.charAt(i)=='I'){
                if(i+1<length && s.charAt(i+1)=='V'){
                    result+=4;
                    i++;
                }else if(i+1<length && s.charAt(i+1)=='X'){
                    result+=9;
                    i++;
                }else{
                    result++;
                }
            }else if(s.charAt(i)=='V'){
                result+=5;
            }else if(s.charAt(i)=='X'){
                if(i+1<length && s.charAt(i+1)=='L'){
                    result+=40;
                    i++;
                }else if(i+1<length && s.charAt(i+1)=='C'){
                    result+=90;
                    i++;
                }else{
                    result+=10;
                }
            }else if(s.charAt(i)=='L'){
                result+=50;
            }else if(s.charAt(i)=='C'){
                if(i+1<length && s.charAt(i+1)=='D'){
                    result+=400;
                    i++;
                }else if(i+1<length && s.charAt(i+1)=='M'){
                    result+=900;
                    i++;
                }else{
                    result+=100;
                }
            }else if(s.charAt(i)=='D'){
                result+=500;
            }else if(s.charAt(i)=='M'){
                result+=1000;
            }
        }
        return result;
    }
}

class Solution {
		//HashMap solution, another approach but took longer to run, same memory
		//by leetcode HelloWorld123456
public static int romanToInt(String s) {
	if (s == null || s.length() == 0)
		return -1;
	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	map.put('I', 1);
	map.put('V', 5);
	map.put('X', 10);
	map.put('L', 50);
	map.put('C', 100);
	map.put('D', 500);
	map.put('M', 1000);
	int len = s.length(), result = map.get(s.charAt(len - 1));
	for (int i = len - 2; i >= 0; i--) {
		if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
			result += map.get(s.charAt(i));
		else
			result -= map.get(s.charAt(i));
	}
	return result;
}
}

//Another smart solution by hongbin2

public int romanToInt(String s) {
     int sum=0;
    if(s.indexOf("IV")!=-1){sum-=2;}
    if(s.indexOf("IX")!=-1){sum-=2;}
    if(s.indexOf("XL")!=-1){sum-=20;}
    if(s.indexOf("XC")!=-1){sum-=20;}
    if(s.indexOf("CD")!=-1){sum-=200;}
    if(s.indexOf("CM")!=-1){sum-=200;}
    
    char c[]=s.toCharArray();
    int count=0;
    
   for(;count<=s.length()-1;count++){
       if(c[count]=='M') sum+=1000;
       if(c[count]=='D') sum+=500;
       if(c[count]=='C') sum+=100;
       if(c[count]=='L') sum+=50;
       if(c[count]=='X') sum+=10;
       if(c[count]=='V') sum+=5;
       if(c[count]=='I') sum+=1;
       
   }
   
   return sum;
    
}