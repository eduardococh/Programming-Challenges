        //My solution
        //Usage of a graph to keep track of dependencies
        //Where a dependency is formed by the first difference between two words
        //And with the help of a hashmap
        //Good runtime of 3ms better than 79.82% O(M*N) where M is lenght of array and 
        //N lenght of words, processGraph method time complexity is O(L) where L is the number of
        //letters (26 maximum), so it does not affect the O(M*N)
        //Bad runtime better than only 5.41% O(1)? 
        //Not the most elegant solution, but the general structure is very similar to what good solutions
        //do, where my compare words is the graph creation and processGraph is dfs
        //IMPROVEMENT
        //Usage of "loop" keyword as an exit condition makes the code complex, should be replaced
        //by a boolean return in method, as seen in second solution
class Solution {
    public String alienOrder(String[] words) {
        HashSet<Character> letters=new HashSet<>();  
        HashMap<Character,ArrayList<Character>> dependencies=new HashMap<>();
        int len=words.length;
        StringBuilder result=new StringBuilder("");
        if(len==1) return words[0];
        for(int i=0;i<len-1;i++){
            if(!compareWords(words[i],words[i+1],letters,dependencies)) return "";
        }
        for(Character letter:letters){
            processGraph(letter,dependencies,result,new HashSet<Character>());
            if(result.toString().equals("loop")) return "";
        }
        return result.toString();
    }
    
    public void processGraph(Character letter,HashMap<Character,ArrayList<Character>> dependencies,StringBuilder result,HashSet<Character> visited){
        if(visited.contains(letter)){
            result.setLength(0);
            result.append("loop");
            return;
        } 
        if(result.toString().indexOf(letter)!=-1) return;
        if(dependencies.containsKey(letter)){
            //I might depend on someone
            visited.add(letter);
            ArrayList<Character> dependents=dependencies.get(letter);
            for(Character dependent:dependents){
                processGraph(dependent,dependencies,result,visited);
                if(result.toString().equals("loop")) return;
            }
            visited.remove(letter);
            dependencies.remove(letter);
            result.append(letter);
        }else{//I don't depend on anyone, I can be added
            result.append(letter);
        }
    }
    
    public boolean compareWords(String word1,String word2,HashSet<Character> letters,HashMap<Character,ArrayList<Character>> dependencies){
        int len1=word1.length(),len2=word2.length();
        int cont1=0,cont2=0;
        for(;cont1<len1 && cont2<=len2;cont1++,cont2++){
            //abc
            //ab
            //its not valid, the first difference cant be null in second word
            if(cont2==len2) return false;
            char let1=word1.charAt(cont1);
            char let2=word2.charAt(cont2);
            letters.add(let1);
            letters.add(let2);
            if(let1!=let2){
                if(dependencies.containsKey(let2)){
                    ArrayList<Character> temp=dependencies.get(let2);
                    temp.add(let1);
                    dependencies.put(let2,temp);
                }else{
                    dependencies.put(let2,new ArrayList<Character>(Arrays.asList(let1)));
                }
                break;
            }
        }
        while(cont1<len1){
            letters.add(word1.charAt(cont1));
            cont1++;
            
        }
        while(cont2<len2){
            letters.add(word2.charAt(cont2));
            cont2++;
        }
        return true;
    }
}

        //Clean and simple recursive solution
        //By leetcode's yavinci plus fix by shiyanch
        //Amazing runtime of 1ms better than 100% O()
        //Bad memory better than only 10.81% O(1) (graph will always be 26*26)
        //Simply brilliant
class Solution {
    
    private final int N = 26;
    
    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        buildGraph(words, adj, visited);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(visited[i] == 0) {                 // unvisited
                if(!dfs(adj, visited, sb, i)) return "";
            }
        }
        return sb.reverse().toString();
    }

    public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;                            // 1 = visiting
        for(int j = 0; j < N; j++) {
            if(adj[i][j]) {                        // connected
                if(visited[j] == 1) return false;  // 1 => 1, cycle   
                if(visited[j] == 0) {              // 0 = unvisited
                    if(!dfs(adj, visited, sb, j)) return false;
                }
            }
        }
        visited[i] = 2;                           // 2 = visited
        sb.append((char) (i + 'a'));
        return true;
    }

    public void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);                 // -1 = not even existed
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) visited[c - 'a'] = 0;
            if(i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                if (!w1.equals(w2) && w1.startsWith(w2)) {//Fix starts
                    Arrays.fill(visited, 2);
                    return;
                }//Fix ends
                int len = Math.min(w1.length(), w2.length());
                for(int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if(c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }
}


        //Iterative solution
class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> adjMap = new HashMap<>();
        int[] inDegrees = new int[26];
        
        for (String word : words) 
            for (char c : word.toCharArray())
                if(!adjMap.containsKey(c))
                    adjMap.put(c, new ArrayList<>());
        
        
        for(int i=1; i<words.length; i++) {
            
            String cur = words[i];
            String prec = words[i-1];
            
            int j = 0;
            
            while(j<prec.length() && j<cur.length()) {
                if(prec.charAt(j)==cur.charAt(j)) 
                    j++;
                else {
                    adjMap.get(prec.charAt(j)).add(cur.charAt(j));
                    inDegrees[cur.charAt(j)-'a']++;
                    break;
                }                    
            }
            
            if(j==cur.length() && j<prec.length()) return "";
        }
        
        Queue<Character> q = new LinkedList<Character>(); 
        for (Character ch : adjMap.keySet()) 
        { 
            if(inDegrees[ch-'a']==0) 
                q.add(ch); 
        } 
        
        StringBuilder order = new StringBuilder();
        while(!q.isEmpty()) {
            char cur = q.poll();
            order.append(cur);
            
            for(Character nc : adjMap.get(cur)) {
                inDegrees[nc-'a']--;
                
                if(inDegrees[nc-'a']==0) {
                    q.add(nc);
                }
            }
        }
            
        if (order.length() != adjMap.keySet().size())
            return "";
        
        return order.toString(); 
    }
}