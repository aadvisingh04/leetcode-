class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int start = image[sr][sc];
        if(start != color){
            dfs(image,sr,sc,start,color);
        }
        return image;

        
    }
    private void dfs(int[][] image, int sr, int sc,int start, int color){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != start){
            return;
        }

        image[sr][sc] = color;
        dfs(image,sr+1,sc,start,color);
        dfs(image,sr,sc+1,start,color);
        dfs(image,sr-1,sc,start,color);
        dfs(image,sr,sc-1,start,color);
    }
}