package cardgame;

import java.util.ArrayDeque;
import java.util.Iterator;


public class CardStack implements Iterable<Effect> {
    //crea lo stack
    private final ArrayDeque<Effect> stack = new ArrayDeque<>();
    //crea un iteratore dello stack
    public Iterator<Effect> iterator() { return stack.iterator(); }
     //aggiunge un effetto allo stack
    public void add(Effect e) { 
        stack.push(e); 
    }
    //rimuove un effetto di una carta/stregoneria dallo stack
    public void remove(Effect e) { stack.remove(e); }
     //svuota lo stack risolvendo gli effetti accumulati all interno
    public void resolve() {
        while(!stack.isEmpty()) { 
            Effect e = stack.pop();
            
            System.out.println("Stack: resolving " + e);
            
            e.resolve(); 
        }
    }
}
