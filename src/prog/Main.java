package prog;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;





public class Main {

	public static void main(String[] args) {
		
		
		//we create 4 new objects of type Team (they all have 0 points now)
		Team t1 = new Team("Real Madrid", 0);
		Team t2 = new Team("Barcelona", 0);
		Team t3 = new Team("Juventus", 0);
		Team t4 = new Team("PSG", 0);
		
		//we add 3 players to each team
		//each player has a name and a his own skill
		t1.l.add(new Player("a1",90));
		t1.l.add(new Player("b1", 89));
		t1.l.add(new Player("c1",82));
		

		t2.l.add(new Player("a2", 88));
		t2.l.add(new Player("b2", 87));
		t2.l.add(new Player("c2",85));
		
		t3.l.add(new Player("a3", 84));
		t3.l.add(new Player("b3", 82));
		t3.l.add(new Player("c3",81));
		
		t4.l.add(new Player("a4", 86));
		t4.l.add(new Player("b4", 84));
		t4.l.add(new Player("c4",83));
		
		//we create a new list and add all the teams to it
		LinkedList<Team> teams = new LinkedList<Team>();
		teams.add(t1); teams.add(t2); teams.add(t3); teams.add(t4);
        
        //we add the teams in a HashMap also
		Map<Integer, Team> m = new HashMap <Integer,  Team>();
		m.put(1, t1);
		m.put(2, t2);
		m.put(3, t3);
		m.put(4, t4);
		
		
	
	
		 
			
			try {	
			  
				System.out.println("-----MENU------");
				System.out.println("1.Add a team");
				System.out.println("2.Delete a team");
				System.out.println("3.Add a player to a team");
				System.out.println("4.Delete a player from a team");
				System.out.println("5.Show teams componence");
				System.out.println("6.Simulate a home-away match between 2 teams");
				System.out.println("7.Simulate a Football League and show the final standings");
			    
			
				//we use the Scanner class to get user input
				Scanner sc = new Scanner(System.in);
				int number = sc.nextInt();
			
				 switch(number) {
				
				case 1 :  System.out.println(" Enter the id, name and points of the team you want to add:");
					addTeam(m);
				break;
				
				case 2 : System.out.println("Enter the id of the team you want to delete: (1,2,3,4)");
					deleteTeam(m);
				
				break;
				
				case 3 :   System.out.println("In which team whould you like to add a player?"
						+" 1 - Real Madrid,  2 - Barcelona") ;
						
				           int x = sc.nextInt();
				           if(x==1) {
				        	   Team.addPlayer(t1.l);
				           }
				           else if(x==2) {
				        	   Team.addPlayer(t2.l);
				           }
				           
				           
					        
				break;
				
				case 4 : System.out.println("From which team whould you like to delete a player?"
						+" 1 - Real Madrid or 2 - Barcelona");
				
		           int y = sc.nextInt();
		           if(y==1) {
		        	   Team.deletePlayer(t1.l);
		           }
		           else if(y==2) {
		        	   Team.deletePlayer(t2.l);
		           }
		          
		        break;	   
				
				case 5 : 
						System.out.println("Real Madrid componence:" + t1.getPlayers()); 
						System.out.println("Barcelona componence:" + t2.getPlayers());
						System.out.println("Juventus componence:" + t3.getPlayers()); 
						System.out.println("PSG componence:" + t4.getPlayers());
					
				break;
				
				
				case 6: 
					    
				        FriendlyMatch(t1, t2);
				  break;
				  
				case 7: 
			        FootballLeague(teams);
			  break;
				 }
				 sc.close();
			}
			
	catch(NoSuchElementException e) {
			}	
		}
	
	
	//add a new team to the Map
	public static void addTeam( Map<Integer, Team> m) {
    	
		
		Scanner sc = new Scanner(System.in);
		
		
		int id = sc.nextInt();
		String name = sc.next();
		
		int points = sc.nextInt();
		
		//we make a new Team object and add it to the Map
		Team t = new Team(name, points);
		m.put(id, t);
		
		//displays the Map after addition
		for(Map.Entry<Integer, Team> entry  : m.entrySet()) {
			System.out.println(entry);
		}
		
		sc.close();
	}
	


	// delete a team from the Map
	
	public static void deleteTeam(Map<Integer, Team> m) {
		Scanner sc = new Scanner(System.in) ;
	
		
		int id = sc.nextInt();
		
		// we iterate through the HashMap and if the id we entered matches an existing key in the Map we remove that certain key 
		for(Iterator<Map.Entry<Integer, Team>> it = m.entrySet().iterator(); it.hasNext();) {
			Map.Entry<Integer, Team> entry = it.next();
			if(entry.getKey() == id){
			
			it.remove();
			}
		}
		//we display the new Map 
		for(Map.Entry<Integer, Team> entry  : m.entrySet()) {
			System.out.println(entry);
		}
		
		sc.close();
	}

