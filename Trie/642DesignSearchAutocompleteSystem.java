        //Solution by leetcode
        //The only solution I'm convering for now since it is a complex algorithm
        //Bad runtime at 239ms better than only 28.68% 
        //Autocomplete() O(K*L) L sentences of length K
        //Input() O(P+Q+M*Log(M))
        //Good memory better than 86.96% 
        //My algorithm did the trie part great, the failure was to filter them to the final 3 results
        //This is because I used a hashMap to store results, and it could have worked, but it
        //added a lot of complexity, whereas using a custom object Node made the task easier here
        //Here lookup method returns ALL matches, we save them to a list
        //Then we sort that list using a 2 steps comparator, first we ask if A score is equal to B score
        //we sort them using sentence.compareTo(sentence), 
        //else we use b.times-a.times (this b-a order is important), if we reverse it then sorting is descending
        //Once the list is ordered in score and ASCII order we 
        //just loop for MIN(3 or list.size()) (3 or less iterations)
        //and return that
public class AutocompleteSystem {

    Trie root;
    String cur_sent = "";

    class Node {
        
        String sentence;
        int times;

        Node(String st, int t) {
            sentence = st;
            times = t;
        }
    }

    class Trie {
        int times;
        Trie[] branches = new Trie[27];
    }
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            insert(root, sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List < String > res = new ArrayList < > ();
        if (c == '#') { 
            insert(root, cur_sent, 1);
            cur_sent = "";
        } else {
            cur_sent += c;
            List < Node > list = lookup(root, cur_sent);
            //Custom comparator, if times are equal, solve by smaller ASCII code
            Collections.sort(list, (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
            for (int i = 0; i < Math.min(3, list.size()); i++)
                res.add(list.get(i).sentence);
        }
        return res;
    }

    public void insert(Trie t, String s, int times) {
        for (int i = 0; i < s.length(); i++) {
            if (t.branches[int_(s.charAt(i))] == null){
                t.branches[int_(s.charAt(i))] = new Trie();
            }
            t = t.branches[int_(s.charAt(i))];
        }
        t.times += times;
    }

    public int int_(char c) {
        return c == ' ' ? 26 : c - 'a';
    }

    //lookup get the trie to the base leaf of this sentence
    public List < Node > lookup(Trie t, String s) {
        List < Node > list = new ArrayList < > ();
        for (int i = 0; i < s.length(); i++) {
            if (t.branches[int_(s.charAt(i))] == null)
                return new ArrayList < Node > ();
            t = t.branches[int_(s.charAt(i))];
        }
        traverse(s, t, list);
        return list;
    }


    //traverse get's all matches
    public void traverse(String s, Trie t, List < Node > list) {
        //only if t is sentence end will it have times bigger than 0
        if (t.times > 0)
            list.add(new Node(s, t.times));
        for (char i = 'a'; i <= 'z'; i++) {
            if (t.branches[i - 'a'] != null)
                traverse(s + i, t.branches[i - 'a'], list);
        }
        //special case for space, a-z are treated in above loop 
        if (t.branches[26] != null)
            traverse(s + ' ', t.branches[26], list);
    }
}




        //My attempt at an approach DOES NOT WORK
        //Should work if more work is put into it
class AutocompleteSystem {
    
    class Trie{
        String sentence;
        int degree;
        Trie[] next;
        
        public Trie(){
            next=new Trie[255];
        }
        
    }
    
    Trie root=new Trie();
    StringBuilder currentSearch;

    public AutocompleteSystem(String[] sentences, int[] times) {
        int len=sentences.length;
        for(int i=0;i<len;i++){
            buildTrie(sentences[i],times[i]);
        }
        currentSearch=new StringBuilder("");
    }
    
    public List<String> input(char c) {
        HashMap<String,Integer> result=new HashMap<String,Integer>();
        if(c=='#'){
            buildTrie(currentSearch.toString(),-1);
            currentSearch.setLength(0);
            return new ArrayList<>(result.keySet());
        }
        currentSearch.append(c);
        //System.out.println("execution "+c);
        //System.out.println("currentSearch "+currentSearch);
        Trie searcher=root;
        int len=currentSearch.length();
        for(int i=0;i<len;i++){
            if(searcher.next[currentSearch.charAt(i)]==null){
                //System.out.println("break ");
                return new ArrayList<>(result.keySet());
            }else{
                //System.out.println("no break");
            }
            searcher=searcher.next[currentSearch.charAt(i)];
        }
        getCoincidences(searcher,result);
        if(result.size()>3){
            Comparator<Map.Entry<String, Integer>> sortByDegree = 
		        (Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2)->e1.getValue().compareTo(e2.getValue());
            
            PriorityQueue<Map.Entry<String, Integer>> pq=new PriorityQueue<Map.Entry<String, Integer>>(sortByDegree);
            
            for(Map.Entry<String,Integer> entry:result.entrySet()){
                pq.add(entry);
                if (pq.size() > 3){
                    System.out.println("remove "+pq.poll().getKey());
                }
            }
            List<String> final3=new ArrayList<String>();
            for(int i=0;i<3;i++){
                String temp=pq.poll().getKey();
                System.out.println(temp);
                final3.add(temp);
            }
        }
        return new ArrayList<>(result.keySet());
    }
    
    private void getCoincidences(Trie searcher,HashMap<String,Integer> result){
        if(searcher.sentence!=null){
            //System.out.println("we return "+searcher.sentence);
            result.put(searcher.sentence,searcher.degree);
        }
        for(int i=0;i<255;i++){
            if(searcher.next[i]!=null){
                //System.out.println("searching "+(char)i);
                getCoincidences(searcher.next[i],result);
            }
        }
    }
    
    private void buildTrie(String sentence,int degree){
        Trie builder=root;
        int stringIndex=0;
        int len=sentence.length();
        while(stringIndex<len){
            if(builder.next[sentence.charAt(stringIndex)]==null){
                builder.next[sentence.charAt(stringIndex)]=new Trie();
            }
            builder=builder.next[sentence.charAt(stringIndex)];
            stringIndex++;
        }
        if(degree==-1){
            if(builder.degree==0){
                builder.degree=1;
            }else{
                builder.degree++;
            }
        }
        builder.sentence=sentence;
    }
}