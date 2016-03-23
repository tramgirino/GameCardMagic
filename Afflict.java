
package cardgame.cards;

import cardgame.AbstractCardEffect;
import cardgame.AbstractCreatureCardEffect;
import cardgame.CardGame;
import cardgame.Card;
import cardgame.CardGame;
import cardgame.Creature;
import cardgame.Effect;
import cardgame.Player;
import java.util.Iterator;
import java.util.Scanner;

public class Afflict implements Card{
    
    private class AfflictEffets extends AbstractCardEffect{
        
        public AfflictEffets (Player p, Card c){
            super(p,c);
            
        }

        @Override
        public void resolve() {
            System.out.println("Scegli una delle creature sulla quale applicare l'effetto");
            Iterator iter;
            iter = CardGame.instance.get_current_adversary().;
            
        
            
            
            
        }
              

        
    }

    @Override
    public Effect get_effect(Player owner) {
        return new AfflictEffets(owner,this);
    }
    @Override
    public String name() {
        return "Afflict";
    }
    @Override
    public String type() {
        return "Instant";
    }
    @Override
    public String rule_text() {
        return name() + "Target creature gets -1/-1 until end of turn";
    }
    @Override
    public String toString() { 
        return name() + "[" + rule_text() +"]";
    } 
    @Override
    public boolean isInstant() {
        return true;
    }
    
}
