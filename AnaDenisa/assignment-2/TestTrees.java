import java.util.ArrayList;

class TestTrees {
  static final int MEDIUM_SIZE = 30;
  static final int BIG_SIZE = 1000;
  static final int MEDIUM_BALANCED = 0;
  static final int MEDIUM_NOT_BALANCED = 1;
  static final int BIG_BALANCED = 2;
  static final int BIG_NOT_BALANCED = 3;
  static final int ANCESTORS_EXAMPLE = 4;

  private static Node<Integer> intBalancedTree;
  private static Node<Integer> intNotBalancedTree;
  private static Node<Integer> intVeryBigBalancedTree;
  private static Node<Integer> intVeryBigNotBalancedTree;
  private static Node<Integer> findTheAncestorsExampleTree;

  public static void buildTestTrees() {
    intBalancedTree = createIntTree(true, MEDIUM_SIZE);
    intNotBalancedTree = createIntTree(false, MEDIUM_SIZE);
    intVeryBigBalancedTree = createIntTree(true, BIG_SIZE);
    intVeryBigNotBalancedTree = createIntTree(false, BIG_SIZE);
    findTheAncestorsExampleTree = createAncestorsExampleTree();
  }

  public static Node<Integer> getTrees(int option) {
    switch (option) {
      case MEDIUM_BALANCED:
        return intBalancedTree;
      case MEDIUM_NOT_BALANCED:
        return intNotBalancedTree;
      case BIG_BALANCED:
        return intVeryBigBalancedTree;
      case BIG_NOT_BALANCED:
        return intVeryBigNotBalancedTree;
      case ANCESTORS_EXAMPLE:
        return findTheAncestorsExampleTree;
    }
    return null;
  }

  private static Node<Integer> createIntTree(boolean balanced, int nrNodes) {
    ArrayList<Node<Integer>> nodesList = new ArrayList<>();

    for (int i = 0; i < nrNodes; i++) nodesList.add(new Node<>(i));

    if (balanced) return TreeBuildersUtils.buildBalancedTree(nodesList);
    else {
      Node<Integer> root = nodesList.get(0);
      Node<Integer> currentNode = root;

      for (int i = 1; i < nrNodes; i++) {
        Node<Integer> newChildNode = nodesList.get(i);
        currentNode.setLeft(newChildNode);
        currentNode = newChildNode;
      }
      return root;
    }
  }

  private static Node<Integer> createAncestorsExampleTree() {
    Node<Integer> root = new Node<>(7);

    root.setLeft(new Node<>(3));
    root.setRight(new Node<>(4));
    root.getRightChild().setRight(new Node<>(8));
    root.getLeftChild().setLeft(new Node<>(2));
    root.getLeftChild().setRight(new Node<>(5));
    root.getLeftChild().getLeftChild().setLeft(new Node<>(1));
    root.getLeftChild().getLeftChild().setRight(new Node<>(6));

    return root;
  }
}
