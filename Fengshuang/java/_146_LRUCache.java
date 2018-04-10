/**
 * Created by lifengshuang on 8/4/15.
 */
//https://leetcode.com/problems/lru-cache/
public class _146_LRUCache {

    public static void main(String[] args) {
        _146_LRUCache cache = new _146_LRUCache(2);
        cache.set(2,1);
        cache.set(1,1);
        System.out.println(cache.get(2));
        cache.set(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

//        cache.set(23, 1);
//        cache.set(233, 2);
//        System.out.println(cache.get(23) + "=1");
//        System.out.println(cache.get(2333) + "=-1");
//        cache.set(2333, 3);
//        cache.set(24, 4);
//        System.out.println(cache.get(2333) + "=3");
//        cache.set(244, 5);
//        cache.set(2444, 6);
//        cache.set(25, 7);
//        cache.set(255, 8);
//        System.out.println(cache.get(23) + "=-1");
//        cache.set(2555, 9);
//        System.out.println(cache.get(233) + "=-1");
//        System.out.println(cache.get(25) + "=7");
//        System.out.println(cache.get(24) + "=4");
//        System.out.println(cache.get(2333) + "=-1");
    }

    private int tableSize;
    private Node[] table;
    private Queue queue;

    public _146_LRUCache(int capacity) {
        this.tableSize = tableSizeForCapacity(capacity);
        this.table = new Node[this.tableSize];
        this.queue = new Queue(capacity);
    }

    public int get(int key) {
        int hash = hash(key);
        Node node = table[hash];
        if (node == null)
            return -1;
        while (node.key != key) {
            node = node.next;
            if (node == null)
                return -1;
        }
        queue.add(node);
//        print(key, node.value);
        return node.value;
    }

    public void set(int key, int value) {
        int hash = hash(key);
        Node node = new Node(key, value);
        if (table[hash] == null) {
            table[hash] = node;
        }
        else {
            Node last = table[hash];
            while (last != null) {
                if (last.key == key) {
                    last.value = value;
                    node = last;
                    break;
                }
                if (last.next == null) {
                    last.next = node;
                    node.prev = last;
                    break;
                }
                last = last.next;
            }
        }

        int oldKey = queue.add(node);
        if (oldKey != -1) {
            remove(oldKey);
        }

//        print(key, value);
    }

    private void print(int key, int value) {
        System.out.println("Set " + key + ": " + value);

        System.out.print("Queue: ");
        QueueNode queueNode = queue.first;
        while (queueNode != null) {
            System.out.print("(" + queueNode.node.key + ", " + queueNode.node.count + ")  ");
            queueNode = queueNode.next;
        }
        System.out.println();

        System.out.println("Table: ");
        for (int i = 0; i < table.length; i++) {
            Node node = table[i];
            System.out.print("_" + i + "_: ");
            while (node != null) {
                System.out.print(node.key + ": " + node.value + "-" + node.count + ", ");
                node = node.next;
            }
            System.out.println();
        }
        System.out.println();
    }

    private void remove(int key) {
        int hash = hash(key);
        Node node = table[hash];
        if (node == null)
            return;
        while (node.key != key) {
            node = node.next;
            if (node == null)
                return;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        else {
            table[hash] = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    private int hash(int key) {
        return key & this.tableSize - 1;
    }

    private int tableSizeForCapacity(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }

    private class Queue {

//        private int[] table;
        private int size;
        private int capacity;
        private QueueNode first;
        private QueueNode last;

        public Queue(int capacity) {
            this.capacity = capacity;
        }

        public int add(Node node) {
            node.count++;
            QueueNode queueNode = new QueueNode(node);
            if (first == null) {
                first = queueNode;
                last = queueNode;
            }
            else {
                last.next = queueNode;
                last = queueNode;
            }
            if (node.count == 1) {
                size++;
                if (size > capacity) {
                    while (true) {
                        QueueNode remove = removeFirst();
                        if (remove.node.count == 0) {
                            size--;
                            return remove.node.key;
                        }
                    }
                }
            }
//            size++;
//            int position = size % table.length;
//            int oldKey = table[position];
//            table[position] = key;
//            if (size > table.length) {
//                return oldKey;
//            }

            return -1;
        }

        private QueueNode removeFirst() {
            QueueNode remove = first;
            first = first.next;
            remove.node.count--;
            return remove;
        }
    }

    private class QueueNode {
        private Node node;
        private QueueNode next;

        public QueueNode(Node node) {
            this.node = node;
        }
    }

    private class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;
        private int count;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 0;
        }
    }

}
