import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyTree {

    MyTreeNode root;

    MyTree() {
        //initialize
        this.root = new MyTreeNode(15);

        MyTreeNode child1 = new MyTreeNode(10);

        MyTreeNode grandChild1 = new MyTreeNode(7);
        grandChild1.addChild(5);
        grandChild1.addChild(8);
        child1.addChild(grandChild1);
        child1.addChild(14);


        MyTreeNode child2 = new MyTreeNode(25);
        MyTreeNode grandChild2 = new MyTreeNode(20);
        MyTreeNode grandChild3 = new MyTreeNode(29);
        grandChild2.addChild(19);
        grandChild2.addChild(26);
        grandChild3.addChild(27);
        grandChild3.addChild(30);
        child2.addChild(grandChild2);
        child2.addChild(grandChild3);

        this.root.addChild(child1);
        this.root.addChild(child2);

        /*this.root = new MyTreeNode(10);*/
    }

    private MyTreeNode searchClosest() {
        if (this.root != null) {
            List<MyTreeNode> nodes = new ArrayList<>(this.root.getChildren());
            if (this.root.getChildren().stream().allMatch(Objects::isNull)) {
                return root;
            } else {
                while (true) {
                    List<MyTreeNode> nextLevelNodes = new ArrayList<>();
                    for (MyTreeNode node : nodes) {
                        if (node.getChildren().size() > 0) {
                            nextLevelNodes.addAll(node.getChildren());
                        } else {
                            return node;
                        }
                    }
                    nodes = nextLevelNodes;
                }
            }
        }
        return null;
    }

    public void searchClosestLeaveAndPrint() {
        MyTreeNode node = searchClosest();
        print(node);
    }

    private void print(MyTreeNode node) {
        if (node == null) {
            System.out.println("Binary tree is null");
        } else {
            if (node.getParent() != null) {
                print(node.getParent());
            }
            System.out.println(node.getData());
        }
    }
}
