        //DFS Solution by FLAGBigoffer, with very small change from me
        //Elegant and simple solution
        //Good runtime of 41ms better than 46.96% O(SUM(A) Log (A)) where a it the number of emails in every account
        //Bad memory better than only 26.47% O(SUM(A)) 
        //NOTE: Please note that when creating the graph he is not making a complete graph, he only links an email with 
        //the one before and after, since that's the only thing we really need, that gives us access to all nodes
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();  //<email node, neighbor nodes>
        Map<String, String> name = new HashMap<>();        //<email, username>
        // Build the graph;
        for (List<String> account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                    name.put(account.get(i), userName);
                }
                
                if (i == 1) continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }
        
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new LinkedList<>();
        // DFS search the graph;
        for (String email : name.keySet()) {//iterate by the different emails (every email has only one node)
            List<String> list = new LinkedList<>();
            if (visited.add(email)) {//if I have not visited this node (this email)
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                res.add(list);
            }
        }
        
        return res;
    }
    
    public void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        list.add(email);
        for (String next : graph.get(email)) {
            if (visited.add(next)) {
                dfs(graph, next, visited, list);
            }
        }
    }
}


        //My solution using a brute force approach
        //I use the initial list to do all processing
        //Initially didn't think handling it this way would have such a terrible runtime
        //Terrible runtime of 205ms better than only 6.63%% O(N^2)
        //Terrible memory
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int currentIndex=0;
        while(currentIndex<accounts.size()){
            
            Set<String> emailSet=new HashSet<>();
            List<String> currentAccount=accounts.get(currentIndex);
            for(int i=1;i<currentAccount.size();i++){
                if(!emailSet.add(currentAccount.get(i))){
                    currentAccount.remove(i);
                    i--;
                }
            }
            int mergerIndex=0;
            
            while(mergerIndex<accounts.size()){
                if(mergerIndex==currentIndex) {
                    mergerIndex++;
                    continue;
                }
                if(accounts.get(mergerIndex).get(0).equals(currentAccount.get(0))){//if both accounts have the same name       
                    List<String> target=accounts.get(mergerIndex);
                    String currentName=target.get(0);
                    target.remove(0);
                    boolean same=false;
                    for(String email:target){
                        if(emailSet.contains(email)){//they're the same email
                            same=true;
                            break;
                        }
                    }
                    if(same){
                        for(String email:target){//add all non repeating emails
                            if(!emailSet.contains(email)){
                                currentAccount.add(email);
                                emailSet.add(email);
                            }
                        }
                        accounts.remove(mergerIndex);
                        mergerIndex=-1;//since we're deleting current email
                    }else{
                        target.add(0,currentName);
                    }
                }
                mergerIndex++;
            }
            currentIndex++;
        }
        currentIndex=0;
        for(List<String> account:accounts){
            String name=account.get(0);
            account.remove(0);
            Collections.sort(account);
            account.add(0,name);
        }
        return accounts;
    }
}


        //Not a working solution, kept for personal reference
        //My solution using a graph and BFS approach
        //Time limit exceeded, but working on 48/49 cases
        //Usage of a graph that creates a node for every initial entry
        //links nodes by the similar emails, first issue with this is that it would create repeated
        //edges between two accounts if they had two or more emails in common, and runtime would have an exponential
        //complexity, once i removed it (fix in comments) the next issue is that it visited nodes more than once 
        //because I was removing them from "visited", as a lot of dfs algorithms do, but this frankenstein is not usual
        //will try to improve later hopefully
class Solution {
    
    class Account{
        String name;
        HashSet<String> emails;
        ArrayList<Account> related;
        
        public Account(){
            name="";
            emails=new HashSet<>();
            related=new ArrayList<>();
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //return null;
        List<Account> graph=generateGraph(accounts);
        List<List<String>> result=new ArrayList<List<String>>();
        for(int i=0;i<graph.size();i++){
            Account processed=processAccount(graph.get(i),new HashSet<Account>(),graph);
            //add to result
            ArrayList<String> emails=new ArrayList<>();
            for(String email:processed.emails){
                emails.add(email);
            }
            Collections.sort(emails);
            emails.add(0,processed.name);
            result.add(emails);
        }
        return result;
    }
    
    public Account processAccount(Account node,HashSet<Account> visited,List<Account> graph){
        if(visited.contains(node)) return null;
        visited.add(node);
        for(Account neighbor:node.related){
            Account processed=processAccount(neighbor,visited,graph);
            if(processed==null) continue;
            for(String email:processed.emails){
                if(!node.emails.contains(email)){
                    node.emails.add(email);//add all processed neighbor emails not already here
                }
            }
            graph.remove(processed);
        }
        return node;
    }
    
    public List<Account> generateGraph(List<List<String>> accounts){
        List<Account> graph=new ArrayList<>();
        for(List<String> account:accounts){
            Account newAcc=new Account();
            newAcc.name=account.get(0);
            for(int i=1;i<account.size();i++){//add all emails to hashset
                newAcc.emails.add(account.get(i));
            }
            for(Account node:graph){
                for(String email:newAcc.emails){
                                                 /*&& !newAcc.related.contains(node) fix to avoid more than one edge*/ 
                    if(node.emails.contains(email) && !newAcc.related.contains(node)){//if they have same email
                        newAcc.related.add(node);
                        node.related.add(newAcc);
                    }
                }
            }
            graph.add(newAcc);
        }
        return graph;
    }
}