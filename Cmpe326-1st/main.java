import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();
        // User input is taken until the end of
        while (scan.hasNextLine()) {
            // The input is split by space
            String input = scan.nextLine();
            // The first part of the input is the command
            String[] parts = input.split(" ");
            // The command is stored in the variable
            String order = parts[0];

            switch (order) {
                case "CONSTRUCT":
                    // We are taking like CONSTRUCT [1,2,3,45,56,4343,43543,334224] So we are doing
                    // like this..
                    // Deleting the commas extra spaces and brackets
                    String constructInput = parts[1].substring(1, parts[1].length() - 1);
                    String[] constructArray = constructInput.split(",");
                    // We are adding the elements to the tree
                    // But,, in the first we are taking nodes which string type. So we are
                    // converting to integer type...
                    for (String num : constructArray) {
                        tree.insert(Integer.parseInt(num.trim()));
                    }
                    break;
                case "INSERT":
                    // Again same thing, we are taking the second part of the input and converting
                    // to integer type...
                    int insertValue = Integer.parseInt(parts[1]);
                    // Adding the tree..
                    tree.insert(insertValue);
                    System.out.println("The parent of " + insertValue + " is " + tree.findParent(insertValue));
                    break;
                case "LIST":
                    // Only calling in BinarySearchTree that list functions(recursive one)
                    tree.List();
                    break;
                case "PARENT":
                    // We are taking the second part of the input and converting to integer type...
                    int parentValue = Integer.parseInt(parts[1]);
                    int p = tree.findParent(parentValue);
                    // If the parent is -1, it means that the node is the root node
                    if (p == -1) {
                        System.out.println("It is a root node");
                    } else {
                        System.out.println("The parent of " + parentValue + " is " + p);
                    }
                    break;
                case "DELETE":
                    // These are little bit confusing.. İf the user want to delete the node,
                    // current node will equals old root so comparing them. After that if the root
                    // is changed, we are printing the new root.
                    int deleteValue = Integer.parseInt(parts[1]);
                    int oldRoot = tree.root.key;
                    tree.root = tree.deleteNode(tree.root, deleteValue);
                    if (oldRoot != tree.root.key) {
                        System.out.println("Root changed. The new root is " + tree.root.key);
                    }
                    break;
                // Default...
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
}