import java.util.*;

enum Color {
    RED, GREEN
}

abstract class Tree {
    private int value;
    private Color color;
    private int depth;

    Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();

    TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void addChild(Tree child) {
        children.add(child);
    }

    public ArrayList<Tree> getChildren() {
        return children;
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }
}

class TreeLeaf extends Tree {
    TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);
}

class SumInLeavesVisitor extends TreeVis {

    private int sum = 0;

    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
        // Nothing to do
    }

    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    private long product = 1;
    private static final int MOD = 1000000007;

    public int getResult() {
        return (int) product;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            product = (product * node.getValue()) % MOD;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            product = (product * leaf.getValue()) % MOD;
        }
    }
}

class FancyVisitor extends TreeVis {

    private int evenDepthSum = 0;
    private int greenLeafSum = 0;

    public int getResult() {
        return Math.abs(evenDepthSum - greenLeafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = sc.nextInt();
        }

        ArrayList<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;

            graph[u].add(v);
            graph[v].add(u);
        }

        Tree[] tree = new Tree[n];

        // Build tree using DFS
        buildTree(0, -1, 0, values, colors, graph, tree);

        TreeVis visitor1 = new SumInLeavesVisitor();
        TreeVis visitor2 = new ProductOfRedNodesVisitor();
        TreeVis visitor3 = new FancyVisitor();

        tree[0].accept(visitor1);
        tree[0].accept(visitor2);
        tree[0].accept(visitor3);

        System.out.println(visitor1.getResult());
        System.out.println(visitor2.getResult());
        System.out.println(visitor3.getResult());

        sc.close();
    }

    static void buildTree(
            int current,
            int parent,
            int depth,
            int[] values,
            int[] colors,
            ArrayList<Integer>[] graph,
            Tree[] tree) {

        Color color = (colors[current] == 0) ? Color.RED : Color.GREEN;

        ArrayList<Integer> children = new ArrayList<>();

        for (int next : graph[current]) {
            if (next != parent) {
                children.add(next);
            }
        }

        if (children.isEmpty()) {

            tree[current] =
                new TreeLeaf(values[current], color, depth);

        } else {

            TreeNode node =
                new TreeNode(values[current], color, depth);

            tree[current] = node;

            for (int child : children) {
                buildTree(
                    child,
                    current,
                    depth + 1,
                    values,
                    colors,
                    graph,
                    tree
                );

                node.addChild(tree[child]);
            }
        }
    }
}
