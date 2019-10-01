
public class AutocompleteSystem {

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

    public int int_(char c) {
        return c == ' ' ? 26 : c - 'a';
    }

    public void insert(Trie t, String s, int times) {
        for (int i = 0; i < s.length(); i++) {
            if (t.branches[int_(s.charAt(i))] == null)
                t.branches[int_(s.charAt(i))] = new Trie();
            t = t.branches[int_(s.charAt(i))];
        }
        t.times += times;
    }
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
    public void traverse(String s, Trie t, List < Node > list) {
        if (t.times > 0)
            list.add(new Node(s, t.times));
        for (char i = 'a'; i <= 'z'; i++) {
            if (t.branches[i - 'a'] != null)
                traverse(s + i, t.branches[i - 'a'], list);
        }
        if (t.branches[26] != null)
            traverse(s + ' ', t.branches[26], list);
    }
    Trie root;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            insert(root, sentences[i], times[i]);
        }
    }
    String cur_sent = "";
    public List < String > input(char c) {
        List < String > res = new ArrayList < > ();
        if (c == '#') { 
            insert(root, cur_sent, 1);
            cur_sent = "";
        } else {
            cur_sent += c;
            List < Node > list = lookup(root, cur_sent);
            Collections.sort(list, (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
            for (int i = 0; i < Math.min(3, list.size()); i++)
                res.add(list.get(i).sentence);
        }
        return res;
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