package org.unioulu.tol.sqat2015.planetExplorer;

// Before submitting write your ID and finish time here. Your ID is written on project description sheets.
// ID: 132
// Finish time:
public class PlanetExplorer {
	int planetWidth;
	int planetHeight;
	String obstacles;
	
	int x;
	int y;
	int direction;
	
	public static int NORTH = 0;
	public static int EAST = 1;
	public static int SOUTH = 2;
	public static int WEST = 3;
	
	public PlanetExplorer(int x, int y, String obstacles){
	/*	x and y represent the size of the grid.
	 *  Obstacles is a String formatted as follows: "(obs1_x,obs1_y)(obs2_x,obs2_y)...(obsN_x,obsN_y)" with no white spaces. 
	 *  
		Example use:
		PlanetExplorer explorer = new PlanetExplorer(100,100,"(5,5)(7,8)")  //A 100x100 grid with two obstacles at coordinates (5,5) and (7,8) 
	 */
		
		planetWidth = x;
		planetHeight = y;
		this.obstacles = obstacles;
		
		this.x = 0;
		this.y = 0;
		this.direction = 0;
	}
	
	public String executeCommand(String command){
		
		/* The command string is composed of "f" (forward), "b" (backward), "l" (left) and "r" (right)
		 * Example: 
		 * The explorer is on a 100x100 grid at location (0, 0) and facing NORTH. 
		 * The explorer is given the commands "ffrff" and should end up at (2, 2) facing East.
		 
		 * The return string is in the format: "(pos_x,pos_y,facing)(obs1_x,obs1_y)(obs2_x,obs2_y)..(obsN_x,obsN_y)" 
		 * Where pos_x and pos_y are the final coordinates, facing is the current direction the explorer is pointing to (N,S,W,E).
		 * The return string should also contain a list of coordinates of the encountered obstacles. No white spaces.
		 */

		for(int i = 0; i < command.length(); i++) {
			char commandIterator = command.charAt(i);
			
			if(commandIterator == 'f') {
				switch(direction) {
				case 0:
					x++;
					break;
				case 1:
					y++;
					break;
				case 2:
					x--;
					break;
				case 3:
					y--;
					break;
				}
			} else if(commantIterator == 'b') { 
		} else if(commandIterator == 'r') {
				turnExplorer("r");;
			} else if(commandIterator == 'l') {
				turnExplorer("l");
			}
		}
		return getLocationString();
	}
	
	private void turnExplorer(String turnDirection) {
		if(turnDirection.equals("r")) {
			direction++;
			if(direction > 3) {
				direction = 0;
			}
		} else if(turnDirection.equals("l")) {
			direction--;
			if(direction < 0) {
				direction = 3;
			}
		}
	}
	
	private String getLocationString() {
		switch(direction) {
		case 0:
			return x+","+y+",N";
		case 1:
			return x+","+y+",E";
		case 2:
			return x+","+y+",S";
		case 3:
			return x+","+y+",W";
		default:
			return x+","+y+",ERROR";
		}
	}
	
	public String getPlanetGridSize() {
		return planetWidth +"x" + planetHeight;
	}
}
