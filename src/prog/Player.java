package prog;

//class Player
public class Player {

	
	public String name;
    public int skill;
   
    
 // Player's Constructor
	public Player(String name, int skill) {
		
		this.name = name;
		this.skill = skill;
		
		
		
	}
    //returns the player's name
	public String getName() {
		return name;
	}



   
	public void setName(String name) {
		this.name = name;
	}

	//returns the player's skill
	public int getSkill() {
		return skill;
	}



   
	public void setSkill(int skill) {
		this.skill = skill;
	}
	
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", skill=" + skill + "]";
	}

}
