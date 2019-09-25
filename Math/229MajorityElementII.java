        //Solution by leetcode's jeantimex
        //Average runtime of 3ms better than 37.50% O(N)
        //Average memory O(1)
        //The clearest solution using Moore's Voting Algorithm that I found, I really like it
        //The trick to the solution that I missed is in the question wording
        //It has to appear MORE THAN N/3, so for 1,1,2,2,3,3 it will return 0 since
        //they all appear n/3 times but no more than that,giving us 2 answers at most, but could be 0
        //m1 and m2 save the number, c1 and c2 save the count
        //Since the number could be any number we use Integer, so null is the first empty number
class Solution {
    public List<Integer> majorityElement(int[] a) {
        // we can only have maximum 2 majority elements
        int n = a.length;
        int c1 = 0, c2 = 0;
        Integer m1 = null, m2 = null;
        
        // step 1. find out those 2 majority elements
        // using Moore majority voting algorithm
        for (int i = 0; i < n; i++) {
            if (m1 != null && a[i] == m1)      { c1++; } //I'm one of the highest
            else if (m2 != null && a[i] == m2) { c2++; } //I'm the other highest
            else if (c1 == 0)                  { m1 = a[i]; c1 = 1; } //The votes for c1 are 0, I'll be the new c1 (1 vote,mine)
            else if (c2 == 0)                  { m2 = a[i]; c2 = 1; } //The votes for c2 are 0, I'll be the new c2 (1 vote,mine)
            else                               { c1--; c2--; } //I'm not the highest and c1 and c2 are already
                                                               //assigned, I'll downvote both 
        }
        
        //here we get the actual values, since the voting algorithm will give us the two most frequent numbers
        //but not their absolute number of repetitions, since the voting can decrease this
        // step 2. get the actual number of m1 and m2
        c1 = 0; c2 = 0;
        
        for (int i = 0; i < n; i++) {
            if (m1 != null && a[i] == m1) c1++;
            if (m2 != null && a[i] == m2) c2++;
        }
        
        List<Integer> res = new ArrayList<Integer>();
        
        //Check if I'm bigger than n/3 (equal does not work)
        if (c1 > n / 3) res.add(m1);
        if (c2 > n / 3) res.add(m2);
        
        return res;
    }
}