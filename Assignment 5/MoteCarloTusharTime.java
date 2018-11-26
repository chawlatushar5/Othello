import java.util.List;
import java.util.Random;

public class MoteCarloTusharTime extends OthelloPlayer{
	
	public long timeBound;
	public long endTime;
	
	
	public MoteCarloTusharTime(long timeInMillis){
		this.timeBound = timeInMillis;
	}

	@Override
	public OthelloMove getMove(OthelloState state) {
		this.endTime = System.currentTimeMillis()+timeBound;
		
		node root = new node(state);
		while (System.currentTimeMillis()<endTime) {
			node n = treePolicy(root);
			if (n!=null) {
				node node2 = defaultPolicy(n);
				if (node2!=null) {
				int node2Score = score(node2);
				backup(n, node2Score);
				}
			}
		}
		return root.bestChildNode().action;
		
	}
	
	
	void backup(node n, int score){
		n.NumberVisited +=1;
		n.AverageScore += (((n.NumberVisited-1)*n.AverageScore)+score)/n.NumberVisited;
		if (n.parent!=null) {
			backup(n.parent, score);
		}
	}
	
	

	private int score(node node2) {
		return node2.value.Updatedscore();
	}



	private node defaultPolicy(node n) {
		node current = n;
		OthelloState CurrentState = n.value;
		OthelloRandomPlayer rm = new OthelloRandomPlayer();
		while(!CurrentState.gameOver()) {
			if (System.currentTimeMillis()>=endTime) {
				return null;
			}
			OthelloMove m = rm.getMove(CurrentState);
			CurrentState = CurrentState.applyMoveCloning(m);
		}
		return new node(CurrentState);
	}



	public node treePolicy(node root) {
		if (root.value.gameOver()) {
			return root;
		}
		//try {
		List<OthelloMove> moves = root.value.generateMoves();
		
		
			for (OthelloMove m: moves) {
				OthelloState newState = root.value.applyMoveCloning(m);
				Boolean exists = checkExists(newState, root.children);
				if (exists==false) {
					
					node n =  new node(newState, root, m);
					root.children.add(n);
					return n;
				}
			}
			if(root.children.size()==0) {
				return root;
			}
			Random random = new Random();
			int nextInt = random.nextInt(100);
			
			if (nextInt <= 90) {
				return treePolicy(root.bestChildNode());
			}else {
				return treePolicy(root.getRandomChild());
			}
	}
	
	
	private Boolean checkExists(OthelloState newState, List<node> children) {
		if (children==null) {
			return false;
		}
		if (children.size()==0) {
			return false;
		}
		for (node n: children) {
			Boolean boardFound = false;
			Boolean checkBoards = checkBoards(n.value.board, newState.board);
			if (checkBoards==true) {
				return true;
			}
			
		}
		return false;
		
		
	}

	private Boolean checkBoards(int[][] board, int[][] board2) {
		int[][] a = board;
		int[][] b = board2;
		
		for (int m=0; m<a.length; m++) {
			for (int k=0; k<a[m].length; k++) {
				if (a[m][k]!=b[m][k]) {
					return false;
				}
			}
		}
		return true;
	}

}
