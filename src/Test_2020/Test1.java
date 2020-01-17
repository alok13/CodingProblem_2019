package  Test_2020;
import java.util.*;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Test1
{

    public static void main(){

    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumHours(int rows, int columns, List<List<Integer> > grid)
    {
        //Edge cases
        if(grid==null || grid.size()==0)
            return 0;

        // Convert to 2D array
        int[][] arrayGrid=new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arrayGrid[i][j]=grid.get(i).get(j);
            }
        }

        Queue<Node> serverQueue=new LinkedList<>();
        int count=0;
        int notReceived=0;

        int[][] validDirections ={{0,1},{1,0},{-1,0},{0,-1}};

        // 1 represent recieved
        // 0 represents yet to be
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(arrayGrid[i][j]==1){
                    serverQueue.add(new Node(i,j));
                }else{
                    notReceived++;
                }
            }
        }
        while(!serverQueue.isEmpty()){
            int queueSize=serverQueue.size();
            if(notReceived==0)
                return count;
            for(int i=0;i<queueSize;i++){
                Node currentServer=serverQueue.poll();
                int X=currentServer.x;
                int Y=currentServer.y;
                for(int [] direction: validDirections){
                    int new_X=X + direction[0];
                    int new_Y=Y + direction[1];

                    if(new_X<0 || new_Y<0|| new_X>=arrayGrid.length || new_Y>=arrayGrid[0].length || arrayGrid[new_X][new_Y]==0 )
                        continue;
                    arrayGrid[new_X][new_Y]=1;
                    serverQueue.add(new Node(new_X,new_Y));
                    notReceived--;
                }
            }
            //One level of serach ends here
            count++;
        }
        return -1;
    }
    // METHOD SIGNATURE ENDS
}// class ends here


class Node{
    int x;
    int y;

    public Node(int x, int y){
        this.x=x;
        this.y=y;
    }
}
