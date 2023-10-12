package Cartas;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;

public class Departure
{
    private final Stack<Cards> deck = new Stack<>();
    public final Queue<Player> list_players = new LinkedList<>();
    public ArrayList<Integer> scoreboard = new ArrayList<>();

    {
        list_players.offer(new Player("Jugador 1"));
        list_players.offer(new Player("Jugador 2"));
        list_players.offer(new Player("Jugador 3"));
        list_players.offer(new Player("Jugador 4"));

        scoreboard.add(0);
        scoreboard.add(0);
        scoreboard.add(0);
        scoreboard.add(0);

        while (!full()) {
            double color_random = Math.random(), number_random = Math.random();
            Color color;
            int number;

            if(color_random <= 0.25)
                color = Color.COIN;
            else if(color_random <= 0.50)
                color = Color.CUP;
            else if(color_random <= 0.75)
                color = Color.SWORD;
            else
                color = Color.WAND;

            if(number_random <= 0.10)
                number = 1;
            else if(number_random <= 0.20)
                number = 10;
            else if(number_random <= 0.30)
                number = 9;
            else if(number_random <= 0.40)
                number = 8;
            else if(number_random <= 0.50)
                number = 7;
            else if(number_random <= 0.60)
                number = 6;
            else if(number_random <= 0.70)
                number = 5;
            else if(number_random <= 0.80)
                number = 4;
            else if(number_random <= 0.90)
                number = 3;
            else
                number = 2;

            if(check(number, color))
                continue;

            Cards card = new Cards(number, color);
            turns().getHand().add(card);
            deck.push(card);
        }
    }

    public boolean full()
    {
        return deck.size() == 40;
    }

    public boolean check(int number, Color type){
        int index = 0;

        while(index != deck.size()){
            Cards card = deck.get(index);

            if(card.number == number && card.type.equals(type))
                return true;

            index++;
        }

        return false;
    }

    public void winner(){
        ArrayList<Player> cache_players = new ArrayList<>();
        cache_players.add(turns());

        for(int i = 0; i < list_players.size() - 1; i++){
            Player player = turns();
            if(player.score > cache_players.get(0).score){
                cache_players.clear();
                cache_players.add(player);
            }
            else if(player.score == cache_players.get(0).score)
                cache_players.add(player);
        }
        int index = 0;

        for(int i = 0; i < list_players.size(); i++){
            if(turns().equals(cache_players.get(index))){
                scoreboard.set(i, scoreboard.get(i) + 1);
                if(index != cache_players.size() - 1)
                    index++;
            }
        }


    }
    public Player turns(){
        Player turn = list_players.poll();
        list_players.offer(turn);
        return turn;
    }

}
