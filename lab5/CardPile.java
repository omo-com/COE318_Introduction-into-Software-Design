
/**
 *
 * @author Oliver Mo
 * Student id: 500844905
 */
package coe318.lab5;
import java.util.ArrayList;

/**
 * A pile of cards.
 *
 */
public class CardPile {
    //Instance variables
    private ArrayList<Card> cards;
    int random; //intializing random varible
    public CardPile() {
        //Initialize the instance variable.
    cards = new ArrayList();//Creating cards Arraylist
    
    }
    /**
     * Add a card to the pile.
     * @param card
     */
    public void add(Card card) {
      cards.add(card);
    }

    /**
     * Remove a card chosen at random from the pile.
     * @return
     */
    public Card removeRandom() {
        Card temp;//Creating instance variable of Card object.
        random = (int)(Math.random()*(this.cards.size()));//Cast random number into int, and multiplying the random decmial by array size.
        temp = cards.remove(random);//Sets card c as the card in the arry at random because array reads from 0 to array size
        //Remove card the at the int random varible. Again, remove at random
        return temp;//Returns to output the card that was removed.
    }
    /**
     * The string representation is a space separated list
     * of each card.
     * @return
     */
    @Override
    public String toString() {
        //FIX THIS
        return "" + getCards();//Using getCards() method, outputs all the cards in the CardPile in order of adding sequence.
    }
    
    /**
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void main(String[] args) {
        CardPile p = new CardPile();
        p.add(new Card(2, 1, true));
        p.add(new Card(3, 2, true));
        p.add(new Card(4, 3, false));
        p.add(new Card(14, 1, true));
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("Removed: " + p.removeRandom());
        System.out.println("");
        CardPile deck = new CardPile();
        for(int i = 2; i < 15; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Card(i, j, true));
            }
        }
        for (int i = 0; i < 52; i++) {
            System.out.println((i+1) + ": " + deck.removeRandom());
        }
    }


}
