class Solution {
    public void solve(char[][] board) {
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O')dfs(board,i,0);
            if(board[i][board[0].length-1]=='O')dfs(board,i,board[0].length-1);
        }
        for(int j=1;j<board[0].length-1;j++){
            if(board[0][j]=='O')dfs(board,0,j);
            if(board[board.length-1][j]=='O')dfs(board,board.length-1,j);
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='S'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(char[][] board,int i,int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]=='X' || board[i][j]=='S'){
            return;
        }
        board[i][j]='S';
        dfs(board,i,j+1);
        dfs(board,i,j-1);
        dfs(board,i+1,j);
        dfs(board,i-1,j);
    }
}
