import java.lang.StringBuilder;

public class Queue{
    private int[] queue;
    private int size, head, tail;
    private final int DEFAULT_CAPACITY = 20;
    private final double DOUBLE_CAPACITY = 2.0;
    private final double HALF_CAPACITY = 0.5;

    public Queue(){
        this.queue = new int[20];
        this.size = 0;
        this.head = -1;
        this.tail = -1;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return this.size == this.queue.length;
    }

    public void addLast(int value){
        if (this.isFull()) {
            this.newQueueSize(this.DOUBLE_CAPACITY);
        }
        this.size++;

        if (this.head == -1) this.head++;

        this.queue[++this.tail] = value;
    }

    // Method that removes the first element from the queue by increasing its head and shifting it left.
    // Returns the removed element.
    public int removeFirst(){
        if (this.isEmpty()) throw new RuntimeException("Already empty.");

        int element = this.head;
        this.head++;
        this.size--;
        this.tail--;

        // Check if it's worth it to decrease the array length.
        if ((this.size <= this.queue.length / 4) && (this.size > this.DEFAULT_CAPACITY * 2)) {
            this.fixQueue(this.HALF_CAPACITY);
        } else {
            this.shiftLeft();
        }

        if(this.isEmpty()){
            this.head = -1;
            this.tail = -1;
        }

        return element;
    }

    private void fixQueue(double newSizeFactor){
        this.shiftLeft();
        this.newQueueSize(newSizeFactor);
    }

    private void shiftLeft(){
        int j = this.head;
        for (int i = 0; i <= this.size; i++) {
            this.queue[i] = this.queue[j];
            j++;
        }
    }

    private void newQueueSize(double newSizeFactor){
        int[] temp = new int[(int) (this.size * newSizeFactor)];

        for (int i = this.head; i < this.queue.length; i++) {
            temp[i] = this.queue[i];
        }
        this.queue = temp;
    }

    public String toString(){
        StringBuilder output = new StringBuilder("queue(");
        if (this.isEmpty()) return output.append(" empty )").toString();
        for (int i = 0; i < this.size; i++) {
            output.append(this.queue[i]);
            if (i < this.size - 1) output.append(", ");
        }
        return output.append(")").toString();
    }
}