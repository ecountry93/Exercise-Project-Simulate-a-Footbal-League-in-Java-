package prog;


import java.util.*;
public class Team {
    	

	public String name;
	public int points;
	
	public List<Player> l ;
	
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

	public List<Player> getPlayers() {
		return l;
	}
	
	@Override
	public String toString() {
		return "" + name + " " + points + "";
	}

	public int getTeamSkill() {
		int totalSkill = 0;
        for (Player player : l) {
            totalSkill += player.getSkill();
        }
        return totalSkill;
	}	
	
	
	public static void addPlayer( List<Player> l) {
    	
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the player's name and skill:");
		
			String playerName = sc.next();
			int playerSkill= sc.nextInt();
			Player e = new Player(playerName, playerSkill);
			l.add(e);
			
			sc.close();
		}
	
		l.forEach(n-> System.out.println(n));
	}
	
	
	
	public static void deletePlayer(List<Player> l) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Select the name of the player you want to delete:");
			
			String name = sc.next();
			for(Player p : l) {
				if(p.getName().equals(name)) {
					l.remove(p);
					
				}
			}
			
			sc.close();
	}
		
		   l.forEach(n-> System.out.println(n));
	}

	
	}

