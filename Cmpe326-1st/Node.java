
import java.util.List;
import java.util.ArrayList;

class Node {

    // Node class has duplicates because of in the tree logic if the tree has the
    // same key, we didn't add the same key to the tree.
    // So If we see the same key, we add the same key to the duplicates list.
    int key;
    List<Node> duplicates;
    Node left, right;

    // Constructor
    public Node(int item) {
        key = item;
        duplicates = new ArrayList<>();
        left = right = null;
    }

}