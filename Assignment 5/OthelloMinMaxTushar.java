

public class OthelloMinMaxTushar extends OthelloPlayer{
	 	public int _depth;
	 	
	 	public OthelloMinMaxTushar(int depth) {
	 		_depth = depth;
	 	}
	   
	    public OthelloMove getMove(OthelloState state) {
	    		long t = System.currentTimeMillis();
	        OthelloMove m = MiniMaxDecision(state, _depth);
	        System.out.println("Mini Max"+(System.currentTimeMillis()-t));
	        return m;
	    }
	    
	    public int maxValue(OthelloState state, int level) {
    			if (level == 0) {
    				return state.score();
    			}
    			if (state.gameOver()) {
	    			return state.score();
	    		}
    			int v = -10000;
    			for (OthelloMove move: state.generateMoves()) {
    				v = max(v,minValue(state.applyMoveCloning(move), level-1));
    			}
    			return v;
	    }
	    
	    public int minValue(OthelloState state, int level) {
	    		if (level == 0) {
	    			return state.score();
	    		}
	    		if (state.gameOver()) {
	    			return state.score();
	    		}
	    		int v = 10000;
	    		for (OthelloMove move: state.generateMoves()) {
	    			v = min(v,maxValue(state.applyMoveCloning(move), level-1));
	    		}
	    		return v;
	    }

	    public OthelloMove MiniMaxDecision(OthelloState state, int p_depth ) {
	    		int v = -10000;
	    		OthelloMove m=null;
			for (OthelloMove move: state.generateMoves()) {
				int om = minValue(state.applyMoveCloning(move), p_depth-1);
				if (om>v) {
					m = move;
					v = om;
				}
			}
			return m;
	    }
	    
	    public int min(int m, int n) {
	    	if (m<n) {
	    		return m;
	    	}else {
	    		return n;
	    	}
	    }
	    public int max(int m, int n) {
	    	if (m<n) {
	    		return n;
	    	}else {
	    		return m;
	    	}
	    }
	    
	    
	public class node{
		public OthelloState newState;
		public OthelloMove moveMade;
		
		public node(OthelloState ot, OthelloMove mm) {
			newState = ot;
			moveMade = mm;
		}
		
		public OthelloMove getMove() {
			return moveMade;
		}
	}
}




