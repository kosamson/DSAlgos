import org.graalvm.compiler.graph.spi.Canonicalizable.Binary;

public class BinarySearchTree<T extends Comparable> {
    private BSTNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T newValue) {
        this.root = insertHelper(root, newValue);
    }

    private BSTNode<T> insertHelper(BSTNode<T> current, T newValue) {
        if (current == null)
            return new BSTNode(newValue);

        if (current.value.compareTo(newValue) > 0)
            current.left = insertHelper(current.left, newValue);

        else
            current.right = insertHelper(current.right, newValue);
    }

    public void remove(T targetValue) {
        this.root = removeHelper(root, targetValue);
    }

    private BSTNode<T> removeHelper(BSTNode<T> current, T targetValue) {
        if (current == null)
            throw new IllegalArgumentException();
        
        if (current.value.equals(targetValue)) {
            if (current.left == null && current.right == null)
                return null;
            
            else if (current.left == null && current.right != null)
                return current.right;

            else if (current.left != null && current.right == null)
                return current.left;

            else
                current.value = findReplacement(current.left);
        }
    }

    private

    private class BSTNode<T1> {
        T1 value;
        BSTNode<T1> left;
        BSTNode<T1> right;

        public BSTNode() {
            this.value = null;
            this.left = null;
            this.right = null;
        }

        public BSTNode(T1 newValue) {
            this.value = newValue;
            this.left = null;
            this.right = null;
        }

        public BSTNode(T1 newValue, BSTNode<T1> newLeft, BSTNode<T1> newRight) {
            this.value = newValue;
            this.left = newLeft;
            this.right = newRight;
        }
    }
}
