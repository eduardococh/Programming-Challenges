		//Leetcode's sorting solution
		//A simulation of what would happen, interval by interval
		//runtime of 9ms better than 57.38% of solution ¿O(time)? the article said that
		//memory of 38.1mb better than 94.02% o(1) 

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        //Sort them from smaller to bigger
        Arrays.sort(map);
        int time = 0;
        //While the bigger task is not 0
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                //if the biggest task is 0 means all tasks are done
                if (map[25] == 0)
                    break;
                //if i is lower than 26 (if it is not means this interval will be idle
                //and if the task in 25-i is bigger than 0 (otherwise go to next)
                if (i < 26 && map[25 - i] > 0){
                    map[25 - i]--;
                }
                time++;
                i++;
            }
            //Sort so we get new order and avoid the bug from my code where a task was repeated
            Arrays.sort(map);
        }
        return time;
    }
}

		//Leetcode's solution using a priority queue
		//Same approach that ordering follows, but instead of ordering the
		//array we use a priority queue, which orders their elements automatically
		//and will order them in reverse order as specified. 
		//Terrible runtime of 49ms, faster than 29% and runtime of o(n)
		//Good memory at 38.7mb better than 92.70% O(1)
		//worse solution than ordering array apparently
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
	//Create priority queue with inverse order
        PriorityQueue < Integer > queue = new PriorityQueue < > (26, Collections.reverseOrder());
        for (int f: map) {
            if (f > 0)
                queue.add(f);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List < Integer > temp = new ArrayList < > ();
            while (i <= n) {
                if (!queue.isEmpty()) {
		    //if the value in the top of queue is bigger than 1 put it in temp minus 1
                    if (queue.peek() > 1)
                        temp.add(queue.poll() - 1);
                    else
                        queue.poll();
                }
                time++;
                if (queue.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
	    //add all removed elements to queue
            for (int l: temp)
                queue.add(l);
        }
        return time;
    }
}

		//Leetcode's calculation approach
		//Very simple and elegant approach, 
		//Amazing runtime of 2ms better than 100% o(1) (problem solution is wrong)
		//Good memory of 37.8mb better than 95%
		//Best approach of them all

public class Solution {
    public int leastInterval(char[] tasks, int n) {

	//Count every task number
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;

	//Sort tasks from smaller to bigger
        Arrays.sort(map);

	//max val is equal to the task with the biggest number, idle slots is max_val times n cooling time
        int max_val = map[25] - 1, idle_slots = max_val * n;

        for (int i = 24; i >= 0 && map[i] > 0; i--) {
	    
	    //extract from idle slots this task number of executions, or max val, 
            idle_slots -= Math.min(map[i], max_val);
        }
	
	//if idleslots is bigger than 0 return idleslots+tasks.length otherwise only tasks.length 
	//idle slots can be negative
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}





		//My bad solution, doesn't work but interesting for referrence considering first approach
import java.util.Collections;
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter=new int[26];
        int intervals=0,tempN=n;
        final int len=tasks.length;
        for(int i=0;i<len;i++){
            counter[tasks[i]-'A']++;
        }
        int m = 0;
        Integer[] arr2 = new Integer[counter.length];
        for (int value : counter) {
            arr2[m++] = Integer.valueOf(value);
        }
        
        Arrays.sort(arr2, Comparator.reverseOrder());
        m = 0;
        for (int value : arr2) {
            counter[m++] = (int)value;
        }
        for(int i=0;i<26;i++){
            while(counter[i]>0){
                //System.out.println("we add "+(char)(i+'A'));
                counter[i]--;
                intervals++;
                for(int j=i+1;j<26;j++){
                    if(counter[j]>0){
                        if(tempN>0){
                            tempN--;
                        }else{
                            break;
                        }
                        //System.out.println("we add "+(char)(j+'A'));
                        counter[j]--;  
                        intervals++; 
                    }
                }
                boolean tasksLeft=false;
                for(int j=0;j<26;j++){
                    if(counter[j]>0){
                        tasksLeft=true;
                        break;
                    }
                }
                if(!tasksLeft) continue;
                while(tempN>0){
                    //System.out.println("we add empty");
                    tempN--;
                    intervals++;
                }
                tempN=n;
            }
        }
        return intervals;
    }
}