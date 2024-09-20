public class BST {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.add(8);
        bst.add(4);
        bst.add(7);
        bst.add(9);
        bst.delete(8);
        bst.inorder();
    }
    private static class BSTNode {
        int value;
        int freq; //duplicates
        BSTNode left;
        BSTNode right;

        public BSTNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.freq = 1;
        }

        @Override
        public String toString() {
            return value + "";
        }
    }

    BSTNode root;

    public BST() {
        this.root = null;
    }

    public void inorder() {
        inorder(this.root);
        System.out.println();
    }

    //helper method should be private!!!
    private void inorder(BSTNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root + " ");
            inorder(root.right);
        }
    }

    public void preorder() {
        preorder(this.root);
        System.out.println();
    }

    //helper method should be private!!!
    private void preorder(BSTNode root) {
        if (root != null) {
            System.out.print(root + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public boolean contains(int key) {
        return contains(this.root, key);
    }

    private boolean contains(BSTNode root, int key) {
        if (root == null)
            return false;
        if (root.value == key)
            return true;
        if (root.value > key)
            return contains(root.left, key);
        else
            return contains(root.right, key);
    }

    public void add (int key) {
        this.root = add(this.root, key);
    }

    private BSTNode add(BSTNode root, int key) {
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }
        if (root.value >  key) {
            root.left = add(root.left, key);
            return root;
        }
        if (root.value <  key) {
            root.right = add(root.right, key);
            return root;
        }
        else {
            root.freq++;
            return root;
        }

    }

    public void delete(int key) {
        this.root = delete(this.root, key);
    }

    private BSTNode delete(BSTNode root, int key) {
        if (root == null)
            return root;
        if (root.value > key) {
            root.left = delete(root.left, key);
            return root;
        }
        if (root.value < key) {
            root.right = delete(root.right, key);
            return root;
        }
        else {
            if (root.left == null && root.right == null)
                return null;
            else if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                root.value = minValue(root.right);
                root.right = delete(root.right, minValue(root.right));
                return root;
            }
        }
    }

    //precondition: root != null
    private int minValue(BSTNode root) {
        while (root.left != null)
            root = root.left;
        return root.value;
    }

}