class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int components = n;

        int E = edges.length;
        int[] head = new int[100005];
        int[] next_e = new int[E];
        java.util.Arrays.fill(head, -1);

        int sMax = 0, sMin = 100005;
        int score = Integer.MAX_VALUE;

        for (int i = 0; i < E; i++) {
            int u = edges[i][0], v = edges[i][1], s = edges[i][2], must = edges[i][3];
            if (must == 1) {
                if (!union(parent, rank, u, v)) return -1;
                components--;
                if (s < score) score = s;
            } else {
                if (s > sMax) sMax = s;
                if (s < sMin) sMin = s;
                next_e[i] = head[s];
                head[s] = i;
            }
        }

        if (components == 1) return score == Integer.MAX_VALUE ? -1 : score;

        int used = 0, needed = components - 1;
        int minX2 = Integer.MAX_VALUE, minX1 = Integer.MAX_VALUE;

        for (int s = sMax; s >= sMin; s--) {
            for (int i = head[s]; i != -1; i = next_e[i]) {
                if (!union(parent, rank, edges[i][0], edges[i][1])) continue;
                used++;
                
                if (used == needed - k) minX1 = s;
                if (used == needed) {
                    minX2 = s * 2;
                    break;
                }
            }
            if (used == needed) break;
        }

        if (components - used > 1) return -1;

        int opt_score = minX2;
        if (needed > k && minX1 < opt_score) opt_score = minX1;

        return Math.min(score, opt_score) == Integer.MAX_VALUE ? -1 : Math.min(score, opt_score);
    }

    private int find(int[] parent, int i) {
        int root = i;
        while (root != parent[root]) root = parent[root];
        int curr = i;
        while (curr != root) {
            int nxt = parent[curr];
            parent[curr] = root;
            curr = nxt;
        }
        return root;
    }

    private boolean union(int[] parent, int[] rank, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI == rootJ) return false;
        
        if (rank[rootI] < rank[rootJ]) {
            parent[rootI] = rootJ;
        } else {
            parent[rootJ] = rootI;
            if (rank[rootI] == rank[rootJ]) rank[rootI]++;
        }
        return true;
    }
}