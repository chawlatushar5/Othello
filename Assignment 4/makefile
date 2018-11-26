JAVAC = javac
JRE = java
.PHONY: default clean
default: all ;
all: OthelloMove.class OthelloPlayer.class OthelloRandomPlayer.class OthelloState.class OthelloMinMaxTushar.class OthelloAlphaBetaTushar.class OthelloTournamentTushar.class HW4.class
OthelloMove.class: OthelloMove.java
	$(JAVAC) OthelloMove.java
OthelloPlayer.class: OthelloPlayer.java
	$(JAVAC) OthelloPlayer.java
OthelloRandomPlayer.class: OthelloRandomPlayer.java
	$(JAVAC) OthelloRandomPlayer.java
OthelloState.class: OthelloState.java
	$(JAVAC) OthelloState.java
OthelloMinMaxTushar.class: OthelloMinMaxTushar.java
	$(JAVAC) OthelloMinMaxTushar.java
OthelloAlphaBetaTushar.class: OthelloAlphaBetaTushar.java
	$(JAVAC) OthelloAlphaBetaTushar.java
OthelloTournamentTushar.class: OthelloTournamentTushar.java
	$(JAVAC) OthelloTournamentTushar.java
HW4.class: HW4.java
	$(JAVAC) HW4.java
clean:
	rm HW4.class OthelloTournamentTushar.class OthelloState.class OthelloAlphaBetaTushar.class OthelloMinMaxTushar.class OthelloRandomPlayer.class OthelloPlayer.class OthelloMove.class
