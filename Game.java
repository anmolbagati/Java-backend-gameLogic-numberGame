
/**
 * Write a description of class Player here.
 *
 * @author (Anmol)
 * @version (a version number or a date)
 */
import java.io.IOException; // when error
import java.util.Random; // 
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in); 
        Player player = new Player();
              // Starting infinite loop for game
        while(true)
        {

// displaying main menu
            //cls();
            System.out.println("Please select from the following options"
                    + "\n"
                    + "Press 1 to register a player"
                    + "\n"
                    + "Press 2 to start a new game"
                    + "\n"
                    + "Press 3 to view a help menu"
                    + "\n"
                    + "Press 4 to exit");
            String input = sc.nextLine(); 
            
            if(input.equals("1"))
            {
                registerPlayer(player); // registering a player
            }
            else if(input.equals("2") )
            {
                if(player.getName() == null) // Validation for wrong input
                {
                    //cls();
                    System.out.println("Please register yourself before playing the game");
                    pressContinue();
                }
                else
                {
                    //cls();
                    Player computer = new Player();
                    Player player1 = new Player(player.getName()); 
                    startGame(player1, computer);
                }
            }
            else if(input.equals("3"))
            {
//                Help menu with rules
                System.out.println("1. You starts the game with zero points." + "\n" + "\n" + "2. Prior to the round you are given a set of 5 tiles and each has a value associated to it, as follows: " + "\n" + "\n" + "1--->5" + "\n" + "2--->4" + "\n" + "3--->3" + "\n" + "5--->2" + "\n" + "7--->1"
                + "\n" + "\n" + "3. No other tile can be played by you" + "\n" + "\n" + "4. The computer has the same set of tiles as you and one tile can be played only once in that particular round" + "\n" + "\n"
                + "5. At the start of the round we will tell you who goes first, you or the computer." + "6. For each round, you will play ONE tile, with the tile value adding to the game total for that round. Provided the game total is less than or equal to 21, the player will get the score for using that tile. However, if the game total is greater than 21, no score is allocated to the player who played the last tile causing the score to become greater than 21." + "\n"+ "\n");



            }
            else if(input.equals("4"))
            {
                System.out.println("Thank you from playing the game.");
            
                break;
            }
            else
            {
                cls();
                System.out.println("Please select a valid option");
                pressContinue();

            }
  

        }

        
    }
    public static void registerPlayer(Player p1) throws Exception
    {
        Scanner sc1 = new Scanner(System.in);
        while(true)
        {
            //cls();
            System.out.print("\nPlease Enter Players Name (Between 3-10 characters): ");
            String player_name = "";
            player_name = sc1.next();
            if(player_name.length() < 3 )
            {
                System.out.println("Input name has less then 3 characters. Please provide a valid input.");
                
            }
            else if(player_name.length() > 10)
            {
                System.out.println("Input name has more then 10 characters. Please provide a valid input.");
            }
            else
            {
                p1.setName(player_name);
                System.out.println("Welcome "+ player_name+". You have been registerd successfully");
                pressContinue();
                
                break;

            }
            pressContinue();
            
        }
                
    }
    
    public static void pressContinue()
    {

        System.out.println("Press Enter to continue.....");
        try {

            int read = System.in.read(new byte[2]);
            
        } catch (Exception e) {
//           TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }
    public static void startGame(Player player, Player computer) throws Exception
    {
    // getting no of rounds as input for player
        int noofrounds = getNumberOfRounds();
        for(int i=0; i< noofrounds; i++) // loop for playing game
        {
            System.out.println("Current Statistics"
                    + "\n"
                    + "Rounds won by computer: " + computer.getRoundsWon() +""
                            + "\n"
                            + "Rounds won by "+player.getName()+": "+player.getRoundsWon());
            System.out.println("Round " + (i+1) + " is about to start");
            pressContinue();
            playRound(player, computer);
        }
        // for final result after all rounds over
        System.out.println("Current Statistics"
                + "\n"
                + "Rounds won by computer: " + computer.getRoundsWon() +""
                        + "\n"
                        + "Rounds won by "+player.getName()+": "+player.getRoundsWon());
        if(computer.getRoundsWon() > player.getRoundsWon())
        {
            System.out.println("Computer wins....");
        }
        else if(computer.getRoundsWon() < player.getRoundsWon())
        {
            System.out.println(player.getName()+ " wins....");
        }
        else
        {
            System.out.println("It's a tie...");
        }
        
        pressContinue();
        
    }
    
    public static void playRound(Player player, Player computer)
    {// before new round starts, all values are resetting
        Scanner sc3 = new Scanner(System.in);
        Boolean b = null;
        int input;
        int is_human_turn = isHumanTurn(); // if human plays or computer plays

        int game_total = 0;
        player.setTiles(getTilesforGame());
        computer.setTiles(getTilesforGame());
        player.setScore(0);
        computer.setScore(0);
        Boolean isElseOver = false;
        if(is_human_turn == 1)
        {
            System.out.print(player.getName() + " will play the first trun of the round\n");
        }
        else
        {
            System.out.print("Computer will play the first trun of the round\n");
        }
        pressContinue();
// starting the round
        while(true) 
        {

                if(is_human_turn == 1)  // who is starting 
                {
                    System.out.println("Game total is: " + game_total+""// showing current stats for that round
                            + "\n"
                            + "your score is: "+player.getScore() + ""
                            + "\n"
                            + "Computer's score is: "+computer.getScore());
                    
                    System.out.println("Available tiles for computer: " + getAvailableTiles(computer));
                    System.out.println("Available tiles for "+player.getName()+": "+getAvailableTiles(player));
                    
                    System.out.println("\n\nPlease Provide input: ");
                    String s = sc3.nextLine();
                    
                    try
                    {
                        input = Integer.parseInt(s);
                        int flg =0; 
                        
                        for(int i=0; i< player.getTiles().length ; i++)
                        {
                            if(player.getTiles()[i].getIsPlayed() == 0 & player.getTiles()[i].getValue() == input)// checking if valid input
                            {
                                flg = 1;
                                player.setLastTilePlayed(player.getTiles()[i]);
                                player.getTiles()[i].setIsPlayed(1);
                                if((game_total + player.getTiles()[i].getValue()) <= 21 )// checking if game ends
                                {
                                    game_total = game_total + player.getTiles()[i].getValue();
                                    player.setScore(player.getScore() + player.getTiles()[i].getScore());

                                    is_human_turn = 0;
                                }
                                else
                                {
                                    //cls();
                                    System.out.println("Round over");


                                    if(isFivePlayed(player) == false)// checking if tile 5 is played 
                                    {
                                        player.setScore(player.getScore() - 3);
                                    }
                                    if(isFivePlayed(computer) == false)// checking if tile 5 is played
                                    {
                                        computer.setScore(computer.getScore() - 3);
                                    }
                                    
                                    if(player.getScore() > computer.getScore())// who has won the round to get +5 points
                                    {
                                        player.setScore(player.getScore() + 5);
                                    }
                                    else if(player.getScore() < computer.getScore())
                                    {
                                        computer.setScore(computer.getScore() + 5);
                                    }
                                    else
                                    {
                                        
                                    }
                                     showRoundResult(player, computer); // showing final result of that round
                                     pressContinue();
                                     isElseOver = true;
                                     break;
                                }
                                
                            }
                        }
                        if(flg == 1)
                        {
                            
                        }
                        else
                        {
                            System.out.print("Please provide valid input");
                            pressContinue();

                        }
                        try {
                            //cls();
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }
                    catch(Exception e)
                    {
                        System.out.print("Please provide valid input\n");
                        pressContinue();                    
                    }
                }
                else
                {
                    System.out.println("Computer is thinking.....");
                    try {
                        TimeUnit.SECONDS.sleep(2); // code going on pause so as to give effect of computer thinking
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
// deciding computer input
                    input = getBestTileToPlay(game_total, player, computer);
                    for(int i=0; i< computer.getTiles().length ; i++)
                    {
                        if(computer.getTiles()[i].getValue() == input)
                        {

                            System.out.println("Computer played: " + input);

                            computer.setLastTilePlayed(computer.getTiles()[i]);
                            computer.getTiles()[i].setIsPlayed(1);
                            if(game_total + computer.getTiles()[i].getValue() <= 21)
                            {
                                
                                game_total = game_total + computer.getTiles()[i].getValue();
                                computer.setScore(computer.getScore() + computer.getTiles()[i].getScore());                         
                                is_human_turn = 1;
                            }
                            else
                            {
                                try {
                                    //cls();
                                } catch (Exception e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                
                                System.out.println("Round over");


                                if(isFivePlayed(player) == false)
                                {
                                    player.setScore(player.getScore() - 3);
                                }
                                if(isFivePlayed(computer) == false)
                                {
                                    computer.setScore(computer.getScore() - 3);
                                }
                                

                                if(player.getScore() > computer.getScore())
                                {
                                    player.setScore(player.getScore() + 5);
                                }
                                else if(player.getScore() < computer.getScore())
                                {
                                    computer.setScore(computer.getScore() + 5);
                                }
                                else
                                {
                                    
                                }
                                
                                 showRoundResult(player, computer);
                                 pressContinue();
                                 isElseOver = true;
                                 break;
                            }
                            
                        }
                    }
                    if(isElseOver == true)
                    {
                        break;
                    }
                    pressContinue();
                    try {
                        //cls();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    
                }
        
                if(isElseOver == true)
                {
                    break;
                }
    
        }
        
        
    }
    
    public static int getBestTileToPlay(int game_total, Player player, Player computer)
    {
// getting available tile for computer and player
        Tile computerTile[] = computer.getTiles();
        Tile playerTile[] = player.getTiles();
        
        
        int temp_computer_score = computer.getScore();
        int temp_player_score = player.getScore();
        int bestScore = -999999;
        int bestTile = 0;
        for(int i =0; i< playerTile.length; i++) // checking if tile 5 is not played by either
        {
            if(computerTile[i].getValue() == 5 && computerTile[i].getIsPlayed() ==0)
            {
                temp_computer_score = temp_computer_score - 3;
            }
            if(playerTile[i].getValue() == 5 && playerTile[i].getIsPlayed() == 0)
            {
                temp_player_score = temp_player_score - 3;
            }
        }
        
        
        if(temp_computer_score >= temp_player_score) 
        {
            
            for(int i=0; i<computerTile.length; i++)
            {
                if(computerTile[i].getIsPlayed() == 0)
                {
                    int temp_game_total = game_total + computerTile[i].getValue();
                    int temp_computer_score_final = temp_computer_score + computerTile[i].getScore();

                    //try to end the game
                    if(temp_game_total > 21)
                    {
                        return computerTile[i].getValue();
                    }
                    else //if game cannot be ended return bestTile
                    {
                        int finalScore = temp_computer_score_final - temp_player_score;
                        if(finalScore > bestScore)
                        {
                            bestScore = finalScore;
                            bestTile = computerTile[i].getValue();
                        }
                    }
                }
                else
                {
                    
                }
            }
            
            
        }
        else
        {
            for(int i=0; i<computerTile.length; i++)// player score is greater than computer score, so return tile with greatest score possible
            {
                int flg =0;
                if(computerTile[i].getIsPlayed() == 0)
                {
                    int temp_game_total = game_total + computerTile[i].getValue();
                    int temp_computer_score_final = temp_computer_score + computerTile[i].getScore();
                        
                    if(game_total <=21)
                    {
                        flg =1;
                        int finalScore = temp_computer_score_final - temp_player_score;
                        if(finalScore > bestScore)
                        {
                            bestScore = finalScore;
                            bestTile = computerTile[i].getValue();
                        }
                    }
                    
                }
                if(flg == 0)
                {
                    for(int j=0; j<computerTile.length; j++)
                    {
                        if(computerTile[i].getIsPlayed() == 0)
                        {
                            bestTile = computerTile[i].getValue();
                        }
                        
                    }
                }
                
    
            }

        }
        return bestTile;

    }
    public static String getAvailableTiles(Player player)
    {
        Tile tiles[] = player.getTiles();
        return toComma(tiles);
    }
    
    public static int isHumanTurn()//deciding who will play first using random function
    {
        Random rand = new Random();
        int n = rand.nextInt(2);
        return n;
    }

    public static int getNumberOfRounds()
    {
        Scanner sc4 = new Scanner (System.in);
        while(true)
        {
            System.out.println("Enter the number of rounds to be played (1-10)");
            String s = sc4.nextLine();
            try
            {
                int rounds = Integer.parseInt(s);
                if(rounds >=1 && rounds <=10)
                {

                    return rounds;
                }
                else
                {
                    if(rounds < 1)
                    {
                        System.out.println("The entered number is less then 1. Please select a number between 1-10");
                    }
                    else
                    {
                        System.out.println("The entered number is grater then 10. Please select a number between 1-10");

                    }
                }
            }
            catch(Exception e)
            {
                System.out.println("Please provide a valid number between 1-10");
            }
            
        }
        
    }
    private static void cls() throws Exception
      {
        String ANSI_CLS = "\u001b[2J";  
        String ANSI_HOME = "\u001b[H";  
        if (System.getProperty("os.name").contains("win"))
        {
          new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        else
        {
          System.out.print(ANSI_CLS + ANSI_HOME);
        }
      }
    
    public static Tile[] getTilesforGame()
    {
        Tile tiles[] = new Tile[5];
        tiles[0] = new Tile();
        tiles[0].setValue(1);
        tiles[0].setScore(5);
        tiles[0].setNotPlayScore(0);
        tiles[0].setIsPlayed(0);
        
        tiles[1] = new Tile();
        tiles[1].setValue(2);
        tiles[1].setScore(4);
        tiles[1].setNotPlayScore(0);
        tiles[1].setIsPlayed(0);
        
        tiles[2] = new Tile();
        tiles[2].setValue(3);
        tiles[2].setScore(3);
        tiles[2].setNotPlayScore(0);
        tiles[2].setIsPlayed(0);
        
        tiles[3] = new Tile();
        tiles[3].setValue(5);
        tiles[3].setScore(2);
        tiles[3].setNotPlayScore(3);
        tiles[3].setIsPlayed(0);
        
        tiles[4] = new Tile();
        tiles[4].setValue(7);
        tiles[4].setScore(1);
        tiles[4].setNotPlayScore(0);
        tiles[4].setIsPlayed(0);
        
        return tiles;
    }
    
    public static String toComma(Tile[] array) {
        String result = "";

        if (array.length > 0) {
            StringBuilder sb = new StringBuilder();
            
            sb.append("{ ");

            for (Tile t : array) {
                if(t.getIsPlayed() == 0)
                {
                    sb.append(t.getValue()).append(",");
                }
                
            }
            sb.append(" }");
            result = sb.deleteCharAt(sb.length() - 3).toString();
            

        }
        
        return result;
}
    public static Boolean isFivePlayed(Player player)
    {
        Tile playerTile[] = player.getTiles();
        for(int i =0; i< playerTile.length; i++)
        {
            if(playerTile[i].getValue() == 5 && playerTile[i].getIsPlayed() ==1)
            {
                return true;
            }
            
        }
        return false;
        
    }
    
    public static void showRoundResult(Player player, Player computer)
    {
        System.out.println("Final Score for the round"
                + "\n"
                + "Computer: " + computer.getScore()+""
                        + "\n"
                        + player.getName() + ": " + player.getScore());
        if(player.getScore() > computer.getScore())
        {
            System.out.println(player.getName()+ " won the round");
            player.setRoundsWon(player.getRoundsWon() + 1);

        
        }
        else if(player.getScore() < computer.getScore())
        {
            System.out.println ("Computer won the round");
            computer.setRoundsWon(computer.getRoundsWon() + 1);

        }
        else
        {
            System.out.println("It's a tie");

        }
    }
}
