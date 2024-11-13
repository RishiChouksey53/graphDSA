import java.util.*;

public class Graph {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
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
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

    }

    public static void bfsAlgo(ArrayList<Edge> graph[]) { // O(V+E)
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfsAlgo(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfsAlgo(graph, e.dest, vis);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], int curr, int key, boolean vis[]) {
        if (curr == key) {
            return true;
        }
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                if (hasPath(graph, e.dest, key, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        System.out.print("bfs : ");
        bfsAlgo(graph);

        System.out.println();

        System.out.print("dfs : ");
        dfsAlgo(graph, 0, new boolean[graph.length]);

        System.out.println();

        System.out.println("hasPath : " + hasPath(graph, 0, 69, new boolean[graph.length]));

    }
}
