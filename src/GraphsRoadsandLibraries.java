import java.io.*;
import java.util.*;

/***
 * https://www.hackerrank.com/challenges/torque-and-development/problem
 */
public class GraphsRoadsandLibraries {

    // road counter
    public static int r = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            long x = in.nextLong();
            long y = in.nextLong();

            if (m == 0){
                System.out.println(n*x);
                continue;
            }

            // create libraries
            Node[] temp = new Node[n];
            for (int n0 = 0; n0 < n; n0++) {
                temp[n0] = new Node(String.valueOf(n0));
            }

            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                temp[city_1-1].addAdjacent(temp[city_2-1]);
                temp[city_2-1].addAdjacent(temp[city_1-1]);
            }

            // create graph
            Graph graph = new Graph();
            for (int i = 0; i < n; i++) {
                graph.addNode(temp[i]);
            }

            // count roads9
            long libCount = 0;
            long buildingPrice = n*x;
            r = 0;
            for (int ii = 0; ii < graph.nodes.size(); ii++) {
                if (!graph.nodes.get(ii).isVisited){
                    libCount ++;
                    if (graph.nodes.get(ii).children.size() > 0){
                        search(graph.nodes.get(ii));
                    }
                }
            }

            System.out.println(Math.min(buildingPrice, r*y + x*libCount));

        }
    }

    public static void search(Node root){
        if (root == null) return;
        root.isVisited = true;
        for (Node n: root.children) {
            if (!n.isVisited){
                r ++;
                search(n);
            }
        }
    }

    public static class Graph{
        public ArrayList<Node> nodes = new ArrayList<>();
        public void addNode(Node node){
            this.nodes.add(node);
        }
    }

    public static class Node{
        public boolean isVisited = false;
        Node(String name){
            this.name = name;
        }
        public String name;
        public ArrayList<Node> children = new ArrayList<>();

        public void addAdjacent(Node adjacent){
            this.children.add(adjacent);
        }
    }

}