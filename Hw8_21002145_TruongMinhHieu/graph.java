package Hw8_21002145_TruongMinhHieu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

@SuppressWarnings("unchecked")
public class graph {



    // 1. Print adjacency list
    public ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V); 
        // Initialize the output list with each vertex as its own neighbor.
        for (int k = 0; k < V; k++) {
            ArrayList<Integer> neighbors = new ArrayList<>();
            neighbors.add(k);
            graph.add(neighbors);
        }
        // Add the neighbors of each vertex to its adjacency list.
        for (int i = 0; i < V; i++) {
            for (int p : adj.get(i)) {
                graph.get(i).add(p);
            }
        } 
        return graph;
    }



    // 2. Clone Graph
    class Node {
        int val;
        ArrayList<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Create a hashmap to keep track of visited nodes and their clones
        HashMap<Node, Node> visited = new HashMap<>();

        // Use DFS to traverse the original graph and clone each node
        return cloneGraphDFS(node, visited);
    }

    private Node cloneGraphDFS(Node node, HashMap<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // create a new clone node and add it to the hashmap
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        // Recursively clone the neighbors of the current node
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraphDFS(neighbor, visited));
        }

        return cloneNode;
    }



    // 3. DFS of Graph
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>(); // store the DFS traversal
        boolean[] visited = new boolean[V]; // mark the visited vertices
        dfsUtil(0, adj, visited, dfs); // start the DFS traversal from the 0th vertex
        return dfs;
    }



    // 4. BFS of Graph
    private void dfsUtil(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs) {
        visited[v] = true; // mark the current vertex as visited
        dfs.add(v); // add the current vertex to the DFS traversal list
        for (int i = 0; i < adj.get(v).size(); i++) {
            int neighbor = adj.get(v).get(i);
            if (!visited[neighbor]) { // recursively traverse unvisited neighbors
                dfsUtil(neighbor, adj, visited, dfs);
            }
        }
    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Initialize an array to keep track of visited nodes
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // Initialize a queue to perform BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        // Initialize a list to store the BFS traversal
        ArrayList<Integer> bfsTraversal = new ArrayList<>();

        // Perform BFS until the queue is empty
        while (!queue.isEmpty()) {
            // Get the front node from the queue and add it to the BFS traversal
            int node = queue.poll();
            bfsTraversal.add(node);

            // Get the neighbors of the current node and add them to the queue
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return bfsTraversal;
    }



    // 5. Detect cycle in an undirected graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Create a boolean array to keep track of visited nodes
        boolean[] visited = new boolean[V];

        // Iterate over all vertices
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycleUtil(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Utility function to check for cycle using DFS
    public boolean isCycleUtil(int v, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;

        // Iterate over all adjacent vertices
        for (int i = 0; i < adj.get(v).size(); i++) {
            int adjVertex = adj.get(v).get(i);
            // If the adjacent vertex is not visited, recursively check for cycle
            if (!visited[adjVertex]) {
                if (isCycleUtil(adjVertex, v, visited, adj)) {
                    return true;
                }
            } else if (adjVertex != parent) {
                return true;
            }
        }
        return false;
    }



    // 6. Detect cycle in a directed graph
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V]; // keep track of visited nodes
        boolean[] recStack = new boolean[V]; // keep track of nodes in the recursion stack

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, recStack, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    // utility function for DFS traversal
    private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true; // mark the current node as visited
        recStack[v] = true; // add the current node to the recursion stack

        // recursively check all the neighbors of the current node
        for (int i = 0; i < adj.get(v).size(); i++) {
            int neighbor = adj.get(v).get(i);

            if (!visited[neighbor]) {
                if (isCyclicUtil(neighbor, visited, recStack, adj)) {
                    return true; // if cycle found, return true
                }
            } else if (recStack[neighbor]) {
                return true;
            }
        }

        recStack[v] = false;
        return false;
    }



    // 7. Find the number of islands
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j + 1);
        dfs(grid, i - 1, j - 1);
        dfs(grid, i + 1, j - 1);
        dfs(grid, i - 1, j + 1);
    }



    // 8. Unit Area of largest region of 1’s
    public int findMaxArea(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Iterate through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If find 1, do DFS to find the size of the region
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, rows, cols);
                    // Update maxArea if necessary
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }

        return maxArea;
    }

    // Helper function to do a depth-first search of the grid
    private int dfs(int[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0) {
            return 0;
        }

        // Mark the cell as visited
        grid[i][j] = 0;

        // Recursively search in 8 directions
        int area = 1;
        area += dfs(grid, i + 1, j, rows, cols); // down
        area += dfs(grid, i - 1, j, rows, cols); // up
        area += dfs(grid, i, j + 1, rows, cols); // right
        area += dfs(grid, i, j - 1, rows, cols); // left
        area += dfs(grid, i + 1, j + 1, rows, cols); // down-right
        area += dfs(grid, i - 1, j - 1, rows, cols); // up-left
        area += dfs(grid, i + 1, j - 1, rows, cols); // down-left
        area += dfs(grid, i - 1, j + 1, rows, cols); // up-right

        return area;
    }



    // 9. Distance of nearest cell having 1
    public int[][] nearest(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] res = new int[rows][cols];

        // Initialize all distances to max value.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }

        // Perform a BFS from each 1 to update the distances of its neighbors.
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[] { i, j });
                    res[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            // Check all neighbors of the current cell.
            for (int[] dir : dirs) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];

                // If the neighbor hasn't been visited, update its distance and add to the
                // queue.
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && res[newRow][newCol] > res[currRow][currCol] + 1) {
                    res[newRow][newCol] = res[currRow][currCol] + 1;
                    q.offer(new int[] { newRow, newCol });
                }
            }
        }

        return res;
    }



    // 10. Bipartite Graph
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] colors = new int[V];
        Arrays.fill(colors, -1);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (colors[i] == -1) {
                queue.add(i);
                colors[i] = 0;

                while (!queue.isEmpty()) {
                    int u = queue.poll();

                    for (int v : adj.get(u)) {
                        if (colors[v] == -1) {
                            colors[v] = 1 - colors[u];
                            queue.add(v);
                        } else if (colors[v] == colors[u]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }



    // 11. Find whether path exist
    public boolean is_Possible(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[] start = null, end = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    start = new int[] { i, j };
                } else if (grid[i][j] == 2) {
                    end = new int[] { i, j };
                }
            }
        }
        if (start == null || end == null) {
            return false;
        }
        return dfs(grid, visited, start[0], start[1], end[0], end[1]);
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int i, int j, int endI, int endJ) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
            return false;
        }
        if (i == endI && j == endJ) {
            return true;
        }
        visited[i][j] = true;
        if (dfs(grid, visited, i - 1, j, endI, endJ) ||
                dfs(grid, visited, i + 1, j, endI, endJ) ||
                dfs(grid, visited, i, j - 1, endI, endJ) ||
                dfs(grid, visited, i, j + 1, endI, endJ)) {
            return true;
        }
        return false;
    }



    // 12. Flood fill Algorithm
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        dfs_sec(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void dfs_sec(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor) {
            return;
        }
        image[r][c] = newColor;
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
    }



    // 13. Level of Nodes
    public int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        int[] level = new int[V];

        // Mark source node as visited and add it to the queue
        visited[0] = true;
        queue.add(0);
        level[0] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    level[neighbor] = level[curr] + 1;
                }
            }
        }

        // Return the level of node X, or -1 if it doesn't exist
        return (X >= 0 && X < V) ? level[X] : -1;
    }



    // 14. Word Ladder I
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        // create a set of words in the word list for O(1) lookup
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));

        // if target word is not in the word list, return 0
        if (!wordSet.contains(targetWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(startWord);
        wordSet.remove(startWord);

        // initialize distance to 1 since start word is already in the queue
        int distance = 1;

        while (!queue.isEmpty()) {
            // process words in the queue at the current distance level
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String currWord = queue.poll();

                // check if currWord can be transformed into targetWord
                if (currWord.equals(targetWord)) {
                    return distance;
                }

                // generate all possible next words with one letter difference
                char[] charArray = currWord.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    char originalChar = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        String nextWord = new String(charArray);
                        if (wordSet.contains(nextWord)) {
                            queue.offer(nextWord);
                            wordSet.remove(nextWord);
                        }
                    }
                    charArray[j] = originalChar;
                }
            }
            distance++;
        }
        return 0;
    }



    // 15. Euler Circuit in an Undirected Graph
    public boolean isEulerCircuitExist(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] degree = new int[V];

        // Calculate the degree of each vertex by counting the number of edges
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                degree[i]++;
                degree[j]++;
            }
        }

        // Check that every vertex has an even degree
        for (int d : degree) {
            if (d % 2 != 0) {
                return false;
            }
        }
        return true;
    }



    // 16. Possible Path
    public int isPossible(int[][] paths) {
        int n = paths.length;
        boolean[] visited = new boolean[n];
        int start = -1;

        // Find a starting vertex that has at least one outgoing path.
        for (int i = 0; i < n; i++) {
            boolean hasOutgoingPath = false;
            for (int j = 0; j < n; j++) {
                if (paths[i][j] == 1) {
                    hasOutgoingPath = true;
                    break;
                }
            }
            if (hasOutgoingPath) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            return 0;
        }

        // Traverse the graph using DFS and mark all visited vertices.
        dfs_third(start, visited, paths);

        // Check if all vertices have been visited.
        for (boolean v : visited) {
            if (!v) {
                return 0;
            }
        }
        return 1;
    }

    private void dfs_third(int u, boolean[] visited, int[][] paths) {
        visited[u] = true;
        for (int v = 0; v < visited.length; v++) {
            if (paths[u][v] == 1 && !visited[v]) {
                dfs_third(v, visited, paths);
            }
        }
    }



    // 17. Hamiltonian Path
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        // Create an adjacency list representation of the graph.
        ArrayList<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int u = Edges.get(i).get(0) - 1;
            int v = Edges.get(i).get(1) - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        // Check if exist a Hamiltonian path starting from each vertex.
        for (int start = 0; start < N; start++) {
            boolean[] visited = new boolean[N];
            visited[start] = true;
            if (dfs(start, visited, adj, 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int u, boolean[] visited, ArrayList<Integer>[] adj, int count) {
        if (count == visited.length) {
            // All vertices have been visited exactly once, so there is a Hamiltonian path.
            return true;
        }
        for (int v : adj[u]) {
            if (!visited[v]) {
                visited[v] = true;
                if (dfs(v, visited, adj, count + 1)) {
                    return true;
                }
                visited[v] = false;
            }
        }
        return false;
    }


    
    // 18. Geek in a Maze
    public static int numberOfCells(int n, int m, int r, int c, int u, int d, char mat[][]) {
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c, u, d });
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            int up = cur[2];
            int down = cur[3];
            count++;

            if (up == 0 && down == 0) {
                continue;
            }

            // moving up
            if (row > 0 && mat[row - 1][col] == '.' && !visited[row - 1][col] && up > 0) {
                q.add(new int[] { row - 1, col, up - 1, down });
                visited[row - 1][col] = true;
            }

            // moving down
            if (row < n - 1 && mat[row + 1][col] == '.' && !visited[row + 1][col] && down > 0) {
                q.add(new int[] { row + 1, col, up, down - 1 });
                visited[row + 1][col] = true;
            }

            // moving left
            if (col > 0 && mat[row][col - 1] == '.' && !visited[row][col - 1]) {
                q.add(new int[] { row, col - 1, up, down });
                visited[row][col - 1] = true;
            }

            // moving right
            if (col < m - 1 && mat[row][col + 1] == '.' && !visited[row][col + 1]) {
                q.add(new int[] { row, col + 1, up, down });
                visited[row][col + 1] = true;
            }
        }

        return count;
    }

}


