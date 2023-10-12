package prog;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;





public class Main {

	public static void main(String[] args) {
		
		
		Team t1 = new Team("HomeTeam", 0);
		Team t2 = new Team("AwayTeam", 0);
		
		
		
		t1.l.add(new Player("a",90));
		t1.l.add(new Player("b", 80));
		t1.l.add(new Player("c",82));
		

		t2.l.add(new Player("d", 88));
		t2.l.add(new Player("e", 87));
		t2.l.add(new Player("f",85));
		
		
       

		Map<Integer, Team> m = new HashMap <Integer,  Team>();
		m.put(1, t1);
		m.put(2, t2);
		
		
		
		
		    try (Scanner sc = new Scanner (System.in)) {
				System.out.println("-----MENU------");
				System.out.println("1.Add a team");
				System.out.println("2.Delete a team");
				System.out.println("3.Add a player to a team");
				System.out.println("4.Delete a player from a team");
				System.out.println("5.Show teams componence");
				System.out.println("6.Simulate a home-away match between 2 teams");
				
		    
			
				
				int number = sc.nextInt();
				 switch(number) {
				
				case 1 :  System.out.println(" Enter the id, name and points of the team you want to add:");
					addTeam(m);
				break;
				
				case 2 : System.out.println("Enter the id of the team you want to delete:");
					deleteTeam(m);
				
				break;
				
				case 3 :   System.out.println("In which team whould you like to add a player?"
						+" 1 - HomeTeam or  2 - AwayTeam");
						
				           int x = sc.nextInt();
				           if(x==1) {
				        	   Team.addPlayer(t1.l);
				           }
				           else if(x==2) {
				        	   Team.addPlayer(t2.l);
				           }
				           
					        
				break;
				
				case 4 : System.out.println("From which team whould you like to delete a player?"
						+" 1 - HomeTeam or 2 - AwayTeam");
				
		           int y = sc.nextInt();
		           if(y==1) {
		        	   Team.deletePlayer(t1.l);
		           }
		           else if(y==2) {
		        	   Team.deletePlayer(t2.l);
		           }
		          
		        	   
				
				case 5 : 
						System.out.println("HomeTeam componence:" + t1.getPlayers()); 
						System.out.println("AwayTeam componence:" + t2.getPlayers());
						
					
				break;
				
				
				case 6: 
				        FootballGame(t1, t2);
				  break;
				 }
				 sc.close();
		    }
		   
			}
		
			
	   


		public static void FootballGame(Team homeTeam, Team awayTeam) {
		
		 System.out.println("Simulating 2 friendly matches between " + homeTeam.getName() +" and " + awayTeam.getName());
	     Random random = new Random();
	     
		 for(int i=0; i<1; i++)   {
			 int homeScore = random.nextInt(homeTeam.getTeamSkill() /30);
			 int awayScore = random.nextInt(awayTeam.getTeamSkill() /30);
		 
	    
	      System.out.println("Fist match: " + homeTeam.getName() + " - " + awayTeam.getName() + " " + homeScore + " - " + awayScore);
		 }
		 
		 for(int i=0; i<1; i++)   {
		     int homeScore = random.nextInt(homeTeam.getTeamSkill() /30);
		     int awayScore = random.nextInt(awayTeam.getTeamSkill() /30);
			 
		    
		      System.out.println("Second match: " + awayTeam.getName() + " - " + homeTeam.getName() + " " + homeScore + " - " + awayScore);
			 }
	}
		
		
		
			
			
	
	
		public static void displayTeams(Map<Integer, Team> m) {
			
		for(Map.Entry<Integer, Team> entry  : m.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
	}	
		
		public static void addTeam( Map<Integer, Team> m) {
	    	
			
			Scanner sc = new Scanner(System.in);
				
				
				
				int id = sc.nextInt();
				String name = sc.next();
				
				int points = sc.nextInt();
				Team t = new Team(name, points);
				m.put(id, t);
				
				for(Map.Entry<Integer, Team> entry  : m.entrySet()) {
					System.out.println(entry);
				}
				
				sc.close();
			}
			
		
	
		
	    	
		public static void deleteTeam(Map<Integer, Team> m) {
			Scanner sc = new Scanner(System.in) ;
			
				
				int id = sc.nextInt();
				
				for(Iterator<Map.Entry<Integer, Team>> it = m.entrySet().iterator(); it.hasNext();) {
					Map.Entry<Integer, Team> entry = it.next();
					if(entry.getKey() == id){
					
					it.remove();
					}
				}
				for(Map.Entry<Integer, Team> entry  : m.entrySet()) {
					System.out.println(entry);
				}
				
				sc.close();
			}
		}

		
		
		

		
	

