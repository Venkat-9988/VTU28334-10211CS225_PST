import java.util.*;

class ThroneInheritance {
    private String king;
    private Map<String, List<String>> children;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.children = new HashMap<>();
        this.dead = new HashSet<>();
    }
    
    public void birth(String parentName, String childName) {
        children.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String current, List<String> order) {
        // Only include in inheritance order if the person is alive
        if (!dead.contains(current)) {
            order.add(current);
        }
        
        // Traverse all children in order of birth (pre-order traversal)
        List<String> childList = children.get(current);
        if (childList != null) {
            for (String child : childList) {
                dfs(child, order);
            }
        }
    }
}
