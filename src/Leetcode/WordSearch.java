package Leetcode;

public class WordSearch {

    public static void main(String[] args) {
        char[][] arr= {{'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}};

        String test="ABCCED";
        boolean result=searchWord(arr,test);
        System.out.println(result);
    }

    private static boolean searchWord(char[][] arr, String test) {
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==test.charAt(0) && dfs(i,j,arr,0,test))
                    return true;
            }
        }
        return false;
    }

    private static boolean dfs(int i, int j, char[][] arr, int count, String test) {
        if(count==test.length())
            return true;
        if(i<0 || j<0|| i>=arr.length|| j>=arr[0].length || test.charAt(count)!=arr[i][j])
            return false;
        char temp=arr[i][j];
        arr[i][j]=' ';
        boolean found=
                dfs(i,j-1,arr,count+1,test) ||
                dfs(i,j+1,arr,count+1,test)   ||
                dfs(i-1,j,arr,count+1,test) ||
                dfs(i+1,j,arr,count+1,test);

        arr[i][j]=temp;
        return found;
    }
}
