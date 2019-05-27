import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class TreeUtils<T> {

  /*
     returns the reference to the node with searchedValue and null, if
     the node does not exist in the tree
  */
  static <T> Node<T> findANode(Node<T> root, T searchedValue) {
    if (root == null) return null;
    if (root.getData().equals(searchedValue)) return root;

    Node<T> searchedNodeLeft = findANode(root.getLeftChild(), searchedValue);
    Node<T> searchedNodeRight = findANode(root.getRightChild(), searchedValue);

    if (searchedNodeLeft != null) return searchedNodeLeft;

    if (searchedNodeRight != null) return searchedNodeRight;

    return null;
  }

  static <T> boolean findTheAncestorsHelper(
      Node<T> root, Node<T> targetNode, ArrayList<Node<T>> ancestors) {
    if (targetNode == null) return false;

    if (root == null) return false;

    if (root.getData().equals(targetNode.getData())) return true;

    boolean foundInLeftSubtree = findTheAncestorsHelper(root.getLeftChild(), targetNode, ancestors);
    boolean foundInRightSubtree =
        findTheAncestorsHelper(root.getRightChild(), targetNode, ancestors);
    boolean found = foundInLeftSubtree | foundInRightSubtree;

    if (found) {
      ancestors.add(root);
      return true;
    }

    return false;
  }

  /*
     returns an ArrayList of ancestor nodes of the targetNode or null if the node
     does not exist in the tree. Each node is the ancestor of itself
  */
  static <T> ArrayList<Node<T>> findTheAncestors(Node<T> root, Node<T> targetNode) {
    ArrayList<Node<T>> ancestors = new ArrayList<>();

    /* each node is ancestor of itself */
    ancestors.add(targetNode);
    if (findTheAncestorsHelper(root, targetNode, ancestors)) return ancestors;

    return null;
  }

  static <T> Node<T> lowestCommonAncestor(Node<T> root, Node<T> node1, Node<T> node2) {
    if (node1 == null || node2 == null) return null;

    ArrayList<Node<T>> ancestorsNode1 = findTheAncestors(root, node1);
    ArrayList<Node<T>> ancestorsNode2 = findTheAncestors(root, node2);

    if (ancestorsNode1 == null || ancestorsNode2 == null) return null;

    Node<T> LCA = null;
    Collections.reverse(ancestorsNode1);
    Collections.reverse(ancestorsNode2);

    Iterator<Node<T>> it1 = ancestorsNode1.iterator();
    Iterator<Node<T>> it2 = ancestorsNode2.iterator();

    /* find the last matching node in the common ancestors' list */
    while (it1.hasNext() && it2.hasNext()) {
      Node<T> elem1 = it1.next();
      Node<T> elem2 = it2.next();

      if (elem1.getData().equals(elem2.getData())) {
        LCA = elem1;
      } else break;
    }
    return LCA;
  }
}
