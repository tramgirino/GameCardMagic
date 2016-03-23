package cardgame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class DefaultCombatPhase implements Phase {
    
    public void execute() {
        Player current_player = CardGame.instance.get_current_player();
        
        Scanner in= CardGame.instance.get_scanner();
        List<Creature> strAtt;
        
        System.out.println(current_player.get_name() + ": combat phase");
        
        CardGame.instance.get_triggers().trigger(Phases.COMBAT_FILTER);
        // TODO combat
        boolean flag=false;
        System.out.println("vuoi attaccare con una creatura? (y/n)");
        String confirm=in.nextLine();
        if( (current_player.getNumberCreaturesUntapped()!= 0) && (confirm=="n" || confirm=="N" || confirm=="no" || confirm=="NO") ){ flag=true;} 
        
        while( !flag ){
            /*visualizzo le creature che possono giocare*/
            strAtt=current_player.get_creatures();
            System.out.println("Che possono attaccare sono");
            for(Creature c:current_player.get_creatures()) {
                if(!c.isTapped()){
                    System.out.println(c.name());
                }
            }
            
            System.out.println("scrivi il nome delle creature con la quale vuoi attaccare");
                      
            /*seleziono una delle creature*/
            
            String tmp=in.nextLine();
            
            Iterator<Creature> iter=strAtt.iterator();
            int i=0;
            
            while(iter.hasNext() && flag!=false){
                Creature creatura=iter.next();
                if(tmp ==creatura.name() ){
                    flag=true;
                    creatura.tap();
                }
            }
            
            System.out.println("vuoi attaccare con un altra creatura? (y/n)");
            confirm=in.nextLine();
            if( (current_player.getNumberCreaturesUntapped()!= 0) && (confirm=="n" || confirm=="N" || confirm=="no" || confirm=="NO") ){ flag=true;} 
           
            
        }
        
        
    }
    
}
