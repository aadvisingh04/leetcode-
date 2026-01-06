class Solution {

    int n, m;

    public void solve(char[][] board) {

        // Edge case
        if (board == null || board.length == 0) return;

        n = board.length;
        m = board[0].length;

        // Step 1: Run DFS from boundary 'O's
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') dfs(0, j, board);
            if (board[n - 1][j] == 'O') dfs(n - 1, j, board);
        }

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board);
            if (board[i][m - 1] == 'O') dfs(i, m - 1, board);
        }

        // Step 2: Convert remaining O -> X and # -> O
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';   // surrounded
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';   // safe
                }
            }
        }
    }

    // DFS to mark boundary-connected O's
    private void dfs(int row, int col, char[][] board) {

        // Boundary + visited check
        if (row < 0 || col < 0 || row >= n || col >= m || board[row][col] != 'O') {
            return;
        }

        // Mark as safe
        board[row][col] = '#';

        // Explore 4 directions
        dfs(row - 1, col, board); // up
        dfs(row + 1, col, board); // down
        dfs(row, col - 1, board); // left
        dfs(row, col + 1, board); // right
    }
}