		//method to simulate the score in a football match between 2 selected teams 
		public static void FriendlyMatch(Team homeTeam, Team awayTeam) {
		
		 System.out.println("Simulating 2 friendly matches between " + homeTeam.getName() +" and " + awayTeam.getName());
		 
	     Random random = new Random();
	     
		 for(int i=0; i<1; i++)   {
			 
			 //here we call the getTeamSkill() method from class Team, divide it by 40 and use the Random class to get the score(goals) of the homeTeam
			 int homeScore = random.nextInt(homeTeam.getTeamSkill() /40);
			 //same for the away team
			 int awayScore = random.nextInt(awayTeam.getTeamSkill() /40);
		 
	    //we display the result
	      System.out.println("First match: " + homeTeam.getName() + " - " + awayTeam.getName() + " " + homeScore + " - " + awayScore);
		 }
		 
		 
		 //same for the second match
		 for(int i=0; i<1; i++)   {
		     int homeScore = random.nextInt(homeTeam.getTeamSkill() /40);
		     int awayScore = random.nextInt(awayTeam.getTeamSkill() /40);
			 
		    
		      System.out.println("Second match: " + awayTeam.getName() + " - " + homeTeam.getName() + " " + homeScore + " - " + awayScore);
			 }
	}
		
		//method to simulate an entire football league with the added teams
		public static void FootballLeague(LinkedList<Team> teams) {
			
		
			Random random = new Random();
			
			//we define a LinkedHashMap for the final standings in the league
			Map<String, Integer> standings = new LinkedHashMap<String, Integer>();
			
		    
		     System.out.println("First round matches:"); 
		     
		     //we loop through the list and make all the teams play each other
			 for(int i=0; i<teams.size(); i++)   {
				 for(int j=i+1 ; j<teams.size(); j++) {
					 
				//we use the same formula as above to get the scores 
				 int homeScore = random.nextInt(teams.get(i).getTeamSkill() /40);
				 int awayScore = random.nextInt(teams.get(j).getTeamSkill() /40);
				   
				 //we make a points system 
				 if(homeScore>awayScore) {
					 
					 //winning team gets 3 points 
					 teams.get(i).points += 3;
				 }
				 else if (homeScore < awayScore) {
					 teams.get(j).points +=3;
				 }
				 else if(homeScore == awayScore) {
					 
					 //if the final score is a draw each team gets 1 point
					 teams.get(i).points += 1; 
					 teams.get(j).points += 1;
				 }
				 //display results
		      System.out.println(" " + teams.get(i).getName() + " - " + teams.get(j).getName() + " " + homeScore + " - " + awayScore);
			 }
				 
			 }
			 //same for the second round of matches
			 System.out.println("Second round matches:");
			 for(int i=0; i<teams.size(); i++)   {
				 for(int j=i+1 ; j<teams.size(); j++) {
				 int homeScore = random.nextInt(teams.get(i).getTeamSkill() /40);
				 int awayScore = random.nextInt(teams.get(j).getTeamSkill() /40);
				 
				 if(homeScore < awayScore) {
					 teams.get(i).points += 3;
				 }
				 else if (homeScore > awayScore) {
					 teams.get(j).points +=3;
				 }
				 else if(homeScore == awayScore) {
					 teams.get(i).points += 1; 
					 teams.get(j).points += 1;
				 }
			      
			      System.out.println(" " + teams.get(j).getName() + " - " +teams.get(i).getName() + " " + homeScore + " - " + awayScore);
				 }
			 }
			
			
		     //after the rounds are played we add the name and points of the teams in the LinkedHashMap  
			 for(int k=0; k<teams.size(); k++)   {
					//System.out.println(teams.get(k).name + " " + "-" + " " + teams.get(k).points);
					
					standings.put(teams.get(k).name, teams.get(k).points);
			 }
			 
			 // we use the stream class to compare Map values (points)
			 Map<String,Integer> finalStandings =  
					 standings.entrySet()
			        .stream()
			        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
			        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
			 
			 
			 
			 
			 System.out.println("_____________");
			 System.out.println("Final Standings:");
			 System.out.println("_____________");
			 
			 //we display the final standings
			 for(Map.Entry<String, Integer> entry  : finalStandings.entrySet()) {
					System.out.println(entry.getKey() + " " + entry.getValue());
			 }  
			 	
		
	}	
		
		
	}

		
		
		

		
	

