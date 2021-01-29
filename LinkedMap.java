import java.util.Map;

/* Custom implementation of the Map interface using a linked-node structure. Performs most operations in O(n) time complexity. */

public class LinkedMap<keyType extends Comparable<keyType>, valueType extends Comparable<valueType>> implements Map<keyType, valueType> {
    private MapNode<keyType, valueType> head;
    private int size;

    public LinkedMap() {
        this.head = null;
    }

    public valueType put(keyType inpKey, valueType inpVal) {
        this.size++;

        if (head == null) {
            head = new MapNode<keyType, valueType>(inpKey, inpVal);
            return inpVal;
        }
        
        else {
            MapNode<keyType, valueType> iter = head;

            while (iter.next != null) {
                if (iter.key == inpKey) {
                    iter.value = inpVal;
                    return inpVal;
                }

                iter = iter.next;
            }

            iter.next = new MapNode<keyType, valueType>(inpKey, inpVal);
            return inpVal;
        }
    }

    public valueType remove(keyType inpKey) {
        if (head == null) {
            this.size--;
            return null;
        }

        if (head.key == inpKey) {
            valueType tmp = head.value;
            head = null;
            this.size--;
            return tmp;
        }

        MapNode<keyType, valueType> iter = head;

        while (iter.next != null) {
            if (iter.next.key.equals(inpKey)) {
                valueType tmp = iter.next.value;
                iter.next = iter.next.next;
                this.size--;
                return tmp;
            }
            
            iter = iter.next;
        }

        throw new IllegalArgumentException("Item with key: " + inpKey + " not found in map.");
    }

    public valueType get(Object inpKey) {
        MapNode<keyType, valueType> iter = head;

        while (iter != null) {
            if (iter.key.equals(inpKey))
                return iter.value;

            iter = iter.next;
        }

        throw new IllegalArgumentException("Item with key: " + inpKey + " not found in map.");
    }

    public valueType getOrDefault(keyType inpKey, valueType defaultValue) {
        valueType retVal = null;

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
    
    private class MapNode<keyType, valueType> {
        public MapNode<keyType, valueType> next;
        public keyType key;
        public valueType value;

        public MapNode(keyType inpKey, valueType inpVal) {
            this.next = null;
            this.key = inpKey;
            this.value = inpVal;
        }
    }
}