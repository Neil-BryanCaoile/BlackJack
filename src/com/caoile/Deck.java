package com.caoile;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(){
        //Create a new deck of playing cards
        this.cards = new ArrayList<Card>();
    }

    //Add all cards to the deck [52 Cards]
    public void createFullDeck(){
        //Generate Cards
        //Loop Through Suits
        for(Suit cardSuit : Suit.values()){
            //Loop through Values
            for(Value cardValue : Value.values()){
                //Add new card to the deck
                this.cards.add(new Card(cardSuit,cardValue));
            }
        }
    }

    //Shuffle the deck
    public void shuffle(){

        ArrayList<Card> tmpDeck = new ArrayList<Card>();        //This is just temporary to hold cards
        Random random = new Random();
        int randomIndex;
        int originalSize = this.cards.size();
        for(int i = 0; i<originalSize;i++){
            //gen random num according to int randomNum = rand.nextInt((max - min) + 1) + min;
            randomIndex = random.nextInt((this.cards.size()-1 ) + 1);
            //throw random card into new deck
            tmpDeck.add(this.cards.get(randomIndex));
            //remove picked from old deck
            this.cards.remove(randomIndex);
        }
        //set this.deck to our newly shuffled deck
        this.cards = tmpDeck;
    }

    //Remove a card from the deck
    public void removeCard(int i){
        this.cards.remove(i);
    }

    //Get card from deck
    public Card getCard(int i){
        return this.cards.get(i);
    }

    //Add card to deck
    public void addCard(Card addCard){
        this.cards.add(addCard);
    }

    //Draw a top card from deck
    public void draw(Deck c){
        //Add card to this deck from whatever deck its coming from
        this.cards.add(c.getCard(0));
        //Remove the card in the deck its coming from
        c.removeCard(0);
    }

    //Use to print out deck
    public String toString(){
        String cardListOutput = "";
        for(Card aCard : this.cards){
            cardListOutput += "[" + aCard.toString() +"]  ";
        }
        return cardListOutput;
    }

    public void moveAllToDeck(Deck c){
        int thisDeckSize = this.cards.size();
        //put cards in moveTo deck
        for(int i = 0; i < thisDeckSize; i++){
            c.addCard(this.getCard(i));
        }
        //empty out the deck
        for(int i = 0; i < thisDeckSize; i++){
            this.removeCard(0);
        }
    }

    public int deckSize(){
        return this.cards.size();
    }

    //Calculate the value of deck
    public int cardsValue(){
        int totalValue = 0;
        int aces       = 0;
        //For every card in the deck
        for(Card c : this.cards){
            //Switch of possible values
            switch(c.getValue()){
                case TWO:   totalValue += 2; break;
                case THREE: totalValue += 3; break;
                case FOUR:  totalValue += 4; break;
                case FIVE:  totalValue += 5; break;
                case SIX:   totalValue += 6; break;
                case SEVEN: totalValue += 7; break;
                case EIGHT: totalValue += 8; break;
                case NINE:  totalValue += 9; break;
                case TEN: case JACK: case QUEEN: case KING: totalValue += 10; break;
                case ACE: aces += 1; break;
            }
        }

        //Determine the total current value with aces
        //Aces worth 11 or 1 - if 11 would go over 21 make it worth 1
        for(int i = 0; i < aces; i++){
            //If they're already at over 10 getting an ace valued at 11 would put them up to 22, so make ace worth one
            if (totalValue > 10){
                totalValue += 1;
            }
            else{
                totalValue += 11;
            }
        }

        //Return
        return totalValue;

    }
}
