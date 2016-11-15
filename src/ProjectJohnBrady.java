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
		System.out.println("****************************************************\n"
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
		String table = "";
		
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
		
		
		double averageAttendance = 0;
		double prize = 0;
		double takingsPerGame = 0;
		double totalTakings = 0;

		// loop to get the number of teams in competition
		while(noOfTeams < LEASTAMOUNTOFTEAMS){
			System.out.print("Enter how many teams are parcipitating(must be atleast 2): ");
			noOfTeams = input.nextInt();
			input.nextLine();
			if(noOfTeams < LEASTAMOUNTOFTEAMS){
				System.out.println("Enter a valid number of teams.\n");
			}
		}
		
		gamesPerTeam = noOfTeams;
		totalGames = noOfTeams * gamesPerTeam / 2;
		
		for(int i = 1; i < noOfTeams; i++){
			System.out.printf("Enter Team %d's name: ", i);
			teamName = input.nextLine();
			for(gamesLeft = 1;gamesLeft <= gamesPerTeam;gamesLeft++){
				if(gamesLeft == i){
					table = table +  "\tX";
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

						}
					}
				}
			}
		}

		
		input.close();
	}

}
