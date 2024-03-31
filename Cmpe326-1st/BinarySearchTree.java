public class BinarySearchTree {
    Node root;

    // constructor method
    BinarySearchTree() {
        root = null;
    }

    // Method used to add a new key
    void insert(int key) {
        root = insertCont(root, key);
    }

    Node insertCont(Node node, int key) {
        // if the node is it means that the tree is empty...So we create a new node
        if (node == null) {
            node = new Node(key);
        }
        // if the key is less than node key, we add the left...
        if (key < node.key) {
            node.left = insertCont(node.left, key);
        }
        // if the key is greater than node key, we add the right...
        else if (key > node.key) {
            node.right = insertCont(node.right, key);
        }
        // we write this statemen because of duplicate.. If tree has the same key, we
        // add different list
        // Logic is the like BAG()
        // In the BAG, we do similar thing. we look index value and we add arrList for
        // same indexes...
        else if (key == node.key) {
            node.duplicates.add(new Node(key));
        }

        return node;
    }

    void List() {
        ListRec(root);

    }

    // In here, We try to apply ""DFS""" logic...
    void ListRec(Node root) {
        stack<Node> newStack = new stack<Node>(100);// we create a stack the store node
        Node current = root; // we assign root to current node..
        // boolean[] visited = new boolean[Integer.MAX_VALUE];
        // if the current is not null or stack is not empty, we continue to loop
        while (current != null || !newStack.isEmpty()) {
            // we add the left node to the stack until the left node is null
            while (current != null) {
                // if (!visited[current.key])

                // until the left node
                newStack.push(current);
                current = current.left;
            }

            // we pop the last element from the stack
            current = newStack.pop();

            // System.out.print(current.key + " ");
            // In there, in fact we try to print keys but there is a problem about
            // duplicates...

            // for Same keys ,,at the same time all keys are printed
            for (Node duplicate : current.duplicates) {
                System.out.print(duplicate.key + " ");
            }
            //
            current = current.right;

        }
        System.out.println();

    }

    // Method for finding the parent of a key...
    int findParent(int key) {
        return findParentRec(root, key);
    }

    // in there. this method takes two parameters, One of them is node and key..
    // Because we try to find the parent of the key...
    int findParentRec(Node node, int key) {
        // if the node is null or node key is equal to key, we return -1
        // In frist time,, these methods not type of (int) so values return null...but
        // finding key values so we change the type of methods.
        if (node == null || node.key == key) {
            return -1;
        }
        // if the left node is not null and left node key is equal to key or right node
        // is not null and right node key is equal to key, we return node key
        if ((node.left != null && node.left.key == key) || (node.right != null && node.right.key == key)) {
            // When the current conditions are met, our node becomes the root.
            return node.key;
        }
        // if the left node is not null, we call the method recursively and we return
        // the left node key
        // And continue recursive method left side..
        int leftParent = findParentRec(node.left, key);
        if (leftParent != -1) {
            // If there is a parent on the left side, we return the left parent.
            return leftParent;
        }
        // keep continue to right side
        return findParentRec(node.right, key);
    }

    // deleting
    Node deleteNode(Node root, int key) {
        // if the root is null, we return root
        if (root == null) {
            return root;
        }
        // if the key is less than root key, we call the method recursively
        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        }
        // Same thing for right side...
        else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
            // If node has one child or no child..
            // Delete node
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // If node has two children
            // Root key is the smallest value in the right subtree..
            // Changing old tree to new tree
            // Becau of if we delete old node. Thid means that we delete the root node. So
            // we need to change the root node to new node
            root.key = minValue(root.right);

            // when the finding th smallest one. we can delete the smallest one...
            root.right = deleteNode(root.right, root.key);
        }
        return root;
    }

    // For finding the smallest value ...
    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

}
