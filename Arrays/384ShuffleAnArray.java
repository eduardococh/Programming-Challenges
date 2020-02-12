class Solution {
		//leetcode Brute force approach, The brute force algorithm essentially puts each number
		//in the aforementioned "hat" (a list), and draws them at random (without replacement)
		// until there are none left.
		//Faster than only 46.77%, runtime of O(N^2), this is because for every n removed from the hat it takes an n linear time
		//Memory less than 61% O(N)

		///Important: Note usage of the clone() method, which creates a deep copy instead of a copy by reference 

    private int[] array;
	//Saves a copy of the array, since the original array will be modified with the shuffle method
	//not the best naming (array is the original array and original is the copy array) 
    private int[] original;

    private Random rand = new Random();

	//This method returns an initialized list with the values of the array
    private List<Integer> getArrayCopy() {
        List<Integer> asList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            asList.add(array[i]);
        }
        return asList;
    }

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }
    
		//We use 'aux' as our "hat", get random numbers and then removing it
    public int[] shuffle() {
        List<Integer> aux = getArrayCopy();

        for (int i = 0; i < array.length; i++) {
            int removeIdx = rand.nextInt(aux.size());
            array[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }

        return array;
    }
}



		//leetcode  116 ms sample Simpler approach,
		//Faster than leetcode code by 2ms and easier to read i think
class Solution {

    
    int[] original;
    Random random;
    int[] numArray;
    
    public Solution(int[] nums) {
        original = nums;
        numArray = nums.clone();
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < numArray.length; i++){
            int temp = random.nextInt(numArray.length-i);
            int tmp = numArray[temp+i];
            numArray[temp+i] = numArray[i];
            numArray[i] = tmp;
        }
        return numArray;
    }
}



		//leetcode APPROACH 2 FISCHER-YATES Algorithm
		//Instead of generating a hat (whose remove method takes linear time for every execution) we just shuffle the array
		//This makes it linear time o(N) since we no longer need a list (or hat)
class Solution {
    private int[] array;
    private int[] original;

    Random rand = new Random();

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}
