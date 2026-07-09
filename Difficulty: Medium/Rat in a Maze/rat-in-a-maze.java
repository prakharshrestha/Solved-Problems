class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> ans=new ArrayList<>();
        
        int n=maze.length;
        int[][] vis = new int[n][n];
        String curr="";
        
        if(maze[0][0]==0 || maze[n-1][n-1]==0 )
        return ans;
        
        solve(0,0,maze,vis,ans,curr);
        return ans;
        


    }
    public void solve(int i,int j,int[][] maze,int[][] vis,ArrayList<String> ans,String curr){
        
      int n=maze.length;
    
      if(i ==n-1 && j==n-1 ){
          ans.add(curr);
          return;
      }
        
      vis[i][j]=1;
      
      // Down
        if (i + 1 < n && maze[i + 1][j] == 1 && vis[i + 1][j] == 0) 
            solve(i + 1, j, maze, vis, ans, curr + "D");
        

        // Left
        if (j - 1 >= 0 && maze[i][j - 1] == 1 && vis[i][j - 1] == 0) 
            solve(i, j - 1, maze, vis, ans, curr + "L");
        

        // Right
        if (j + 1 < n && maze[i][j + 1] == 1 && vis[i][j + 1] == 0) 
            solve(i, j + 1, maze, vis, ans, curr + "R");
        

        // Up
        if (i - 1 >= 0 && maze[i - 1][j] == 1 && vis[i - 1][j] == 0) 
            solve(i - 1, j, maze, vis, ans, curr + "U");
        
            
      vis[i][j]=0;
        
    }
}