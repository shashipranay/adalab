import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class dijkstra {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Take the number of vertices, edges, and the source node as input
        System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();
        
        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();
        
        System.out.print("Enter source node (S): ");
        int S = sc.nextInt();

        // Initialize the adjacency list with empty lists for each vertex
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Taking edge inputs
        System.out.println("Enter each edge in the format: <source> <destination> <weight>");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();  // source node
            int v = sc.nextInt();  // destination node
            int w = sc.nextInt();  // weight of the edge

            // Adding edge to the adjacency list
            ArrayList<Integer> edge1 = new ArrayList<>(Arrays.asList(v, w));
            adj.get(u).add(edge1);
            
            // For undirected graph, add the reverse edge as well
            ArrayList<Integer> edge2 = new ArrayList<>(Arrays.asList(u, w));
            adj.get(v).add(edge2);
        }

        // Calling Dijkstra's algorithm
        Solution obj = new Solution();
        int[] res = obj.dijkstra(V, adj, S);

        // Printing the result
        System.out.println("Shortest distances from source:");
        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
        
        sc.close();
    }
}

class Pair {
    int node;
    int distance;

    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}

// User function Template for Java
class Solution {
    // Function to find the shortest distance of all vertices from the source vertex S
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Create a priority queue for storing nodes as pairs {dist, node}
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] dist = new int[V];

        // Initialize dist array with a large number to indicate unvisited nodes initially
        Arrays.fill(dist, (int) 1e9);

        // Source is initialized with dist = 0
        dist[S] = 0;
        pq.add(new Pair(0, S));

        // Process the priority queue
        while (!pq.isEmpty()) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();

            // Traverse all adjacent nodes of the popped element
            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                // Update the distance if a shorter path is found
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        
        // Return the list containing shortest distances from source to all nodes
        return dist;
    }
}
