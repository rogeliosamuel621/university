package simu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Cards {

    private List<String> cards;

    public Cards() {
        cards = new ArrayList<>();
        generateDeck();
    }

    private void generateDeck() {
        String [] letters = {"O", "C", "E", "P"};

        for (int i = 13; i >= 2; i--) {

            for (String letter : letters) {
                cards.add( i + letter );
            }

        }

        Collections.shuffle( cards );

    }

    public List<String> getCards() {
        return cards;
    }

}
