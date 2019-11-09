        //My solution (brute force backtracking?)
        //we go dfs into the matrix and look for our word
        //I doubted this approach but best time solution uses it, so it is good
        //Bad runtime at 165ms better than only 26.87% O((C^2)*S) where S is number of words
        //and C is the number of cells in the array
        //Worse case scenario, a 10*10 pure a's matrix with 100 101 lenght pure a's words
        //Good memory at 37.3mb better than 100% O(l) where L is the words max lenght
        //I guess it's "working" but probably an interviewer will want something better
class Solution {
    
    int width;
    int height;
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result=new ArrayList<String>();
        width=board.length;
        height=board[0].length;
        int numW=words.length;
        for(int i=0;i<width;i++){
            for(int j=0;j<height;j++){
                for(int k=0;k<numW;k++){
                    if(words[k]!=null && words[k].charAt(0)==board[i][j]){
                        char restore=board[i][j];
                        board[i][j]='0';
                        if(containsWord(board,words[k],1,i,j)){
                            result.add(words[k]);
                            words[k]=null;
                        }
                        board[i][j]=restore;
                    }
                }
            }
        }
        return result;
    }
    
    public boolean containsWord(char[][] board,String candidate,int index,int i,int j){
        if(index==candidate.length()) return true;
        if(i-1>=0 && board[i-1][j]==candidate.charAt(index)){
            char restore=board[i-1][j];
            board[i-1][j]='0';
            if(containsWord(board,candidate,index+1,i-1,j)){
                board[i-1][j]=restore;
                return true;   
            }
            board[i-1][j]=restore;
        }
        if(j-1>=0 && board[i][j-1]==candidate.charAt(index)){
            char restore=board[i][j-1];
            board[i][j-1]='0';
            if(containsWord(board,candidate,index+1,i,j-1)){
                board[i][j-1]=restore;
                return true;
            }
            board[i][j-1]=restore;
        }
        if(i+1<width && board[i+1][j]==candidate.charAt(index)){
            char restore=board[i+1][j];
            board[i+1][j]='0';
            if(containsWord(board,candidate,index+1,i+1,j)){
                board[i+1][j]=restore;
                return true;    
            } 
            board[i+1][j]=restore;
        }
        if(j+1<height && board[i][j+1]==candidate.charAt(index)){
            char restore=board[i][j+1];
            board[i][j+1]='0';
            if(containsWord(board,candidate,index+1,i,j+1)){
                board[i][j+1]=restore;
                return true;
            }
            board[i][j+1]=restore;
        }
        return false;
    }
}


        //From leetcode's 7ms sample
        //Usage of a trie, a fast but memory intensive data structure
        //Where we build words in a trie
        //Amazing runtime of 7ms better than 100% O(M(4*3^(L-1))) => (M^(L-1)) removing constants
        //Every M cell will start their search with 4 possibilities, the next steps
        //will have at most 3 possibilities (can not go back to previous) and this
        //will be repeated for L-1 cells
        //Good memory at 44.3mb better than 77.78% O(L^26) since every node in our tree
        //could have 26 children (english alphabet) for the lenght of the longest word
        //Leetcode's article solution is supposed to have optimizations, but it does not
        //show since their runtime is 26 ms, this one is plain not optimized and has a better 
        //runtime, that's maybe because of short test cases
        //Worth looking into leetcode's solution for trie optimizations
class Solution {

    class Trie {
        String word;
        Trie[] next;
        Trie() {
            next = new Trie[26];
        }
    }
    
    Trie root = new Trie();   

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        if(board==null || board.length==0 || board[0].length==0) return result;
             
        for(String word: words) {
            buildTrie(word);            
        }
        
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                dfs(board,i,j,root, result);
            }
        }
        return result;
    }
    
    private void buildTrie(String word) {
        Trie node = root;
        for(char c: word.toCharArray()){
            if(node.next[c-'a']==null){
                node.next[c-'a'] = new Trie();                
            }
            node = node.next[c-'a']; 
        }
        node.word = word;
    }
    
    private void dfs(char[][] board, int i, int j, Trie node,  List<String> result){
        
        //4 checks for i and j in upper and lower bound
        if(i<0  ||  j<0  ||  i>=board.length  ||  j>=board[0].length 
        //check if this position has been visited or if the next char is not on trie (word does not exist)
                ||  board[i][j]=='#'  ||  node.next[board[i][j]-'a']==null ) return;
        
        char c = board[i][j];
        node = node.next[c-'a'];
        if(node.word != null) {
            result.add(node.word);
            //avoid duplicate words
            node.word = null;
        }

        board[i][j]='#';     
        dfs(board, i-1,j,node, result);
        dfs(board, i+1,j, node, result);
        dfs(board, i,j-1, node, result);
        dfs(board, i,j+1, node, result);
        board[i][j]=c;        
    }
}


        //My second try at this problem
        //It is an amazing solution in all BUT a terribly simple mistake that I had
        //Amazing runtime 9ms better than 98.91% //WRONG  O(M*N*L) M and N are rows and columns and
                                                //Correct O(M*N^L-1)
        //L is the length of the longest word
        //Bad memory better than only  17.78%
class Solution {
    
    private class Trie{
        Trie letters[];
        String word;
        
        public Trie(){
            letters=new Trie[26];
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res=new ArrayList<String>();
        if(board==null || board.length==0 || board[0].length==0) return res;
        Trie myTrie=new Trie();
        for(String word:words){
            addToTrie(myTrie,word);
        }
        int rows=board.length;
        int columns=board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                processChar(i,j,res,myTrie,board);
            }
        }
        return res;
    }
    
    public void processChar(int i,int j,List<String> res,Trie myTrie,char[][] board){
        char car=board[i][j];
        if(car==' ') return;
        //SHOULD HAVE USED THIS VARIABLE
        //Trie next=myTrie.letters[car-'a'] and here use next instead of trie.letters
        if(myTrie.letters[car-'a']!=null){
            //here was MY stupid mistake, I was comparing to current trie instead of next trie
            //this mistake was due to bad design, i should not have 'current' and 'next' trie
            //only current trie, having those two favored confusion
            //if(myTrie.word!=null && !res.contains(myTrie.word)){
            
            //this is the correct implementation using the 'next' trie
            if(myTrie.letters[car-'a'].word!=null && !res.contains(myTrie.letters[car-'a'].word)){
                res.add(myTrie.letters[car-'a'].word);
            }
            board[i][j]=' ';
            if(i-1>=0){
                processChar(i-1,j,res,myTrie.letters[car-'a'],board);
            }
            if(j-1>=0){
                processChar(i,j-1,res,myTrie.letters[car-'a'],board);
            }
            if(i+1<board.length){
                processChar(i+1,j,res,myTrie.letters[car-'a'],board);
            }
            if(j+1<board[0].length){
                processChar(i,j+1,res,myTrie.letters[car-'a'],board);
            }
            board[i][j]=car;
        }
    }
    
    public void addToTrie(Trie myTrie,String word){
        int len=word.length();
        Trie iterator=myTrie;
        for(int i=0;i<len;i++){
            if(iterator.letters[word.charAt(i)-'a']==null){
                iterator.letters[word.charAt(i)-'a']=new Trie();    
            }
            iterator=iterator.letters[word.charAt(i)-'a'];
        }
        iterator.word=word;
    }
}