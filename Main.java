// Anya Shankar
// period 2

import java.util.Scanner;

public class Main {
    int[]a = {1, 2, 3, 4, 5};


    public static String draw(String[] a){
        int i = (int) (Math.random()* a.length);
        String ans = a[i];
        arrayHelpers.Remove(a, i);
        return ans;
    }

    public static int total(String[] a){
        int total = 0;
        for(String x: a){
            if(x.equals("A")){
                total += 1;
            } else if(x.equals("K") || x.equals("Q") || x.equals("J")){
                total += 10;
            } else{
                total += Integer.parseInt(x);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner pen = new Scanner(System.in);
        boolean b = true;
        int bet, balance = 1000;
        System.out.println("you currently have 1000 dollars.");
        while(b){
            System.out.println("how much do you want to bet?");
            bet = pen.nextInt();

            String[] deck = new String[52];
            for(int i = 4; i < 40; i++){
                deck[i] = String.valueOf(i/(4 + 1));
            }
            for(int i = 0; i < 4; i++)
                deck[i] = "A";
            for(int i = 48; i < 52; i++)
                deck[i] = "K";
            for(int i = 44; i < 48; i++)
                deck[i] = "Q";
            for(int i = 40; i < 44; i++)
                deck[i] = "J";

            String[] dealerDeck = new String[0];
            dealerDeck = arrayHelpers.Add(draw(deck), dealerDeck);
            dealerDeck = arrayHelpers.Add(dealerDeck,draw(deck));
            System.out.println("the dealer's cards are: " + dealerDeck[0] + " and ?");

            String[] playerDeck = new String[0];
            playerDeck = arrayHelpers.Add(playerDeck, draw(deck));
            playerDeck = arrayHelpers.Add(playerDeck, draw(deck));
            System.out.println("your cards are: " + playerDeck[0] + " " + playerDeck[1]);

            boolean blackjack = false;

            boolean playerDraw = true;
            while(playerDraw){
                if(arrayHelpers.InArray(playerDeck, "A") && total(playerDeck) == 11){
                    System.out.println("you win");
                    blackjack = true;
                    if(playerDeck.length == 2){
                        balance = balance + 3*bet/2;
                        playerDraw = false;
                    } else{
                        balance = balance + bet;
                        playerDraw = false;
                    }
                } else{
                    System.out.println("hit or stand");
                    String reply = pen.nextLine();
                    if(reply.equals("hit")){
                        playerDeck = arrayHelpers.Add(playerDeck,draw(deck));
                        System.out.print("your cards are: ");
                        arrayHelpers.Display(playerDeck);
                        System.out.println();
                        System.out.println("your total is " + total(playerDeck));
                        playerDraw = total(playerDeck) <= 21;
                    }
                    else {
                        playerDraw = false;
                    }
                }
            }

            if(total(playerDeck) > 21) {
                System.out.println("you lost");
                balance = balance - bet;
            }

            if(total(playerDeck) < 21 && !blackjack){
                System.out.print("the dealer's cards are: ");
                arrayHelpers.Display(dealerDeck);
                System.out.println();
                boolean dealer21 = false;
                boolean dealerDraw = (total(dealerDeck)<=17);
                while(dealerDraw){
                    if(arrayHelpers.InArray(dealerDeck, "A") && total(dealerDeck) == 11){
                        System.out.println("the dealer wins");
                        balance = balance - bet;
                        dealer21 = true;
                        dealerDraw = false;
                    } else {
                        String card = draw(deck);
                        dealerDeck = arrayHelpers.Add(dealerDeck ,card);
                        System.out.println("the dealer drew a " + card);
                        if(arrayHelpers.InArray(dealerDeck, "A")){
                            if(total(dealerDeck)+10 > 17){
                                dealerDraw = false;
                            }
                        }
                        dealerDraw = total(dealerDeck)<17;
                    }
                }

                if(total(dealerDeck)>21 && !dealer21){
                    System.out.println("You win!");
                    balance = balance + bet;
                } else if(total(playerDeck)>total(dealerDeck) && !dealer21){
                    System.out.println("you win");
                    balance = balance + bet;
                } else if(total(playerDeck)==total(dealerDeck) && !dealer21){
                    System.out.println("push");
                } else if(total(playerDeck)<total(dealerDeck) && !dealer21){
                    System.out.println("you lost");
                    balance = balance - bet;
                }
            }

            if(balance <= 0){
                System.out.println("you lost your money");
                b = false;
            }
            System.out.println("do you want to play again? (y/n)");
            System.out.println("you have " + balance + " dollars.");
            String reply = pen.nextLine();
            if(reply.equals("n")){
                System.out.println("game over");
                b = false;
            } else {
                System.out.println("continue playing");
            }
        }


    }
}