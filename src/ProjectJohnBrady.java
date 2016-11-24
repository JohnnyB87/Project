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
        final double PRIZE_MULTIPLIER = 0.5;
		final double TICKET_PRICE = 5.5;

		String winningTeam = "";
		String teamName = "";
		String results = "";
		String table = "Team       Won Drawn Lost Total\n"
					+  "========== === ===== ==== =====";
		
		int noOfTeams = 0;
		int result = 0;
		int gamesPerTeam = 0;
		int totalGames = 0;
		int totalAttendance = 0;
		int gameCounter = 1;
        int matchNo = 0;
		int gamesWon = 0;
		int gamesDrawn = 0;
		int gamesLost = 0;
		int totalPoints = 0;
		int maxPoints = 0;
		int winningTeams = 1;
        int resultsLen = 0;
        int resultFinder = 0;
		
		double averageAttendance = 0;
		double prize = 0;
		double totalTakings = 0;

        boolean validIput = false;

		// loop to get the number of teams in competition
		while(noOfTeams < LEAST_AMOUNT_OF_TEAMS){
			System.out.print("Enter how many teams are participating(must be at-least 2): ");
            if(input.hasNextInt()) {
                noOfTeams = input.nextInt();
                input.nextLine();
            }
            else {
                input.nextLine();
            }
			// if input is less than the minimum amount of teams allowed
			if(noOfTeams < LEAST_AMOUNT_OF_TEAMS){
				// print error message
				System.out.println("Enter a valid number of teams.\n");
			}
		}
		
		gamesPerTeam = noOfTeams - 1;
		totalGames = noOfTeams * gamesPerTeam / 2;

		// loop to get each teams info
		for(int teamNo = 1; teamNo <= noOfTeams; teamNo++){
            // resetting variables that are needed
			totalPoints = 0;
			gamesWon = 0;
			gamesDrawn = 0;
			gamesLost = 0;
            matchNo = 1;
            teamName = "1";
			int teamNameLen = 0;
			String teamNameGap = "  ";
            int temp = noOfTeams - 2;
            int temp2 = teamNo - 1;

			// ask user for teams name
			while (!Character.isLetter(teamName.charAt(0)) || teamNameLen > 10){
				System.out.printf("Enter Team %d's name (max 10 letters & must start with a letter): ", teamNo);
				// store teams name as a variable
				teamName = input.nextLine();
                // if no data entered reassign teamName variable
                if(teamName.equals("")){
                    teamName = "1";
                }
				teamNameLen = teamName.length();
			}
			// loop to add spaces to the end of the name to line up the table
			for(int l = teamNameLen; l<10; l++){
				teamNameGap += " ";
			}
			table = table +  "\n" + teamName + teamNameGap;
			// loop to get the result of each game


			for(int teamGameNo = 1;teamGameNo <= noOfTeams;teamGameNo++){
                char resultChar = ' ';
                validIput = false;
				// if statement that makes the loop skip if the team is playing itself
				if(teamGameNo == teamNo){

				}
				// enters if team is playing against another team
				else{
                    // reset the result so it will start the loop
					result = 0;
                    // keep looping while invalid data is entered
					while(result < 1 || result > 3) {
                        // Only enters when there's a new match, one which we haven't got the results for
                        if (teamGameNo > teamNo){
                            // prompt user and ask for the result
                            System.out.printf("Enter results for match %d, game %d of %d for Team %d%n%s -V- Team %d%n"
                                            + "1. Win%n"
                                            + "2. Draw%n"
                                            + "3. Lose%n"
                                    , gameCounter, matchNo, gamesPerTeam, teamNo, teamName, teamGameNo);
                            // check if user inputted an integer
                            // if yes assign it to the result variable
                            if(input.hasNextInt()) {
                                result = input.nextInt();
                                input.nextLine();
                            }
                            // else call the nextLine method without saving it
                            else {
                                input.nextLine();
                            }
                        }
                        // enters when a game has already been played
                        // automatically finds the result
						else if (teamGameNo < teamNo){
                            // get length of the results string
                            resultsLen = results.length();
                            // get the index of the already saved match
                            resultFinder = resultsLen - (temp * temp2 + 1);
                            resultChar = results.charAt(resultFinder);
                            // adjust values for next loop
                            temp2--;
                            gameCounter--;
                        }
                        // if statement to check if a valid result was inputted
                        // if the team won
                        if (result == 1 || resultChar == '3'){
                            gamesWon++;
                            totalPoints += POINTS_FOR_WIN;
                            results += 1;
                            result = 1;
                        }
                        // if the team drew
                        else if (result == 2 || resultChar == '2'){
                            gamesDrawn++;
                            totalPoints += POINTS_FOR_DRAW;
                            results += 2;
                            result = 2;
                        }
                        // if the team lost
                        else if (result == 3 || resultChar == '1'){
                            gamesLost++;
                            totalPoints += POINTS_FOR_LOSS;
                            results += 3;
                            result = 3;
                        }
                        // if invalid data was entered
                        else {
                            System.out.println("Enter a valid result.");
                            gameCounter--;
                        }
                        gameCounter++;
					}
					if(teamGameNo > teamNo){
                        while(!validIput) {
                            System.out.print("Enter attendance of the game: ");
                            if(input.hasNextInt()) {
                                totalAttendance += input.nextInt();
                                input.nextLine();
                                validIput = true;
                            }
                            else{
                                input.nextLine();
                            }
                        }
					}
					// increment the match number
                    matchNo++;
				}
			}
			// checks if there's a new high scorer
            // enters if yes
			if(maxPoints < totalPoints){
                // assigns the maxPoints variable the new high-score
				maxPoints = totalPoints;
                // appends team name to list of winners
				winningTeam = teamName;
                // resets the amount of winning teams to 1
				winningTeams = 1;
			}
			// checks if a team equaled the current high-score
			else if(maxPoints == totalPoints){
                // appends team name to list of winners
				winningTeam += " " + teamName;
                // increments the number of winning teams
				winningTeams++;
			}
			table +=  gamesWon + "    " + gamesDrawn + "    " + gamesLost + "     " + totalPoints;
		}
		// computing calculations
		averageAttendance = totalAttendance / totalGames;
        totalTakings = totalAttendance * TICKET_PRICE;
        prize = totalTakings * PRIZE_MULTIPLIER / winningTeams;

		System.out.printf("%s%nTotal Attendance: %d%nAverage Attendance: %.2f%nTotal Takings: %.2f%n" +
                        "Winning Team(s): %s with €%.2f per team%n"
                , table, totalAttendance, averageAttendance, totalTakings, winningTeam, prize);

		input.close();
	}

}
