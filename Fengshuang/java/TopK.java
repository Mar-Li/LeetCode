import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

class Photo {
    public int id;
    public int count;

    public Photo(int id) {
        this.id = id;
        count = 0;
    }

    public Photo(int id, int count) {
        this.id = id;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
//        System.out.println(((Photo) o).id + " " + this.id);
//        System.out.println(((Photo) o).count + " " + this.count);
        return o instanceof Photo && ((Photo) o).id == this.id && ((Photo) o).count == this.count;
    }
}

class TopKStream {
    Map<Integer, Photo> freqMap;
    TreeSet<Photo> freqSet;
    int k;

    public TopKStream(int k) {
        freqMap = new HashMap<>();
        freqSet = new TreeSet<Photo>((a, b) -> a.count - b.count); //asc
        this.k = k;
    }

    public void call(int id) {
        freqMap.putIfAbsent(id, new Photo(id));
        Photo cur = freqMap.get(id);

        if (freqSet.contains(cur)) {
            freqSet.remove(cur);
        }
        cur.count += 1;
        boolean flag = freqSet.add(cur); //true iff add successful
        System.out.println(id + " " + freqSet.first().id + " " + freqSet.first().count + flag);
    }

    public List<Integer> topKFrequent() {
        List<Integer> topK = new ArrayList<Integer>();
        Iterator<Photo> iter = freqSet.iterator();
        while (iter.hasNext() && topK.size() < k) {
            topK.add((iter.next()).id);
        }

        return topK;
    }
}

public class TopK {
    public static void main(String[] args) throws IOException {

//		int[] nums = {1, 1, 2, 6, 3, 4, 4, 4, 4, 5, 4, 5, 5, 6, 2, 6, 6};
//		int[] nums = {1, 1, 1, 1, 2, 2, 3};
//		List<Integer> nums = new LinkedList<Integer>();
        TopKStream sol = new TopKStream(2);
        sol.call(1);
        sol.call(1);
        sol.call(1);
        sol.call(2);
        sol.call(3);
        sol.call(3);

//	    System.out.println(sol.topKFrequent());
        sol.call(2);
        sol.call(2);
        System.out.println(sol.topKFrequent());
    }
}
