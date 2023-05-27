package player;

import java.util.LinkedList;
import java.util.List;

public class PlayerTestHelper {
    public List<Player> getPlayers() {
        final List<Player> scorers = new LinkedList<>();
        scorers.add(new Player("Ali Daei",109));
        scorers.add(new Player("Ali Daei",109));
        scorers.add(new Player("Cristiano Ronaldo",122));
        scorers.add(new Player("Lionel Messi",102));
        scorers.add(new Player("Mokhtar Dahari",89));
        return scorers;
    }
}
