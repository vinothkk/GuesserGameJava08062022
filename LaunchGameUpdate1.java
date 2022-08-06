import java.util.Scanner;

class Guesser
{
    int guessNum;

    public int guessNumber()
    {
        Scanner scan=new Scanner(System.in);

        System.out.println("Guesser kindly guess the number");
        guessNum=scan.nextInt();
        return guessNum;

    }

}

class Player
{
    int pguessNum;

    public int guessNumber()
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Player kindly guess the number");
        pguessNum=scan.nextInt();
        return pguessNum;
    }
}

class Umpire
{

    int numFromGuesser;
    int numFromPlayer1;
    int numFromPlayer2;
    int numFromPlayer3;

    boolean rematchPlayer1and2 =false;
    boolean rematchPlayer1and3 =false;
    boolean rematchPlayer2and3 =false;


    public void collectNumFromGuesser()
    {
        Guesser g=new Guesser();
        numFromGuesser=g.guessNumber();

    }


    public void collectNumFromPlayer()
    {
        startGamePlayer();
    }

    void compare()
    {
        if(numFromGuesser==numFromPlayer1)
        {
            if(numFromGuesser==numFromPlayer2 && numFromGuesser==numFromPlayer3)
            {
                System.out.println("Game tied all three players guessed correctly");
                collectNumFromGuesser();
                startGamePlayer();
                compare();
            }
            else if(numFromGuesser==numFromPlayer2)
            {
                System.out.println("Game tied between Player 1 and Player 2! Start the Game with player 1 and 2");
                rematchPlayer1and2 = true;
                collectNumFromGuesser();
                startGamePlayerOneTwo();
                compare();
                numFromPlayer3=-199;
            }
            else if(numFromGuesser==numFromPlayer3)
            {
                System.out.println("Game tied between Player 1 and Player 3! Start the Game with player 1 and 3");
                rematchPlayer1and3=true;
                collectNumFromGuesser();
                startGamePlayerOneThree();
                compare();
                numFromPlayer1=-199;
            }
            else
            {
                System.out.println("Player 1 won the game");
            }
        }

        else if(numFromGuesser==numFromPlayer2)
        {
            if(numFromGuesser==numFromPlayer3)
            {
                System.out.println("Game tied between Player 2 and Player 3! Start the Game with player 2 and 3");
                rematchPlayer2and3=true;
                collectNumFromGuesser();
                startGamePlayerTwoThree();
                compare();
                numFromPlayer1=-199;
                numFromPlayer2=-199;

            }
            else
            {
                System.out.println("Player 2 won the game");
            }
        }

        else if(numFromGuesser==numFromPlayer3)
        {
            System.out.println("Player 3 won the game");
        }
        else
        {
            if(rematchPlayer1and2){
                System.out.println("Game lost between player 1 & 2 try again between  player 1 & 2 to find the winner");
                rematchPlayer1and2 = false;
                collectNumFromGuesser();
                startGamePlayerOneTwo();
                compare();
            }
            else if(rematchPlayer1and3){
                System.out.println("Game lost between player 1 & 3 try again between  player 1 & 3 to find the winner");
                rematchPlayer1and3 = false;
                collectNumFromGuesser();
                startGamePlayerOneThree();
                compare();
            }
            else if(rematchPlayer2and3){
                System.out.println("Game lost between player 2 & 3 try again between  player 2 & 3 to find the winner");
                rematchPlayer2and3 = false;
                collectNumFromGuesser();
                startGamePlayerTwoThree();
                compare();
            }
            else{
                System.out.println("Game lost! try again");
            }
        }
    }

    public void startGamePlayer(){
        Player p1=new Player();
        Player p2=new Player();
        Player p3=new Player();

        numFromPlayer1=p1.guessNumber();
        numFromPlayer2=p2.guessNumber();
        numFromPlayer3=p3.guessNumber();
    }

    public void startGamePlayerOneTwo(){
        Player p1=new Player();
        Player p2=new Player();


        numFromPlayer1=p1.guessNumber();
        numFromPlayer2=p2.guessNumber();
    }

    public void startGamePlayerOneThree(){
        Player p1=new Player();
        Player p3=new Player();

        numFromPlayer1=p1.guessNumber();
        numFromPlayer3=p3.guessNumber();
    }

    public void startGamePlayerTwoThree(){
        Player p2=new Player();
        Player p3=new Player();

        numFromPlayer2=p2.guessNumber();
        numFromPlayer3=p3.guessNumber();
    }
}

public class LaunchGameUpdate1 {

    public static void main(String[] args) {

        Umpire u=new Umpire();
        u.collectNumFromGuesser();
        u.collectNumFromPlayer();
        u.compare();
    }
}