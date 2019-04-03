class Solution {
		//My solution faster than 100% and less memory than 79.27%
       //O(n) time and memory did it in 7m
    public List<String> fizzBuzz(int n) {
        List<String> result=new ArrayList<String>();
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5==0){
                result.add("FizzBuzz");
            }else if(i%3==0){
                result.add("Fizz");
            }else if(i%5==0){
                result.add("Buzz");
            }else{
                result.add(i+"");
		//note using this code uses less memory (better than 96.68) but is slower (64.23);
		//ans.add(""+String.valueOf(i));
            }
        }
        return result;
    }
}