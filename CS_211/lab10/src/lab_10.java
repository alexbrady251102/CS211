public class lab_10 {
    public static void main(String[] args) {
        AdjacencyMapGraph<Character, String> graph = new AdjacencyMapGraph<>(false);

        Character[] nodes = {'g', 'a', 'b', 'c', 'd', 'e', 'f'};

        for(Character c: nodes){
            graph.insertVertex(c);
        }

        Iterable<Vertex<Character>> vertices = graph.vertices();

        int count = 0;
        Vertex<Character> previous = null;
        Vertex<Character> g = null;
        Vertex<Character> c = null;
        for(Vertex<Character> v: vertices) {
            if(previous == null) {
                g = v;
                graph.insertEdge(previous, v, null);
            } else {
                previous = v;
                c = count == 3 ? v : null;
            } count++;
        }

        PositionalList<Edge<String>> path = GraphAlgorithms.constructPath(graph, g, c, GraphAlgorithms.DFSComplete(graph));
    }
}
