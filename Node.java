
public class Node {
	private int estToFinish;	//estimate cost to the finish
	private String name;		//name of the node
	private boolean startNode;	//indicates if the node is the start node
	private boolean endNode;	//indicates if the node is the end node
	private boolean isObstacle;
	private Node toRight,toBelow;
	
	//constructor
	public Node(String name, int estToFinish, String s, String e) {
		this.estToFinish = estToFinish;
		this.name = name;
		if (s.equals("T")) {
			startNode = true;
		} else startNode = false;
		if (e.equals("T")) {
			endNode = true;
		} else endNode = false;
	}
	
	//retrieve the estimate to the finish
	public int getEstToFinish() {
		return estToFinish;
	}
	
	//retrieve the name
	public String getName() {
		return name;
	}
	
	public String isFirst() {
		if (startNode) return "T";
		else return "F";
	}
	
	public String isGoal() {
		if (endNode) return "T";
		else return "F";
	}
	
	public boolean isObstacle() {
		if (isObstacle) return true;
		else return false;
	}
	
	public void makeObstacle() {
		isObstacle = true;
	}
}
