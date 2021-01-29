/* Custom implementation of the Map interface using a linked-node structure. Performs most operations in O(n) time complexity. */

public class LinkedMap<K extends Comparable<K>, V extends Comparable<V>> {
    private MapNode<K, V> head;
    private int size;

    public LinkedMap() {
        this.head = null;
    }

    public void clear() {
        this.head = null;
    }

    public V put(K inpKey, V inpVal) {
        this.size++;

        if (head == null) {
            head = new MapNode<K, V>(inpKey, inpVal);
            return inpVal;
        }
        
        else {
            MapNode<K, V> iter = head;

            while (iter.next != null) {
                if (iter.key == inpKey) {
                    iter.value = inpVal;
                    return inpVal;
                }

                iter = iter.next;
            }

            iter.next = new MapNode<K, V>(inpKey, inpVal);
            return inpVal;
        }
    }

    public V remove(K inpKey) {
        if (head == null) {
            this.size--;
            return null;
        }

        if (head.key == inpKey) {
            V tmp = head.value;
            head = null;
            this.size--;
            return tmp;
        }

        MapNode<K, V> iter = head;

        while (iter.next != null) {
            if (iter.next.key.equals(inpKey)) {
                V tmp = iter.next.value;
                iter.next = iter.next.next;
                this.size--;
                return tmp;
            }
            
            iter = iter.next;
        }

        throw new IllegalArgumentException("Item with key: " + inpKey + " not found in map.");
    }

    public V get(Object inpKey) {
        MapNode<K, V> iter = head;

        while (iter != null) {
            if (iter.key.equals(inpKey))
                return iter.value;

            iter = iter.next;
        }

        throw new IllegalArgumentException("Item with key: " + inpKey + " not found in map.");
    }

    public V getOrDefault(K inpKey, V defaultValue) {
        V retVal = null;

        try {
            retVal = get(inpKey);
        }

        catch (IllegalArgumentException e) {
            return defaultValue;
        }

        return retVal;
    }

    public int size() {
        return this.size;
    }
    
    private class MapNode<K1, V1> {
        public MapNode<K1, V1> next;
        public K1 key;
        public V1 value;

        public MapNode(K1 inpKey, V1 inpVal) {
            this.next = null;
            this.key = inpKey;
            this.value = inpVal;
        }
    }
}