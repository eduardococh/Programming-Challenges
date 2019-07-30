        //My solution
        //It throws time limit excedeed so not even solution   
        //Time complexity of O(N^2)
        //Memory of O(N^2)
        //Improvement over my initial O(N^3) approach, but not yet enough
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result=0;
        double[][] distances=new double[points.length*points.length][3];
        int index=0;
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                distances[index][0]=Math.sqrt(Math.pow(Math.abs(points[i][0]-points[j][0]),2)+Math.pow(Math.abs(points[i][1]-points[j][1]),2));
                distances[index][1]=i;
                distances[index][2]=j;
                index++;
            }
        }
        
        for(int i=0;i<index;i++){
            for(int j=0;j<index;j++){
                if(i==j) continue;
                if(distances[i][0]==distances[j][0] &&
                  (distances[i][1]==distances[j][1] || distances[i][2]==distances[j][2] || distances[i][2]==distances[j][1] || distances[i][1]==distances[j][2])){
                    result++;
                }
            }
        }
        return result;
    }
}

        //Solution by leetcode's asurana28
        //Really clever not calculating the euclidean distance, since it is not needed
        //manhattan distance works same, 
        //Average runtime at 81 ms better than 71.52%
        //Average memory better than around 61%
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<points.length; i++) {
            for(int j=0; j<points.length; j++) {
                if(i == j)
                    continue;

                int d = getDistance(points[i], points[j]);                
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            //A boomerang required at least 2 points, so for all 1's it will add 0 
            //For those bigger than 1 (it will return n*(n-1))
            for(int val : map.values()) {
                res += val * (val-1);
            }            
            map.clear();
        }

        return res;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }
}


        //From leetcode's sample 52ms
        //It is faster than solution above and clearer I think, both are good ways of understanding
        //the problem, here we do the permutation in every iteration, in 2*count
        //the approach above does the permutation with n*(n-1), this one is faster thou
        //Good runtime at 54ms better than 97.23%
        //Almost same memory as above
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null) return 0;
        int boomerangs = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<points.length; i++){
            for(int j=0; j<points.length; j++){
                if(j == i) continue;
                int dist = getDistance(points[i], points[j]);
                int count = map.getOrDefault(dist, 0);
                boomerangs += 2*count;
                map.put(dist, count+1);
            }
            map.clear();
        }
        
        return boomerangs;
    }
    
    private int getDistance(int[] point1, int[] point2){
        int x = point1[0] - point2[0], y = point1[1] - point2[1];
        //Elevating x and y to the square does not give real manhattan distance, but eliminates negatives
        //and given the low range of numbers there's no overflow danger
        return (x * x + y * y);
    }
}