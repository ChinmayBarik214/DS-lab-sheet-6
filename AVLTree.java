public class AVLTree {
  class Node {
    int value, height;
    Node left, right;

    Node(int value) {
      this.value = value;
      height = 1;
    }
  }

  Node root;

  int height(Node n) {
    return n == null ? 0 : n.height;
  }

  int balanceFactor(Node n) {
    return n == null ? 0 : height(n.left) - height(n.right);
  }

  Node rightRotate(Node y) {
    Node x = y.left;
    Node T = x.right;

    x.right = y;
    y.left = T;

    y.height = Math.max(height(y.left), height(y.right)) + 1;
    x.height = Math.max(height(x.left), height(x.right)) + 1;

    return x;
  }

  Node leftRotate(Node x) {
    Node y = x.right;
    Node T = y.left;

    y.left = x;
    x.right = T;

    x.height = Math.max(height(x.left), height(x.right)) + 1;
    y.height = Math.max(height(y.left), height(y.right)) + 1;

    return y;
  }

  Node insert(Node node, int value) {
    if (node == null)
      return new Node(value);

    if (value < node.value)
      node.left = insert(node.left, value);
    else if (value > node.value)
      node.right = insert(node.right, value);
    else
      return node;

    node.height = 1 + Math.max(height(node.left), height(node.right));

    int balance = balanceFactor(node);

    if (balance > 1 && value < node.left.value)
      return rightRotate(node);
    if (balance < -1 && value > node.right.value)
      return leftRotate(node);
    if (balance > 1 && value > node.left.value) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }
    if (balance < -1 && value < node.right.value) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }

    return node;
  }

  void insert(int value) {
    root = insert(root, value);
  }

  void printRoot() {
    System.out.println("Root after balancing: " + root.value);
  }

  public static void main(String[] args) {
    AVLTree tree = new AVLTree();
    tree.insert(30);
    tree.insert(20);
    tree.insert(10);
    tree.printRoot(); // Output: Root after balancing: 20
  }
}
