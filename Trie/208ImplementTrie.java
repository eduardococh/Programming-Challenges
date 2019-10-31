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
        //System.out.println("indesrint");
        int len=word.length();
        int index=0;
        Trie iterator=this;
        while(index<len && iterator.next[word.charAt(index)-'a']!=null){
            //System.out.println("advancing "+word.charAt(index));
            iterator=iterator.next[word.charAt(index)-'a'];
            index++;
        }
        while(index<len){
            //System.out.println("inserting "+word.charAt(index));
            iterator.next[word.charAt(index)-'a']=new Trie();
            iterator=iterator.next[word.charAt(index)-'a'];
            index++;
        } 
        iterator.endOfWord=true;
        //System.out.println("buye");
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        //System.out.println("searching");
        Trie iterator=this;
        int len=word.length();
        for(int i=0;i<len;i++){
            //System.out.println("going with "+word.charAt(i));
            if(iterator.next[word.charAt(i)-'a']==null){
                //System.out.println("there's no "+word.charAt(i));
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
        //System.out.println("prefixing");
        Trie iterator=this;
        int len=prefix.length();
        for(int i=0;i<len;i++){
            if(iterator.next[prefix.charAt(i)-'a']==null){
                return false;
            }
            //System.out.println("we advance to "+prefix.charAt(i));
            iterator=iterator.next[prefix.charAt(i)-'a'];
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