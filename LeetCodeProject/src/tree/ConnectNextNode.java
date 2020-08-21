package tree;

import java.util.ArrayList;
import java.util.List;

public class ConnectNextNode {

    public Node connect(Node root) {
        if (root == null) return null;

        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        int levelTotal = 1;
        int addNum = 0;
        while (!nodes.isEmpty()) {
            while (levelTotal > 0) {
                Node node = nodes.get(0);
                if (levelTotal == 1) {
                    // 设置每一层最后一个节点的next为null
                    node.next = null;
                } else {
                    node.next = nodes.get(1);
                }
                if (node.left != null) {
                    nodes.add(node.left);
                    nodes.add(node.right);
                    addNum += 2;
                }
                nodes.remove(0);
                levelTotal--;
            }

            levelTotal = addNum;
            addNum = 0;
        }

        return root;
    }
}
