
public class OthelloTournamentTushar extends OthelloPlayer{
public int _depth;
public int time;
public long startTime;
public long endTime;
public long timeBound;


 	
 	public OthelloTournamentTushar(int timeInMilliSeconds) {
 		timeBound = timeInMilliSeconds;
 	}
   
    public OthelloMove getMove(OthelloState state) {
    		_depth=1;
    		endTime = System.currentTimeMillis()+timeBound;
//    		System.out.println(System.currentTimeMillis());
    		OthelloMove m=null;
    		while(System.currentTimeMillis()<endTime) {
    			OthelloMove c = MiniMaxDecision(state, _depth);
    			if (c!=null) {
    				m=c;
    			}
    			_depth++;
    		}
//    		System.out.println(_depth);
//    		System.out.println(System.currentTimeMillis());
    		return m;
    }
    
    public Integer maxValue(OthelloState state, Integer level, Integer alpha, Integer beta) {
			if (level == 0) {
				return state.score();
			}
			if (state.gameOver()) {
    				return state.score();
    			}
			if (System.currentTimeMillis()>=timeBound) {
				return null;
			}
			int v = -10000;
			for (OthelloMove move: state.generateMoves()) {
				v = max(v,minValue(state.applyMoveCloning(move), level-1, alpha, beta));
    			if (alpha<v) {
    				alpha = v;
    			}
    			if (v>=beta) {
    				return v;
    			}
			}
			return v;
    }
    
    public Integer minValue(OthelloState state, Integer level, Integer alpha, Integer beta) {
    		if (level == 0) {
    			return state.score();
    		}
    		if (state.gameOver()) {
    			return state.score();
    		}
		if (System.currentTimeMillis()>=timeBound) {
			return null;
		}
    		int v = 10000;
    		for (OthelloMove move: state.generateMoves()) {
    			v = min(v,maxValue(state.applyMoveCloning(move), level-1, alpha, beta));
    			if (beta>v) {
    				beta=v;
    			}
    			if (beta<alpha) {
    				return v;
    			}
    			
    		}
    		return v;
    }

    public OthelloMove MiniMaxDecision(OthelloState state, int p_depth ) {
    		int v = -10000;
    		OthelloMove m=null;
		for (OthelloMove move: state.generateMoves()) {
			Integer om = minValue(state.applyMoveCloning(move), p_depth-1, -100000, 100000 );
			if (om==null) {
				return null;
			}
			if (om>v) {
				m = move;
				v = om;
			}
		}
		return m;
    }
    
    public Integer min(Integer m, Integer n) {
    	if (m==null || n==null) {
    		return null;
    	}
    	if (m<n) {
    		return m;
    	}else {
    		return n;
    	}
    }
    public Integer max(Integer m, Integer n) {
    	if (m==null || n==null) {
    		return null;
    	}
    	if (m<n) {
    		return n;
    	}else {
    		return m;
    	}
    }
}
