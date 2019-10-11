
class Solution {
    public List<String> removeComments(String[] source) {
        final int len=source.length;
        List<String> result=new ArrayList<String>();
        boolean commentBlock=false;
        StringBuilder uncommented=new StringBuilder("");
        for(int i=0;i<len;i++){
            
            if(!commentBlock){
                uncommented=new StringBuilder("");
            }
            
            source[i]=source[i]; 
            int currLen=source[i].length();
            for(int j=0;j<currLen;j++){
                //System.out.print("exec "+j+" ");
                //System.out.println(source[i].charAt(j));
                
                if(commentBlock){
                    
                    //if star
                    if(source[i].charAt(j)=='*'){
                        //if it is end of comment
                        if(j+1<currLen && source[i].charAt(j+1)=='/'){
                            commentBlock=false;
                            j++;
                        }
                    }
                    
                }else{//Not on comment block
                    
                    //if slash 
                    if(source[i].charAt(j)=='/'){
                        //if double slash
                        if(j+1<currLen && source[i].charAt(j+1)=='/'){
                            break;
                        //if start of comment block
                        }else if(j+1<currLen && source[i].charAt(j+1)=='*'){
                            commentBlock=true;
                            j++;
                        }else{
                            uncommented.append(source[i].charAt(j));
                        }
                         
                    }else{
                        uncommented.append(source[i].charAt(j));
                    }
                    
                }
            }
            if(!commentBlock){
                if(uncommented.length()>0) result.add(uncommented.toString());    
            }
        }
        return result;
    }

}