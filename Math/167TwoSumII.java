		//My solution using hashmap
		//The same solution as in two sum 1
		//Bad runtime at 2ms better than only 28.85%
		//Medium memory better than only 57.15%
		//Not really the best solution since it is ordered
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> myMap=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(myMap.containsKey(target-numbers[i])){
                return new int[]{myMap.get(target-numbers[i]),i+1};
            }
            myMap.put(numbers[i],i+1);
        }
        return null;
    }
}

		//From leetcodes sample 0ms
		//Basic algorithm, start a pointer from the bigger numbers (length)
		//and another from the smaller numbers(from 0) and if they are not target
		//ask if the sum if bigger than target, if it is decrease the pointer of big numbers
		//if they are smaller, increase the pointer of small numbers
		//Very simple, no need for a hash map since its ordered
		//Runtime of 0ms better than 100%
		//Memory of 36.9mb, less than 57.73% , but this is a weird measure, i found one of the best
		//memory algoritms using the same hashmap that i used and getting way better memory 
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length-1;
        while (numbers[p1] + numbers[p2] != target) {
            if (numbers[p1] + numbers[p2] > target) {
                p2--;
            }else {
                p1++;
            }
        }
        return {p1+1,p2+1};
    }
}