class BinaryTreeInsertion {
  class Node {
      int value;
      Node left, right;

      Node(int value) {
          this.value = value;
          left = right = null;
      }
  }

  Node root;

  void insert(int value) {
      root = insertRec(root, value);
  }

  Node insertRec(Node root, int value) {
      if (root == null) {
          root = new Node(value);
          return root;
      }
      if (value < root.value) root.left = insertRec(root.left, value);
      else if (value > root.value) root.right = insertRec(root.right, value);
      return root;
  }

  void inorder() {
      inorderRec(root);
  }

  void inorderRec(Node root) {
      if (root != null) {
          inorderRec(root.left);
          System.out.print(root.value + " ");
          inorderRec(root.right);
      }
  }

  public static void main(String[] args) {
      BinaryTreeInsertion tree = new BinaryTreeInsertion();
      tree.insert(10);
      tree.insert(5);
      tree.insert(15);
      tree.inorder(); // Output: 5 10 15
  }
}
