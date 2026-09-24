class TreeMap {

    TreeNode root;

    public TreeMap() {
        this.root = null;
    }

    public void insert(int key, int val) {
        this.root = insertBST(root, key, val);
    }

    private TreeNode insertBST(TreeNode root, int key, int val) {
        if (root == null) {
            return new TreeNode(key, val);
        }

        if (root.key < key) {
            root.right = insertBST(root.right, key, val);
        } else if (root.key > key) {
            root.left = insertBST(root.left, key, val);
        } else {
            root.val = val;
        }
        return root;
    }

    public int get(int key) {
        return getBST(root, key);
    }

    private int getBST(TreeNode root, int key) {
        if (root == null) {
            return -1;
        }

        if (root.key < key) {
            return getBST(root.right, key);
        } else if (root.key > key) {
            return getBST(root.left, key);
        } 

        return root.val;
    }

    public int getMin() {
        return getMinBST(root).val;
    }

    private TreeNode getMinBST(TreeNode root) {
        if (root == null) {
            return new TreeNode(0, -1);
        }

        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public int getMax() {
        if (root == null) {
            return -1;
        }

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current.val;
    }

    public void remove(int key) {
       this.root = removeBST(root, key);
    }

    private TreeNode removeBST(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.key < key) {
            root.right = removeBST(root.right, key);
        } else if (root.key > key) {
            root.left = removeBST(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode min = getMinBST(root.right);
                root.key = min.key;
                root.val = min.val;
                root.right = removeBST(root.right, min.key);
            }
        }
        return root;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> output = new ArrayList<>();
        inorder(root, output);
        return output;
    }

    private void inorder(TreeNode root, List<Integer> output) {
        if (root == null) {
            return;
        }
        inorder(root.left, output);
        output.add(root.key);
        inorder(root.right, output);
    }
}

class TreeNode {
    public int key;
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key, int val) {
        this(key, val, null, null);
    }

    public TreeNode(int key, int val, TreeNode left, TreeNode right) {
        this.key = key;
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
