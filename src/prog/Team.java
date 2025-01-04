package prog;


import java.util.*;

//class Team
public class Team {
    	
    
	public  String name;
	public int points;
	
	// the players List 
	public List<Player> l ;
	
	
	//Team's Constructor 
	public Team(String name, int points) {
		this.name = name;
		this.points = points;
		 l= new LinkedList<Player>();
		
	}
	
        public String getName(){
	return name;
	}
      
	public int getPoints(){
	return points;
	}
	
	//returns the players list for a certain team
	public List<Player> getPlayers() {
		return l;
	}
	
	@Override
	public String toString() {
		return "" + name + " " + points + "";
	}

	//method getTeamSkill() - sums and returns the total skill of a Team 
	public int getTeamSkill() {
		int totalSkill = 0;
        for (Player player : l) {
            totalSkill += player.getSkill();
        }
        return totalSkill;
	}	
	
	
	
	}

