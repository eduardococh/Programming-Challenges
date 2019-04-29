import java.util.Scanner;

public class grid{
   public static void main(String arg[]){
       
        Scanner read=new Scanner(System.in);
        int nCases=read.nextInt();
        
        for(int i=0;i<nCases;i++){
            int persons=read.nextInt();
            int gridSize=read.nextInt();
            int grid[][]=new int[gridSize+1][gridSize+1];
            
            for(int j=0;j<persons;j++){
                int x=read.nextInt();
                int y=read.nextInt();
                char direction=read.next().charAt(0);
                
                switch(direction){
                  case 'N':
                     for(int k=0;k<=gridSize;k++){
                        for(int l=y+1;l<=gridSize;l++){
                           grid[k][l]++;
                        }
                     }
                  break;
                  case 'S':
                     for(int k=0;k<=gridSize;k++){
                        for(int l=y-1;l>=0;l--){
                           grid[k][l]++;
                        }
                     }
                  break;
                  case 'E':
                     for(int k=x+1;k<=gridSize;k++){
                        for(int l=0;l<=gridSize;l++){
                           grid[k][l]++;
                        }
                     }
                  break;
                  case 'W':
                     for(int k=x-1;k>=0;k--){
                        for(int l=0;l<=gridSize;l++){
                           grid[k][l]++;
                        }
                     }
                  break;                                                      
                }
            }
            int max=0;
            for(int k=0;k<=gridSize;k++){
               for(int l=0;l<=gridSize;l++){
                  if(grid[k][l]>max){
                     max=grid[k][l];
                  }
               }
            }
            outerloop:
            for(int k=0;k<=gridSize;k++){
               for(int l=0;l<=gridSize;l++){
                  if(grid[k][l]==max){
                     System.out.println("Case #"+(i+1)+": "+k+" "+l);
                     break outerloop;
                  }
               }
            }
        }
   }
}