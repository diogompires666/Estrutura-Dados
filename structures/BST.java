import java.lang.StringBuilder;

public class BST {

    private Node root;
    private int size;

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int element) {
        this.size += 1;
        if (isEmpty())
            this.root = new Node(element);
        else {
            Node aux = this.root;
            while (aux != null) {

                if (element < aux.value) {
                    if (aux.left == null) {
                        Node newNode = new Node(element);
                        aux.left = newNode;
                        newNode.parent = aux;
                        return;
                    }

                    aux = aux.left;
                } else {
                    if (aux.right == null) {
                        Node newNode = new Node(element);
                        aux.right = newNode;
                        newNode.parent = aux;
                        return;
                    }

                    aux = aux.right;
                }
            }
        }

    }

    public Node search(int element) {
        Node aux = root;

        while (aux != null) {
            if (aux.value == element)
                return aux;
            if (aux.value > element) {
                aux = aux.left;
            } else
                aux = aux.right;
        }

        return aux;
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node node) {
        if (node == null)
            return -1;

        int left = height(node.left);
        int right = height(node.right);

        if (left > right)
            return (left + 1);
        return (right + 1);
    }

    public boolean equals(BST outra) {
        if (this.size == 0 && outra.size == 0)
            return true;
        Node aux = this.root;
        Node outraAux = outra.root;
        return this.compares(aux, outraAux);
    }

    private boolean compares(Node auxThis, Node auxOutra) {
        if (auxThis == null && auxOutra == null) {
            return true;
        }
        if (auxOutra == null || auxThis == null)
            return false;

        if (auxThis.value != auxOutra.value)
            return false;
        boolean leftSide = this.compares(auxThis.left, auxOutra.left);
        boolean rightSide = this.compares(auxThis.right, auxOutra.right);

        return leftSide && rightSide;
    }

    public int leavesCounter() {
        return this.leavesCounter(this.root);
    }

    private int leavesCounter(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;

        int leftLeaves = this.contaFolhas(node.left);
        int rightLeaves = this.contaFolhas(node.right);
        return leftLeaves + rightLeaves;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return preProcessing(node, sb).trim();
    }

    private String preProcessing(Node node, StringBuilder sb){
        if(node == null) return sb.toString();
        sb.append(node.value);
        this.preProcessing(node.left, sb);
        this.preProcessing(node.right, sb);
        return sb.toString()
    }

}

class Node {

    int value;
    Node left;
    Node right;
    Node parent;

    Node(int v) {
        this.value = v;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

}
