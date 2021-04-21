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

public class Card {
    private final Suit suit;
    private final Value value;

    //constructor
    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }


    //Show  Suit and Value
    public String toString(){
        return this.suit.toString() + ":" + this.value.toString();
    }

    //Get the value
    public Value getValue(){
        return this.value;
    }
}
