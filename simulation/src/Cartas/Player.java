package Cartas;

import java.util.ArrayList;

public class Player
{
    public String gamertag;
    private final ArrayList<Cards> hand = new ArrayList<>();
    public int score = 0;

    public Player(String gamertag) {
        this.gamertag = gamertag;
    }

    public ArrayList<Cards> getHand() {
        return hand;
    }

    public Player major_card(Player person, int index){
        Cards cards_1 = hand.get(index);
        Cards cards_2 = person.hand.get(index);

        if(cards_1.major() < cards_2.major())
            return this;
        else if(cards_1.major() > cards_2.major())
            return person;

        if(cards_1.type.color() < cards_2.type.color())
            return this;

        return person;
    }

    @Override
    public String toString() {
        return "Players{" +
                "gamertag='" + gamertag + '\'' +
                ", hand=" + hand +
                '}';
    }
}
