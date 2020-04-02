//Challenge: do it without extra memory
//Only solution with O(1) memory is bit manipulation
    //Hash table solution by leetcode
    //Array works too, but search in array is O(N) while hashmap is O(1)
class Solution {
  public int singleNumber(int[] nums) {
    HashMap<Integer, Integer> hash_table = new HashMap<>();

    for (int i : nums) {
      hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
    }
    for (int i : nums) {
      if (hash_table.get(i) == 1) {
        return i;
      }
    }
    return 0;
  }
}

