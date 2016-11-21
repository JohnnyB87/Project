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
		
		// Initializing variables and constants
		final int LEAST_AMOUNT_OF_TEAMS = 2;
		final int POINTS_FOR_WIN = 3;
		final int POINTS_FOR_DRAW = 1;
		final int POINTS_FOR_LOSS = 0;
		final double TICKET_PRICE = 5.5;
        
		
		String teamNames = "";
		String winningTeam = "";
		String teamName = "";
		String otherTeamName = "";
		String table = "Team       Won Drawn Lost Total\n"
					+  "========== === ===== ==== =====";
		
		int noOfTeams = 0;
		int result = 0;
		int gamesPerTeam = 0;
		int totalGames = 0;
		int gamesLeft = 0;
		int attendancePerGame = 0;
		int totalAttendance = 0;
		int count = 1;
		int gameCounter = 1;
        int matchNo = 0;
		int teamNo = 0;
		int gamesWon = 0;
		int gamesDrawn = 0;
		int gamesLost = 0;
		int totalPoints = 0;
		int maxPoints = 0;
		int winningTeams = 1;
		
		double averageAttendance = 0;
		double prize = 0;
		double takingsPerGame = 0;
		double totalTakings = 0;

		// loop to get the number of teams in competition
		while(noOfTeams < LEAST_AMOUNT_OF_TEAMS){
			System.out.print("Enter how many teams are parcipitating(must be at-least 2): ");
			noOfTeams = input.nextInt();
			input.nextLine();
			// if input is less than the minimum amount of teams allowed
			if(noOfTeams < LEAST_AMOUNT_OF_TEAMS){
				// print error message
				System.out.println("Enter a valid number of teams.\n");
			}
		}
		
		gamesPerTeam = noOfTeams - 1;
		totalGames = noOfTeams * gamesPerTeam / 2;

		// loop to get each teams info
		for(int i = 1; i <= noOfTeams; i++){
			totalPoints = 0;
			gamesWon = 0;
			gamesDrawn = 0;
			gamesLost = 0;
			int teamNameLen = 0;
			String teamNameGap = "  ";
			// ask user for teams name
			do{
				System.out.printf("Enter Team %d's name (max 10 letters): ", i);
				// store teams name as a variable
				teamName = input.nextLine();
				teamNameLen = teamName.length();
			}while(teamNameLen > 10);
			// loop to add spaces to the end of the name to line up the table
			for(int l = teamNameLen; l<10; l++){
				teamNameGap += " ";
			}
			table = table +  "\n" + teamName + teamNameGap;
			// loop to get the result of each game
            matchNo = 1;
            teamNo++;
			for(gamesLeft = 1;gamesLeft <= noOfTeams;gamesLeft++){
				// if statement that makes the loop skip if the team is playing itself
				if(gamesLeft == i){

				}
				else{
					result = 0;
					if(gamesLeft < i){
						System.out.printf("Carefully re-enter the result with team %d.%n",i);
                        gameCounter--;
					}
					while(result < 1 || result > 3){
						System.out.printf("Enter results for match %d, game %d of %d for Team %d%n%s -V- Team %d%n"
								+ "1. Win%n"
								+ "2. Draw%n"
								+ "3. Lose%n"
								, gameCounter, matchNo, gamesPerTeam, teamNo, teamName, gamesLeft);
						result = input.nextInt();
						input.nextLine();
						
						if(result == 1){
							gamesWon++;
							totalPoints += POINTS_FOR_WIN;
						}
						else if(result == 2){
							gamesDrawn++;
							totalPoints += POINTS_FOR_DRAW;
						}
						else if(result == 3){
							gamesLost++;
							totalPoints += POINTS_FOR_LOSS;
						}
						else{
							System.out.println("Enter a valid result.");
                            gameCounter--;
						}
                        gameCounter++;
					}
					if(gamesLeft > i){
						System.out.print("Enter attendance of the game: ");
						totalAttendance += input.nextInt();
						input.nextLine();
					}
                    matchNo++;
				}
			}
			if(maxPoints < totalPoints){
				maxPoints = totalPoints;
				winningTeam = teamName;
				winningTeams = 1;
			}
			else if(maxPoints == totalPoints){
				winningTeam += " " + teamName;
				winningTeams++;
			}
			table +=  gamesWon + "    " + gamesDrawn + "    " + gamesLost + "     " + totalPoints;
		}
		averageAttendance = totalAttendance / totalGames;
        totalTakings = totalAttendance * TICKET_PRICE;
        prize = totalTakings * .5 / winningTeams;

		System.out.printf("%s%nTotal Attendance: %d%nAverage Attendance: %.2f%nTotal Takings: %.2f%n" +
                        "Winning Team(s): %s with €%.2f each%n"
                , table, totalAttendance, averageAttendance, totalTakings, winningTeam, prize);
		
		input.close();
	}

}
