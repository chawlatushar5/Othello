import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class node {
		node parent;
		List<node> children;
		OthelloMove action;
		int NumberVisited;
		int AverageScore;
		OthelloState value;
		
		public node (OthelloState ostate) {
			
			this.parent = null;
			this.action = null;
			this.NumberVisited = 0;
			this.AverageScore = 0;
			this.value = ostate;
			this.children = new ArrayList<>();
		}
		public node (OthelloState ostate, node parent, OthelloMove move) {
			
			this.parent = parent;
			this.action = move;
			this.NumberVisited = 0;
			this.AverageScore = 0;
			this.value = ostate;
			this.children = new ArrayList<>();
		}
		
		public node bestChildNode() {
			
			//value.nextPlayerToMove==0
			int n = -1218928913;
			int max = 1218928913;
			node bestNode=this;
			node worstNode=this;
			for (node m : this.children) {
				if (m.AverageScore>n) {
					bestNode = m;
					n = m.AverageScore;
				}
				if (m.AverageScore< max) {
					worstNode = m;
					max = m.AverageScore;
				}
			}
			if(value.nextPlayerToMove==0) {
				return bestNode;
			}else {
				return worstNode;
			}
			//return bestNode;
		}
		
		public node getRandomChild() {
//			if (children.size()==0) {
//				return this;
//			}
			Random random = new Random();
			int nextInt = random.nextInt(this.children.size());
			return this.children.get(nextInt);
		}
		
		
}
