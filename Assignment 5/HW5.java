

/**
 *
 * @author santi
 */
public class HW5 {
    
    
    public static void main(String args[]) {
        // Create the game state with the initial position for an 8x8 board:
    		//int win =0;
        //int loose = 0;
    		//for (int i=0; i<10; i++) {
        OthelloState state = new OthelloState(8);
        OthelloPlayer players[] = {new OthelloRandomPlayer(), new MonteCarloTushar(1000)};
        
        //new MoteCarloTusharTime(1221);
        
        
        
        do{
            // Display the current state in the console:
            System.out.println("\nCurrent state, " + OthelloState.PLAYER_NAMES[state.nextPlayerToMove] + " to move:");
            System.out.print(state);
            
            // Get the move from the player:
            OthelloMove move = players[state.nextPlayerToMove].getMove(state);            
            System.out.println(move);
            state = state.applyMoveCloning(move);            
        }while(!state.gameOver());

        // Show the result of the game:
        System.out.println("\nFinal state with score: " + state.score());
        System.out.println(state);
        //if (state.score()<0) {
        	//win+=1;
        //}else {
        	//loose+=1;
        //}
        //System.out.println("You have won this many times so far, please acknowledge: " + win );
        //System.out.println("You have lost this many times so far, please acknowledge: " + loose );
        //}
        
        //System.out.println(win);
    }    
    
}
