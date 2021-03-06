        //My solution using one pass hashMap
        //Bad runtime of 13ms better than only 26.15% O(M+N)
        //Terrible memory better than only 6.45% O(M) 
        //Simple approach, add first list to hashMap and then search elements in second list
        //Described in 3rd approach by leetcode, and to me more logical than the first two
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> res=new ArrayList<String>();
        HashMap<String,Integer> myMap=new HashMap<String,Integer>();
        final int len=list1.length;
        for(int i=0;i<len;i++){
            myMap.put(list1[i],i);
        }
        int smallestSum=Integer.MAX_VALUE;
        final int len2=list2.length;
        for(int i=0;i<len2;i++){
            if(myMap.containsKey(list2[i])){
                if(myMap.get(list2[i])+i<smallestSum){
                    res.clear();
                    res.add(list2[i]);
                    smallestSum=myMap.get(list2[i])+i;
                }else if(myMap.get(list2[i])+i==smallestSum){
                    res.add(list2[i]);
                }
            }
        }
        int resLen=res.size();
        String result[]=new String[resLen];
        for(int i=0;i<resLen;i++){
            result[i]=res.get(i);
        }
        return result;
    }
}


        //Same approach as me but more efficient
        //Good runtime of 7ms faster than 91.36%
        //Bad memory of 42mb better than 19.35%
        //usage of to array method is a noticeable change
        //subtle changes
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n = list1.length, m = list2.length;
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++){
            map1.put(list1[i], i);
        }
        int min = list1.length + list2.length;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list2.length; i++){
            String str = list2[i];
            int sum = i + map1.getOrDefault(str, n + m);
            if (sum < min) result.clear();
            min = Math.min(sum, min);
            if (sum == min) result.add(str);
        }
        return result.toArray(new String[0]);
    }
}