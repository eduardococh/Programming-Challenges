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

class Solution {
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
        
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]=='#'||node.next[board[i][j]-'a']==null) return;
        char c = board[i][j];
        node = node.next[c-'a'];
        if(node.word != null) {
            result.add(node.word);
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

class Trie {
    String word;
    Trie[] next;
    Trie() {
        next = new Trie[26];
    }
}

        //Leetcode's solution
        //FORGET IT, use the sample 7ms, improved performance and less lines of code (80 here vs 50 there)
        //Using a trie
        //Average runtime of 26ms better than 47.47% O(M(4*3^L−1))
        //Where M is number of cells and L is maximum length of words
        //Average memory better than 62.22% O(N)
class TrieNode {
  HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  String word = null;
  public TrieNode() {}
}

class Solution {
  char[][] _board = null;
  ArrayList<String> _result = new ArrayList<String>();

  public List<String> findWords(char[][] board, String[] words) {

    // Step 1). Construct the Trie
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode node = root;

      for (Character letter : word.toCharArray()) {
        if (node.children.containsKey(letter)) {
          node = node.children.get(letter);
        } else {
          TrieNode newNode = new TrieNode();
          node.children.put(letter, newNode);
          node = newNode;
        }
      }
      node.word = word;  // store words in Trie
    }

    this._board = board;
    // Step 2). Backtracking starting for each cell in the board
    for (int row = 0; row < board.length; ++row) {
      for (int col = 0; col < board[row].length; ++col) {
        if (root.children.containsKey(board[row][col])) {
          backtracking(row, col, root);
        }
      }
    }

    return this._result;
  }
  
  private void backtracking(int row, int col, TrieNode parent) {
    Character letter = this._board[row][col];
    TrieNode currNode = parent.children.get(letter);

    // check if there is any match
    if (currNode.word != null) {
      this._result.add(currNode.word);
      currNode.word = null;
    }

    // mark the current letter before the EXPLORATION
    this._board[row][col] = '#';

    // explore neighbor cells in around-clock directions: up, right, down, left
    int[] rowOffset = {-1, 0, 1, 0};
    int[] colOffset = {0, 1, 0, -1};
    for (int i = 0; i < 4; ++i) {
      int newRow = row + rowOffset[i];
      int newCol = col + colOffset[i];
      if (newRow < 0 || newRow >= this._board.length || newCol < 0
          || newCol >= this._board[0].length) {
        continue;
      }
      if (currNode.children.containsKey(this._board[newRow][newCol])) {
        backtracking(newRow, newCol, currNode);
      }
    }

    // End of EXPLORATION, restore the original letter in the board.
    this._board[row][col] = letter;

    // Optimization: incrementally remove the leaf nodes
    if (currNode.children.isEmpty()) {
      parent.children.remove(letter);
    }
  }
}