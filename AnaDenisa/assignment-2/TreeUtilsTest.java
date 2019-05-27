import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.Test;

public class TreeUtilsTest {

  @BeforeClass
  public static void setUp() {
    TestTrees.buildTestTrees();
  }

  @Test
  public void testMediumBalancedTreeExistentValue() {
    Node<Integer> foundNodeRef =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.MEDIUM_BALANCED), 10);
    assertEquals(java.util.Optional.ofNullable(foundNodeRef.getData()), java.util.Optional.of(10));
  }

  @Test
  public void testMediumBalancedTreeNonexistentValue() {
    Node<Integer> foundNodeRef =
        TreeUtils.findANode(
            TestTrees.getTrees(TestTrees.MEDIUM_BALANCED), TestTrees.MEDIUM_SIZE + 1);
    assertNull(foundNodeRef);
  }

  @Test
  public void testMediumNotBalancedTreeExistentValue() {
    Node<Integer> foundNodeRef =
        TreeUtils.findANode(
            TestTrees.getTrees(TestTrees.MEDIUM_NOT_BALANCED), TestTrees.MEDIUM_SIZE / 2);
    assertEquals(
        java.util.Optional.ofNullable(foundNodeRef.getData()),
        java.util.Optional.of(TestTrees.MEDIUM_SIZE / 2));
  }

  @Test
  public void testMediumNotBalancedTreeNotExistentValue() {
    Node<Integer> foundNodeRef =
        TreeUtils.findANode(
            TestTrees.getTrees(TestTrees.MEDIUM_NOT_BALANCED), TestTrees.MEDIUM_SIZE + 1);
    assertNull(foundNodeRef);
  }

  @Test
  public void testBigBalancedTreeExistentValue() {
    Node<Integer> foundNodeRef =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.BIG_BALANCED), 10);
    assertEquals(java.util.Optional.ofNullable(foundNodeRef.getData()), java.util.Optional.of(10));
  }

  @Test
  public void testBigBalancedTreeNotExistentValue() {
    Node<Integer> foundNodeRef =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.BIG_BALANCED), TestTrees.BIG_SIZE + 1);
    assertNull(foundNodeRef);
  }

  @Test
  public void testBigNotBalancedTreeExistentValue() {
    Node<Integer> foundNodeRef =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.BIG_NOT_BALANCED), 10);
    assertEquals(java.util.Optional.ofNullable(foundNodeRef.getData()), java.util.Optional.of(10));
  }

  @Test
  public void testBigNotBalancedTreeNotExistentValue() {
    Node<Integer> foundNodeRef =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.BIG_NOT_BALANCED), TestTrees.BIG_SIZE + 1);
    assertNull(foundNodeRef);
  }

  @Test
  public void findTheAncestorsEmptyTree() {
    ArrayList<Node<Integer>> ancestors = TreeUtils.findTheAncestors(null, new Node<>(10));
    assertNull(ancestors);
  }

  private static void addNodeReference(int value, ArrayList<Node<Integer>> expectedAncestors) {
    expectedAncestors.add(
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), value));
  }

  @Test
  public void findTheAncestorsRandomExistingNode() {
    ArrayList<Node<Integer>> expectedAncestors = new ArrayList<>();

    /* get reference to target node with given value */
    Node<Integer> targetNodeRef =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 6);

    addNodeReference(6, expectedAncestors);
    addNodeReference(2, expectedAncestors);
    addNodeReference(3, expectedAncestors);
    addNodeReference(7, expectedAncestors);

    ArrayList<Node<Integer>> ancestors =
        TreeUtils.findTheAncestors(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), targetNodeRef);
    assertEquals(ancestors, expectedAncestors);
  }

  @Test
  public void findTheAncestorsOfNotExistingNode() {
    Node<Integer> targetNodeRef =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 10);

    ArrayList<Node<Integer>> ancestors =
        TreeUtils.findTheAncestors(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), targetNodeRef);
    assertNull(ancestors);
  }

  @Test
  public void findTheAncestorOfNullNode() {
    ArrayList<Node<Integer>> ancestors =
        TreeUtils.findTheAncestors(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), null);
    assertNull(ancestors);
  }

  @Test
  public void findTheAncestorsRootNode() {
    Node<Integer> targetNodeRef =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 7);

    ArrayList<Node<Integer>> ancestors =
        TreeUtils.findTheAncestors(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), targetNodeRef);

    assertNotNull(ancestors);
    assertEquals(ancestors.get(0), targetNodeRef);
    assertEquals(ancestors.size(), 1);
  }

  @Test
  public void lowestCommonAncestorTest() {
    /* get reference to target node1 */
    Node<Integer> targetNodeRef1 =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 6);

    /* get reference to target node2 */
    Node<Integer> targetNodeRef2 =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 5);

    /* get reference to expected LCA */
    Node<Integer> expectedLCA =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 3);

    Node<Integer> LCA =
        TreeUtils.lowestCommonAncestor(
            TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), targetNodeRef1, targetNodeRef2);
    assertEquals(LCA, expectedLCA);
  }

  @Test
  public void lowestCommonAncestorOfNodesFromDifferentSubtreesTest() {
    /* get reference to target node1 */
    Node<Integer> targetNodeRef1 =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 6);

    /* get reference to target node2 */
    Node<Integer> targetNodeRef2 =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 8);

    /* get reference to expected LCA */
    Node<Integer> expectedLCA =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 7);

    Node<Integer> LCA =
        TreeUtils.lowestCommonAncestor(
            TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), targetNodeRef1, targetNodeRef2);
    assertEquals(LCA, expectedLCA);
  }

  @Test
  public void lowestCommonAncestorOfSameNodeTest() {
    /* get reference to target node1 */
    Node<Integer> targetNodeRef1 =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 5);

    /* get reference to target node2 */
    Node<Integer> targetNodeRef2 =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 5);

    /* get reference to expected LCA */
    Node<Integer> expectedLCA =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 5);

    Node<Integer> LCA =
        TreeUtils.lowestCommonAncestor(
            TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), targetNodeRef1, targetNodeRef2);
    assertEquals(LCA, expectedLCA);
  }

  @Test
  public void lowestCommonAncestorOfRandomNodeAndRootTest() {
    /* get reference to target node1 */
    Node<Integer> targetNodeRef1 =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 5);

    /* get reference to target node2 */
    Node<Integer> targetNodeRef2 =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 7);

    /* get reference to expected LCA */
    Node<Integer> expectedLCA =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 7);

    Node<Integer> LCA =
        TreeUtils.lowestCommonAncestor(
            TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), targetNodeRef1, targetNodeRef2);
    assertEquals(LCA, expectedLCA);
  }

  @Test
  public void lowestCommonAncestorOfNotExistentNodeTest() {
    TreeUtils<Integer> treeUtilsObject = new TreeUtils<>();

    /* get reference to target node1 */
    Node<Integer> targetNodeRef1 =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 5);

    /* get reference to target node2 */
    Node<Integer> targetNodeRef2 =
        TreeUtils.findANode(TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), 14);

    Node<Integer> LCA =
        TreeUtils.lowestCommonAncestor(
            TestTrees.getTrees(TestTrees.ANCESTORS_EXAMPLE), targetNodeRef1, targetNodeRef2);
    assertNull(LCA);
  }
}
