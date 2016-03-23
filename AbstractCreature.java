package cardgame;

// utility clas implementing common defaul behavior and fields for creatures
// creatures with differenf behavior from the default nee not extend it
public abstract class AbstractCreature implements Creature {
    protected Player owner;
    protected boolean is_tapped=false;
    protected int damage_left = get_toughness();
        
        //crea una creatura astratta di proprietà del player
        protected AbstractCreature(Player owner) { this.owner=owner; 
        
        }
        /*
        controlla se la carta é in stato tappato o no
        se non tappata cambia lo stato della variabile is_tapped in true e ritorna true
        altrimenti ritoena false
        */
        public boolean tap() { 
            if (is_tapped) {
                System.out.println("creature " + name() + " already tapped");
                return false;
            }
            
            System.out.println("tapping creature " + name());
            is_tapped=true; 
            return true; 
        }
        /*
        controlla se la carta é in stato di untapped o no
        se tapped cambia lo stato di is_tapped in false e ritorna true
        altrimenti ritona false
        */
        public boolean untap() { 
            if (!is_tapped) {
                System.out.println("creature " + name() + " not tapped");
                return false;
            }
            
            System.out.println("untapping creature " + name());
            is_tapped=false; 
            return true; 
        }
        //controlla la variabile is_tapped
        public boolean isTapped() { return is_tapped; }
        //DA IMPLEMENTARE A PIACERE 
        public void attack() {
            
        } // to do in assignment 2
        /*
        ritorna la creatura con la quale si vuole difendere
        DA IMPLEMENTARE MEGLIO
        */
        public void defend(Creature c) {} // to do in assignment 2
        /*
        riceve un danno
        se il danno é maggiore della difesa della carta allora distrugge la creatura
        */
        public void inflict_damage(int dmg) { 
            damage_left -= dmg; 
            if (damage_left<=0)
                owner.destroy(this);        
        }
       
        // reimposta il valore originale del danno della carta
        public void reset_damage() { damage_left = get_toughness(); }
    
}
