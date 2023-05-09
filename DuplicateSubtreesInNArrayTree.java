import java.util.*;

class TreeNode {
    int val;
    List<TreeNode> children;

    TreeNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class DuplicateSubtreesInNArrayTree {
    public static void main(String[] args) {
        // Construct the N-ary tree for testing
        TreeNode root = new TreeNode(1);
        TreeNode child1 = new TreeNode(2);
        TreeNode child2 = new TreeNode(3);
        TreeNode child3 = new TreeNode(4);
        TreeNode grandchild1 = new TreeNode(5);
        TreeNode grandchild2 = new TreeNode(6);
        TreeNode grandchild3 = new TreeNode(7);

        root.children.add(child1);
        root.children.add(child2);
        child1.children.add(child3);
        child3.children.add(grandchild1);
        child3.children.add(grandchild2);
        child3.children.add(grandchild3);

        System.out.println("Number of duplicate subtrees: " + findDuplicateSubtrees(root));
    }

    public static int findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> subtreeMap = new HashMap<>();
        countSubtrees(root, subtreeMap);
        int duplicates = 0;

        for (int count : subtreeMap.values()) {
            if (count > 1) {
                duplicates += count - 1;
            }
        }

        return duplicates;
    }

    private static String countSubtrees(TreeNode node, Map<String, Integer> subtreeMap) {
        if (node == null) {
            return "#";
        }

        StringBuilder subtree = new StringBuilder();
        subtree.append(node.val);
        for (TreeNode child : node.children) {
            subtree.append(",");
            subtree.append(countSubtrees(child, subtreeMap));
        }

        String subtreeStr = subtree.toString();
        subtreeMap.put(subtreeStr, subtreeMap.getOrDefault(subtreeStr, 0) + 1);

        return subtreeStr;
    }
}
