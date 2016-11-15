/*
 * Project
 * John Brady
 * COMP1A-X
 * R00155390
 */

import java.util.Scanner;

public class ProjectJohnBrady {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// prints a welcome message
		System.out.println(
				"****************************************************\n"
				+ "* Welcome to CIT's Round Robin Football Tournament *\n"
				+ "****************************************************");
		
		Scanner input = new Scanner(System.in);
		
		// Initialising variables and constants
		final int LEASTAMOUNTOFTEAMS = 2;
		final int POINTSFORWIN = 3;
		final int POINTSFORDRAW = 1;
		final int POINTSFORLOSS = 0;
		final double TICKETPRICE = 5.5;
		
		String teamNames = "";
		String winningTeam = "";
		String teamName = "";
		String otherTeamName = "";
		String table = "Team Won Drawn Lost Total";
		
		int noOfTeams = 0;
		int result = 0;
		int gamesPerTeam = 0;
		int totalGames = 0;
		int gamesLeft = 0;
		int attendancePerGame = 0;
		int totalAttendance = 0;
		int count = 1;
		int gameCounter = 1;
		int teamNo = 0;
		int gamesWon = 0;
		int gamesDrawn = 0;
		int gamesLost = 0;
		int totalPoints = 0;
		int maxPoints = 0;
		
		double averageAttendance = 0;
		double prize = 0;
		double takingsPerGame = 0;
		double totalTakings = 0;

		// loop to get the number of teams in competition
		while(noOfTeams < LEASTAMOUNTOFTEAMS){
			System.out.print("Enter how many teams are parcipitating(must be at-least 2): ");
			noOfTeams = input.nextInt();
			input.nextLine();
			// if input is less than the minimum amount of teams allowed
			if(noOfTeams < LEASTAMOUNTOFTEAMS){
				// print error message
				System.out.println("Enter a valid number of teams.\n");
			}
		}
		
		gamesPerTeam = noOfTeams;
		totalGames = noOfTeams * gamesPerTeam / 2;

		// loop to get each teams info
		for(int i = 1; i <= noOfTeams; i++){
			totalPoints = 0;
			gamesWon = 0;
			gamesDrawn = 0;
			gamesLost = 0;
			// ask user for teams name
			System.out.printf("Enter Team %d's name: ", i);
			// store teams name as a variable
			teamName = input.nextLine();
			table = table +  "\n" + teamName;
			// loop to get the result of each game
			for(gamesLeft = 1;gamesLeft <= gamesPerTeam;gamesLeft++){
				if(gamesLeft == i){
					//table = table +  "\t-";
				}
				else{
					result = 0;
					while(result < 1 || result > 3){
						System.out.printf("Enter results%n%s -V- Team %d%n"
								+ "1. Win%n"
								+ "2. Draw%n"
								+ "3. Lose%n"
								,teamName,gamesLeft);
						result = input.nextInt();
						input.nextLine();
						
						if(result == 1){
							gamesWon++;
							totalPoints += POINTSFORWIN;
						}
						else if(result == 2){
							gamesDrawn++;
							totalPoints += POINTSFORDRAW;
						}
						else if(result == 3){
							gamesLost++;
							totalPoints += POINTSFORLOSS;
						}
						else{
							System.out.println("Enter a valid result");
						}
					}
				}
			}
			if(maxPoints < totalPoints){
				maxPoints = totalPoints;
				winningTeam = teamName;
			}
			else if(maxPoints == totalPoints){
				winningTeam += " " + teamName;
			}
			table += "\t\t" + gamesWon + "\t" + gamesDrawn + "\t" + gamesLost + "\t" + totalPoints;
		}
		System.out.println(table);
		
		input.close();
	}

}
