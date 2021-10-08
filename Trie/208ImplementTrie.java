        //My solution
        //Good runtime 75ms better than 81.31% 
        //Runtimes vary for every function
        //Memory better than 100%
class Trie {
    
    Trie next[];
    boolean endOfWord;

    /** Initialize your data structure here. */
    public Trie() {
        this.next=new Trie[26];
        endOfWord=false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len=word.length();
        int index=0;
        Trie iterator=this;
        while(index<len && iterator.next[word.charAt(index)-'a']!=null){
            iterator=iterator.next[word.charAt(index)-'a'];
            index++;
        }
        while(index<len){
            iterator.next[word.charAt(index)-'a']=new Trie();
            iterator=iterator.next[word.charAt(index)-'a'];
            index++;
        } 
        iterator.endOfWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie iterator=this;
        int len=word.length();
        for(int i=0;i<len;i++){
            if(iterator.next[word.charAt(i)-'a']==null){
                return false;
            }
            iterator=iterator.next[word.charAt(i)-'a'];
        }
        if(iterator.endOfWord){
            return true;
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie iterator=this;
        int len=prefix.length();
        for(int i=0;i<len;i++){
            if(iterator.next[prefix.charAt(i)-'a']==null){
                return false;
            }
            iterator=iterator.next[prefix.charAt(i)-'a'];
        }
        return true;
    }
}

 class Trie {
    Trie[] next = new Trie[26];
    String word;
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    //My terrible insertion first searches and then creates,
    //when it can be done like here with an if inside the loop
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word==null) return;
        Trie curr = this;
        for(char c:word.toCharArray()){
            if(curr.next[c-'a']==null){
                curr.next[c-'a'] = new Trie();
            }
            curr = curr.next[c-'a'];
        }
        curr.word = word;
    }
    
    //My solution is like this, a few more lines but same process
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = this;
        for(char c: word.toCharArray()){
            if(curr.next[c-'a']==null) return false;
            curr= curr.next[c-'a'];
        }
        return curr.word!=null;
    }
    
    //Same as my code almost, few more line in my code
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = this;
        for(char c: prefix.toCharArray()){
            if(curr.next[c-'a']==null) return false;
            curr = curr.next[c-'a'];
        }
        return true;
    }
}


//Second attempt
//Done very quickly and easily, big improvement over first attempt 
class Trie {
    
    private Trie[] next;
    private String endOfWord;
    
    public Trie() {
        next=new Trie[26];
        endOfWord="";
    }
    
    public void insert(String word) {
        Trie iterator=this;
        for(char car:word.toCharArray()){
            if(iterator.next[car-'a']==null){
                iterator.next[car-'a']=new Trie();    
            }
            iterator=iterator.next[car-'a'];
        }
        iterator.endOfWord=word;
    }
    
    public boolean search(String word) {
        Trie iterator=this;
        for(char car:word.toCharArray()){
            if(iterator.next[car-'a']==null){
                return false;
            }
            iterator=iterator.next[car-'a'];
        }
        if(iterator.endOfWord.equals(word)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean startsWith(String prefix) {
        Trie iterator=this;
        for(char car:prefix.toCharArray()){
            if(iterator.next[car-'a']==null){
                return false;
            }
            iterator=iterator.next[car-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */