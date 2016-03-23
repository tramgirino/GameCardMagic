package cardgame;

// utility class implementing code common to all effects linked with cards:
// remove card from hand and place the effect on the stack on play
public abstract class AbstractCardEffect extends AbstractEffect {
    
    //di chi é la carta
    protected Player owner;
    //il tipo di carta
    protected Card card;
    //associa l'effetto della carta 
    protected AbstractCardEffect(Player p, Card c) { owner=p; card=c; }
    
    //rimuove la carta dalla mano ed inserisce gli effetti nello stack
    public boolean play() { 
        owner.get_hand().remove(card);
        return super.play();
    }
    
    //ritorna la descrizione della carta in formato stringa
    public String toString() { return card.toString(); }
    
}
