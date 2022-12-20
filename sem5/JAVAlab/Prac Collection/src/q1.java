import java.util.*;
import java.lang.*;
class Card {
    private String symbol;
    private int number;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    @Override
    public String toString() {
        return symbol+" "+number;
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        Set<Card> cards = new HashSet<>();
        for(int i=0; i<8; i++) {
            System.out.println("Enter a card:");
            Card c = new Card(scr.nextLine(),scr.nextInt());
            scr.nextLine();
            boolean isPresent=false;
            for (Card j : cards) {
                if (Objects.equals(c.getSymbol(), j.getSymbol())) {
                    isPresent = true;
                    break;
                }
            }
            if (!isPresent) {
                cards.add(c);
            }
        }
        for(Card card : cards) {
            System.out.println(card);
        }
    }
}
