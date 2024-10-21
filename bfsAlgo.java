import java.util.*;

public class bfsAlgo {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));

        graph[6].add(new Edge(6, 7, 1));
        graph[7].add(new Edge(7, 6, 1));
    }

    public static void bfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i = 0; i < vis.length; i++){
            if(!vis[i]){
                bfsUtil(graph, vis, i);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge> graph[], boolean[] vis, int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.add(idx); // source = 0;
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) { // visit curr
                vis[curr] = true;
                System.out.println(curr);
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        int v = 8;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        bfs(graph);
    }
}
