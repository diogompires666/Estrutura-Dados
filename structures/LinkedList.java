public class LinkedList {
    private int size;
    private Node head, tail;

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(int valor) {
        Node value = new Node(valor);

        if (this.isEmpty()) {
            this.head = value;
            this.tail = value;
            this.size++;
            return;
        }

        this.head.prev = value;
        value.next = this.head;
        this.head = value;
        this.size++;
    }

    public void addLast(int valor) {
        Node value = new Node(valor);

        if (this.isEmpty()) {
            this.head = value;
            this.tail = value;
        } else {
            this.tail.next = value;
            value.prev = this.tail;
            this.tail = this.tail.next;
        }
        this.size++;
    }

    public void add(int index, int valor) {
        Node value = new Node(valor);

        if (index == 0) {
            this.addFirst(valor);
            return;
        }
        if (this.isEmpty() || index > this.size || index < 0) return -1;
        if (index == this.size) {
            this.addLast(valor);
            return;
        }

        Node aux = this.head;
        int counter = 0;
        while (aux != null) {
            if (counter == index) {
                value.next = aux;
                aux.prev.next = value;
                value.prev = aux.prev;
                aux.prev = value;
                this.size++;
            }
            counter++;
            aux = aux.next;
        }
    }

    public int getFirst() {
        if (this.isEmpty()) return -1;
        return this.head.value;
    }

    public int getLast() {
        if (this.isEmpty()) return -1;
        return this.tail.value;
    }

    public int get(int index) {
        if (this.isEmpty() || index >= this.size || index < 0) return -1;

        Node aux = this.head;
        int counter = 0;
        while (aux != null) {
            if (counter == index)
                return aux.value;
            counter++;
            aux = aux.next;
        }
        return -1;
    }

    public int removeFirst() {
        if (this.isEmpty()) return -1;

        if (this.size == 1)
            return this.removeOnlyElement();

        this.head = this.head.next;
        int returnValue = this.head.prev.value;
        this.head.prev = null;
        this.size--;
        return returnValue;
    }

    public int removeLast() {
        if (this.isEmpty()) return -1;

        if (this.size == 1)
            return this.removeOnlyElement();

        int returnValue = this.tail.value;
        this.tail = this.tail.prev;
        this.tail.next = null;
        this.size--;
        return returnValue;
    }

    private int removeOnlyElement() {
        int returnValue = this.tail.value;
        this.head = null;
        this.tail = null;
        this.size--;
        return returnValue;
    }

    public int remove(int index) {
        if (this.isEmpty() || index >= this.size || index < 0) return -1;

        if (index == 0)
            return this.removeFirst();
        if (index == this.size - 1)
            return this.removeLast();

        if (this.size == 1)
            return this.removeOnlyElement();

        Node aux = this.head;
        int counter = 0;
        while (aux != null) {
            if (counter == index) {
                int returnValue = aux.value;
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                this.size--;
                return returnValue;
            }
            counter++;
            aux = aux.next;
        }
        return -1;
    }

    public boolean removeByValue(int value) {
        Node aux = this.head;
        int counter = 0;
        while (aux != null) {
            if (aux.value == value) {

                if (this.size == 1)
                    this.removeOnlyElement();

                else if (counter == 0)
                    this.removeFirst();

                else if (counter == this.size - 1)
                    this.removeLast();

                else
                    this.removeBetween(aux);

                return true;
            }

            counter++;
            aux = aux.next;
        }
        return false;
    }

    private void removeBetween(Node aux) {
        aux.prev.next = aux.next.next;
        aux.next.prev = aux.prev.prev;
        this.size--;
    }

    public int indexOf(int value) {
        int counter = 0;
        Node aux = this.head;
        while (aux != null) {
            if (aux.value == value)
                return counter;
            counter++;
            aux = aux.next;
        }
        return -1;
    }

    public boolean contain(int v) {
        Node aux = this.head;
        while (aux != null) {
            if (aux.value == v)
                return true;
            aux = aux.next;
        }
        return false;
    }

    public int lastIndexOf(int valor) {
        int lastOcurrence = -1;
        int counter = 0;
        Node aux = this.head;
        while (aux != null) {
            if (aux.value == valor)
                lastOcurrence = counter;
            aux = aux.next;
            counter++;
        }
        return lastOcurrence;
    }

    public String toString() {
        if (isEmpty())
            return "";

        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + ", ";
            aux = aux.next;
        }
        return out.substring(0, out.length() - 2);
    }

    public int size() {
        return this.size;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= this.size)
            return null;

        if (index == 0)
            return this.head;
        if (index == this.size - 1)
            return this.tail;
        if (this.isEmpty())
            return null;

        int counter = 0;
        Node aux = this.head;
        while (aux != null) {
            if (counter == index)
                return aux;
            counter++;
            aux = aux.next;
        }
        return null;
    }

    public void swap(int indexA, int indexB) {

        // Getting them in order to make it easier
        if (indexA > indexB) {
            int temp = indexA;
            indexA = indexB;
            indexB = temp;
        }
        Node a = this.getNode(indexA);
        Node b = this.getNode(indexB);

        // Checking if both elements are valid and if they are not already the same
        if (a == null || b == null || a == b)
            return;

        // Checking if they are side-to-side
        if (a.next == b) {
            if (b.next != null) {
                b.next.prev = a;
            } else {
                this.tail = a;
            }

            Node nextATemp = a.next;
            a.next = b.next;
            b.next = b.prev;
            b.prev = a.prev;
            if (a.prev != null) {
                a.prev.next = b;
            } else {
                this.head = b;
            }
            a.prev = nextATemp;
            return;
        }

        // If they are not side-to-side, this piece of code runs
        if (a.prev != null) {
            a.prev.next = b;
        } else {
            this.head = b;
        }
        if (b.next != null) {
            b.next.prev = a;
        } else {
            this.tail = a;
        }

        Node tempANext = a.next, tempAPrev = a.prev, tempBPrev = b.prev;
        a.next = b.next;
        a.prev = b.prev;
        b.next = tempANext;
        b.prev = tempAPrev;

        tempBPrev.next = a;
        tempANext.prev = b;

    }

    // Moves an arbitrary element to the head
    public void moveToHead(int index) {
        Node node = this.getNode(index);
        if (node == null || node == this.head)
            return;

        // Checking if the element that is becoming the head is the tail;
        if (node == this.tail) {
            this.head.prev = this.tail;
            this.tail.next = this.head;
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.head = this.head.prev;
            this.head.prev = null;
            return;
        }

        this.head.prev = node;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = this.head;
        node.prev = null;
        this.head = node;

    }
}

class Node {

    int value;
    Node prev;
    Node next;

    Node(int v) {
        this.value = v;
    }
}