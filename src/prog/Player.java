package prog;

public class Player {

	
	public String name;
    public int skill;
   
    
	
	public Player(String name, int skill) {
		
		this.name = name;
		this.skill = skill;
		
		
		
	}

	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}


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
