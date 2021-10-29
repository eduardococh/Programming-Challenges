//Greedy solution
//Sort both arrays and give the first child the smallest possible cookie, if this cookie is not enough to satisfy this 
//child, the next one could be, while no later child will get satisfied with current cookie because we sorted
//Runtime O(N Log N) bc of sorting
//Memory O(1)
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int greedPointer=0,sizePointer=0;
        int contentNumber=0;
        while(greedPointer<g.length && sizePointer<s.length){
            if(g[greedPointer]<=s[sizePointer]){
                contentNumber++;
                greedPointer++;
                sizePointer++;
            }else{
                //look for a cookie that will satisfy the child
                sizePointer++;
            }
        }
        return contentNumber;
    }
}