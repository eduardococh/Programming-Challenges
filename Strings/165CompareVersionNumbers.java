        //My solution
        //Good runtime at 1ms O(N) better than 90.74% 
        //Amazing memory at 34.3mb better than 100%
        //Simple and elegant
class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[]=version1.split("\\.");
        String v2[]=version2.split("\\.");
        int longestV=v1.length>v2.length?v1.length:v2.length;
        for(int i=0;i<longestV;i++){
            int v1Level=v1.length>i?Integer.parseInt(v1[i]):0;
            int v2Level=v2.length>i?Integer.parseInt(v2[i]):0;
            if(v1Level==v2Level){
                continue;
            }else if(v1Level<v2Level){
                return -1;
            }else{
                return 1;
            }
        }
        return 0;
    }
}

        //Leetcode's sample 0ms solution
        //Same runtime and memory as mine, little more elegant
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");
        int length = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < length; i++) {
            int v1 = i >= levels1.length ? 0 : Integer.valueOf(levels1[i]);
            int v2 = i >= levels2.length ? 0 : Integer.valueOf(levels2[i]);
            if (v1 > v2) return 1;
            if (v1 < v2) return -1;
        }
        return 0;
    }
}