import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Grafo {
    private List<String> vertices;
    private int[][] matrizAdjacencia;
    
    public Grafo(int numVertices) {
        vertices = new ArrayList<>(numVertices);
        matrizAdjacencia = new int[numVertices][numVertices];
    }
        public void adicionarVertice(String vertice) {
        vertices.add(vertice);
    }
    public void adicionarAresta(int indiceVertice1, int indiceVertice2) {
        matrizAdjacencia[indiceVertice1][indiceVertice2] = 1;
        matrizAdjacencia[indiceVertice2][indiceVertice1] = 1;
    }
    public void imprimirMatrizAdjacencia() {
        System.out.print("  ");
        for (String vertice : vertices) {
            System.out.print(vertice + " ");
        }
        System.out.println();
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i) + " ");
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(matrizAdjacencia[i][j] + " ");
            }
            System.out.println();
        }
    }
    /**
    * @return
    */
    public int menosVizinhos() {
        int minVizinhos = Integer.MAX_VALUE;
        int minEstado = -1;
        for (int i = 0; i < this.matrizAdjacencia.length; i++) {
            int vizinhos = 0;
            for (int j = 0; j < this.matrizAdjacencia[i].length; j++) {
                if (this.matrizAdjacencia[i][j] == 1) {
                    vizinhos++;
                }
            }
            if (vizinhos < minVizinhos) {
                minVizinhos = vizinhos;
                minEstado = i;
            }
        }
        return minEstado;   
    }
    
    /**
    * Busca o estado que possui mais vizinhos
    * @return
    */
    public int maisVizinhos() {
        int maxVizinhos = Integer.MIN_VALUE;
        int maxEstado = -1;
        for (int i = 0; i < this.matrizAdjacencia.length; i++) {
            int vizinhos = 0;
            for (int j = 0; j < this.matrizAdjacencia[i].length; j++) {
                if (this.matrizAdjacencia[i][j] == 1) {
                    vizinhos++;
                }
            }
            if (vizinhos > maxVizinhos) {
                maxVizinhos = vizinhos;
                maxEstado = i;
            }
        }
        
        return maxEstado;
    }
    
    /**
    * @param startState
    * @param endState
    */
    public void menorTrajeto(int startState, int endState) {
        Queue<Integer> queue = new LinkedList<>();
        int[] path = new int[this.matrizAdjacencia.length];
        boolean[] visited = new boolean[this.matrizAdjacencia.length];
        visited[startState] = true;
        
        queue.add(startState);        
        while (!queue.isEmpty()) {
            int state = queue.remove();
            for (int i = 0; i < this.matrizAdjacencia[state].length; i++) {
                if (this.matrizAdjacencia[state][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                    path[i] = state;
                    if (i == endState) { break;
                    }
                }
            }
        }
        System.out.print("Menor tragejo entre dois estados: ");
        int state = endState;
        while (state != startState) {
            System.out.print(state + " >>> ");
            state = path[state];
        }
        System.out.println(startState);
        
    }
    
    /**
    * @param startState
    * @param endState
    */
    public void encontrarTodosOsTrajetos(int startState, int endState) {
        Stack<Integer> stack = new Stack<>();
        int[] path = new int[this.matrizAdjacencia.length];
        boolean[] visited = new boolean[this.matrizAdjacencia.length];
        visited[startState] = true;
        
        stack.push(startState);
        while (!stack.isEmpty()) { int state = stack.pop();
            
            for (int i = 0; i < this.matrizAdjacencia[state].length; i++) {
                if (this.matrizAdjacencia[state][i] == 1 && !visited[i]) { visited[i] = true;
                    stack.push(i);
                    path[i] = state;
                    
                    if (i == endState) {
                        System.out.print("Tragejo possível: ");
                        state = endState;
                        while (state != startState) { System.out.print(state + " >>> ");
                            state = path[state];
                        }
                        System.out.println(startState);
                        stack.pop();
                        visited[i] = false;
                    }
                }
            }
        }
        
    }    
    public void construir() {
        this.adicionarVertice("Acre"); 
        this.adicionarVertice("Alagoas"); 
        this.adicionarVertice("Amapá"); 
        this.adicionarVertice("Amazonas");
        this.adicionarVertice("Bahia"); 
        this.adicionarVertice("Ceará"); 
        this.adicionarVertice("Distrito Federal");
        this.adicionarVertice("Espírito Santo");
        this.adicionarVertice("Goiás"); 
        this.adicionarVertice("Maranhão"); 
        this.adicionarVertice("Mato Grosso"); 
        this.adicionarVertice("Mato Grosso do Sul"); 
        this.adicionarVertice("Minas Gerais");
        this.adicionarVertice("Pará"); 
        this.adicionarVertice("Paraíba");
        this.adicionarVertice("Paraná"); 
        this.adicionarVertice("Pernambuco");
        this.adicionarVertice("Piauí"); 
        this.adicionarVertice("Rio de Janeiro"); 
        this.adicionarVertice("Rio Grande do Norte");
        this.adicionarVertice("Rio Grande do Sul");
        this.adicionarVertice("Rondônia");
        this.adicionarVertice("Roraima"); 
        this.adicionarVertice("Santa Catarina");
        this.adicionarVertice("São Paulo");
        this.adicionarVertice("Sergipe"); 
        this.adicionarVertice("Tocantins"); 
        this.adicionarAresta(0, 3);
        this.adicionarAresta(3, 22);
        this.adicionarAresta(3, 13);
        this.adicionarAresta(3, 21);
        this.adicionarAresta(3, 21);
        this.adicionarAresta(22, 13);
        this.adicionarAresta(22, 13);
        this.adicionarAresta(21, 10);
        this.adicionarAresta(13, 2);
        this.adicionarAresta(13, 10);
        this.adicionarAresta(13, 9);
        this.adicionarAresta(13, 26);
        this.adicionarAresta(10, 26);
        this.adicionarAresta(10, 8);
        this.adicionarAresta(10, 11);
        this.adicionarAresta(9, 17);
        this.adicionarAresta(9, 26);
        this.adicionarAresta(9, 17);
        this.adicionarAresta(17, 5);
        this.adicionarAresta(5, 19);
        this.adicionarAresta(5, 14);
        this.adicionarAresta(5, 16);
        this.adicionarAresta(19, 14);
        this.adicionarAresta(14, 16);
        this.adicionarAresta(16, 1);
        this.adicionarAresta(16, 4);
        this.adicionarAresta(16, 17);
        this.adicionarAresta(1, 25);
        this.adicionarAresta(25, 4);
        this.adicionarAresta(4, 12);
        this.adicionarAresta(4, 17);
        this.adicionarAresta(4, 26);
        this.adicionarAresta(4, 7);
        this.adicionarAresta(4, 8);
        this.adicionarAresta(8, 26);
        this.adicionarAresta(8, 12);
        this.adicionarAresta(8, 6);
        this.adicionarAresta(6, 12);
        this.adicionarAresta(12, 7);
        this.adicionarAresta(12, 18);
        this.adicionarAresta(12, 24);
        this.adicionarAresta(12, 10);
        this.adicionarAresta(18, 7);
        this.adicionarAresta(18, 24);
        this.adicionarAresta(10, 24);
        this.adicionarAresta(24, 15);
        this.adicionarAresta(15, 23);
        this.adicionarAresta(15, 11);
        this.adicionarAresta(15, 20);
        
    }
    
    public static void main(String args[]) {
        Grafo grafo = new Grafo(27);
        grafo.construir();
        int min = grafo.menosVizinhos(), max = grafo.maisVizinhos();
        System.out.println("Menor quantidade de vizinhos: " + grafo.vertices.get(min));
        System.out.println("Maior quantidade de vizinhos: " + grafo.vertices.get(max));
        grafo.menorTrajeto(2, 17);
        grafo.encontrarTodosOsTrajetos(2, 17);
    }
}
