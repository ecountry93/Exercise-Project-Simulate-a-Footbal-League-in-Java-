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
	
	//method adds a new player to a certain team
	public static void addPlayer( List<Player> l) {
    	
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the player's name and skill:");
		
			String playerName = sc.next();
			int playerSkill= sc.nextInt();
			
			//we create a new object (type Player) and add it to the list of players
			Player p = new Player(playerName, playerSkill);
			l.add(p);
			
			sc.close();
		}
		
		//displays the list after the add operation
		l.forEach(n-> System.out.println(n));
	}
	
	
	//method deletes a player from a certain team
	public static void deletePlayer(List<Player> l) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Select the name of the player you want to delete:");
			
			
			String name = sc.next();
			
			//finds the player whose name was set for deletion and removes it from the list
			
			for(int i = 0; i<l.size(); i++) {
				if(l.get(i).getName().equals(name)) {
					l.remove(l.get(i));
					
				}
			}
			
			sc.close();
	}
		//displays the list after the delete operation
		   l.forEach(n-> System.out.println(n));
	}

	
	}

