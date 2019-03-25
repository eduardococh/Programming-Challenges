class Solution {
	//MY SOLUTION, should not use long so it is wrong
    public int reverse(int x) {
        String num,reversed="";
        boolean isNegative=false;
        if(x<0){
            isNegative=true;
            num=Integer.toString(x);
            num=num.substring(1,num.length());
        }else{
            num=Integer.toString(x);
        }
        for(int i=num.length()-1;i>=0;i--){
            reversed+=num.charAt(i);
        }
        if(isNegative){
            if(Long.parseLong(reversed)*(-1)<Integer.MIN_VALUE){
                return 0;
            }
            return Integer.parseInt(reversed)*(-1);
        }else{
            if(Long.parseLong(reversed)>Integer.MAX_VALUE){
                return 0;
            }
            return Integer.parseInt(reversed);
        }

    }
}
//LEET CODE elegant solution not using long:

  public int reverse(int x) {
        int prevRev = 0 , reversed= 0;
        while( x != 0){
            reversed= reversed*10 + x % 10;
	    //If the number overflows it will return trash
            if((reversed - (x % 10) ) / 10 != prevRev){
                return 0;
            }
            prevRev = reversed;
            x= x/10;
        }
        return reversed;
    }

reversed | x    |  prevRev
7    2147483647    0
74    214748364    7
746    21474836    74
7463    2147483    746
74638    214748    7463
746384    21474    74638
7463847    2147    746384
74638474    214    7463847
746384741    21    74638474
-1126087180    2    746384741