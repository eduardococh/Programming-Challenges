		//My solution
		//Not the most elegant but simple i think
		//Count all number frequencies in the first loop, use a map to help with index
		//then sort the matrix by the first column and at last get the last k numbers
		//of the matrix first column
		//Average runtime of 14ms better than 65.86%
		//Bad memory of	41.5mb better than 20.57%
		//All solutions have some sort of sorting so better to learn complex sorting
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result=new ArrayList<Integer>();
        Map<Integer,Integer> keyMap=new HashMap<Integer,Integer>();
        int count[][]=new int[nums.length][2];
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(keyMap.containsKey(nums[i])){
                count[keyMap.get(nums[i])][0]++;
            }else{
                keyMap.put(nums[i],index);
                count[keyMap.get(nums[i])][0]++;
                count[keyMap.get(nums[i])][1]=nums[i];
                index++;
            }
        }
        java.util.Arrays.sort(count, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Double.compare(a[0], b[0]);
            }
        });
        for(int i=0;i<k;i++){
            result.add(count[count.length-i-1][1]);
        }
        return result;
    }
}

		//Leetcode's solution
		//To my surprise a bad solution
		//Bad runtime of 51ms better than only 6%
		//Average memory of 40.2mb better than 63.72%
class Solution {
  public List<Integer> topKFrequent(int[] nums, int k) {

    // build hash map : character and how often it appears
    HashMap<Integer, Integer> count = new HashMap();
    for (int n: nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }

    // init heap 'the less frequent element first'
    PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

    // keep k top frequent elements in the heap
     for (int n: count.keySet()) {
      heap.add(n);
      if (heap.size() > k)
        heap.poll();
    }

    // build output list
    List<Integer> top_k = new LinkedList();
    while (!heap.isEmpty())
      top_k.add(heap.poll());
    Collections.reverse(top_k);
    return top_k;
  }
}