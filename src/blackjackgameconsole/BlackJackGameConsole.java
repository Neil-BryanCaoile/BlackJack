/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgameconsole;

/**
 *
 * @author neilb
 */
import java.util.Scanner;

public class BlackJackGameConsole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         System.out.println("**** Welcome to Blackjack Console! ****");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();    //Create full deck of cards
        playingDeck.shuffle();           //Shuffle the deck


        Deck   playerCards = new Deck();  //Deck for the player
        double playerMoney = 100.0;       //Player money to bet

        //dealerCards will be the cards the dealer has in their hand
        Deck dealerCards   = new Deck();

        //Scanner for user input
        Scanner userInput  = new Scanner(System.in);

        //Play the game while the player has money
        //Game loop
        while(playerMoney>0){
            //Take Bet
            System.out.println("Money[$" + playerMoney + "]\nHow much would you like to bet?");
            System.out.print(">");
            double playerBet = userInput.nextDouble();
            boolean endRound = false;


            if(playerBet > playerMoney){
                //End the game if the user bet too much
                System.out.println("Sorry you don't have enough money to bet that amount.");
                break;
            }

            System.out.println("**** Dealing... ****");

            //Player gets two cards
            playerCards.draw(playingDeck);
            playerCards.draw(playingDeck);

            //Dealer gets two cards
            dealerCards.draw(playingDeck);
            dealerCards.draw(playingDeck);

            while(true)//While loop for drawing new cards
            {
                //Display player cards
                System.out.println("Your Hand:       " + playerCards.toString());

                //Display player cards value
                System.out.println("Your Hand value: " + playerCards.cardsValue());

                //Display dealer cards
                System.out.println("Dealer Hand:     [" + dealerCards.getCard(0).toString() + "]  [HIDDEN]");

                //Player move option hit|stand
                System.out.println("Select your move: \n[1]Hit\n[2]Stand");
                System.out.print  (">");

                int response = userInput.nextInt();

                //If player choose to hit
                if(response == 1){
                    playerCards.draw(playingDeck);
                    System.out.println("You draw a:" + playerCards.getCard(playerCards.deckSize()-1).toString());

                    //Bust
                    if(playerCards.cardsValue() > 21){
                        System.out.println("BUST! Value:" + playerCards.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;//Break the loop
                    }
                }

                //If player choose to Stand
                if(response == 2){
                    break;
                }

            }

            //Reveal Dealer Cards
            System.out.println("Dealer Cards:" + dealerCards.toString());

            //Compare dealer value to player card value
            if((dealerCards.cardsValue() > playerCards.cardsValue()) && !endRound){
                System.out.println("Dealer won! Dealer:" + dealerCards.cardsValue() + " Player " + playerCards.cardsValue());
                playerMoney -= playerBet;
                endRound = true;
            }


            //Dealer must hits at 16 and  stands at 17

            while((dealerCards.cardsValue() < 17) && !endRound)
            {
                dealerCards.draw(playingDeck);
                System.out.println("Dealer draws:" + dealerCards.getCard(dealerCards.deckSize()-1).toString());
            }
            //Display value of dealer
            System.out.println("Dealers value:" + dealerCards.cardsValue());

            //Check if Dealer busted
            if((dealerCards.cardsValue()>21)&& !endRound){
                System.out.println("Dealer Busts. You WIN!");
                playerMoney += playerBet;
                endRound = true;
            }

            //Determine if Dealer push
            if((dealerCards.cardsValue() == playerCards.cardsValue()) && !endRound){
                System.out.println("Push.");
                endRound = true;
            }

            //Determine if player wins
            if((playerCards.cardsValue() > dealerCards.cardsValue()) && !endRound){
                System.out.println("Congratulations you WIN!");
                playerMoney += playerBet;
            }
            else if(!endRound) //dealer wins
            {
                System.out.println("Dealer win. Sorry you lost.");
                playerMoney -= playerBet;
            }

            //End of hand - put cards back in deck
            playerCards.moveAllToDeck(playingDeck);
            dealerCards.moveAllToDeck(playingDeck);
            System.out.println("***** End of Hand. *****");

        }
        //Game is over
        System.out.println("GAME OVER! You don't have any money to bet.");

        //Close Scanner
        userInput.close();
    }
    
}
