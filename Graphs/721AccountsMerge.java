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