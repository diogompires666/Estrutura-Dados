public class Stack {
    private int[] stack;
    private int size, length, top;

    public Stack(int capacidade) {
        this.stack = new int[capacidade];
        this.size = 0;
        this.length = capacidade;
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.length;
    }

    public void push(int valor) {
        if (this.isFull())
            throw new ArrayIndexOutOfBoundsException("The Stack is empty.");
        this.stack[++this.top] = valor;
        this.size++;
    }

    public int pop() {
        if (this.isEmpty())
            throw new ArrayIndexOutOfBoundsException("The Stack is empty");
        this.size--;
        return this.stack[this.top--];
    }

    public int peek() {
        if (this.isEmpty())
            throw new ArrayIndexOutOfBoundsException("The Stack is empty.");
        return this.stack[this.top];
    }

    public String toString() {
        Stack p = new Stack(this.size);
        StringBuilder sb = new StringBuilder();

        for (int i = this.top; i >= 0; i--) {
            sb.append(String.valueOf(this.peek()));
            if (i > 0) sb.append(", ");
            p.push(this.pop());
        }

        for (int i = p.top; i >= 0; i--) {
            this.push(p.pop());
        }

        return sb.toString();
    }

    public int indexOf(int valor) {
        Stack p = new Stack(this.size);

        boolean found = false;
        int index = -1, limit = this.top;
        for (int i = limit; i >= 0; i--) {
            p.push(this.pop());
            if (p.peek() == valor && !found){
                index = limit - i;
                found = true;
            }
        }

        for (int i = p.top; i >= 0; i--) {
            this.push(p.pop());
        }

        return index;
    }

    public int size() {
        return this.size;
    }

}