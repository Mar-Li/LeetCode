import java.util.Arrays;

public class ProducerConsumer {
    private int capacity;
    private int[] data;
    private Integer head = 0;
    private Integer tail = 0;
    private final Object fillLock = new Object();
    private final Object getLock = new Object();

    public ProducerConsumer(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
    }

    public void fill(int num) throws InterruptedException {
        synchronized (fillLock) {
            while ((tail + 1) % capacity == head) {
                Thread.sleep(10);
            }
            synchronized (this) {
                data[tail] = num;
                tail = (tail + 1) % capacity;
                System.out.println(this);
            }
        }
    }

    public int[] get(int n) throws InterruptedException {
        synchronized (getLock) {
            while ((tail - head + capacity) % capacity < n) {
                Thread.sleep(10);
            }
            synchronized (this) {
                System.out.println("=======================\nGETTTTT");
                int[] result = new int[n];
                if (head <= tail || n < capacity - head) {
                    System.arraycopy(data, head, result, 0, n);
                } else {
                    System.arraycopy(data, head, result, 0, capacity - head);
                    System.arraycopy(data, 0, result, capacity - head, n - capacity + head);
                }
                head = (head + n) % capacity;
                System.out.println(this);
                System.out.println("==============================");
                return result;
            }
        }
    }

    @Override
    public String toString() {
        return "Head: " + head + ", Tail: " + tail + "\n" ;//+ Arrays.toString(data);
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer(50);
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    producerConsumer.fill((int) System.currentTimeMillis() % 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    producerConsumer.get(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
//        Thread.sleep(2000);
//        System.out.println(Arrays.toString(producerConsumer.get(10)));
//        Thread.sleep(2000);
//        System.out.println(Arrays.toString(producerConsumer.get(20)));
//        System.out.println(producerConsumer);
    }
}
