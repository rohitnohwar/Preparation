package rohit.nohwar.lld.structuralpatterns.flyweightpattern;

import java.util.HashMap;
import java.util.Map;

public class PlayerFactory {
    private static Map<String, Player> m = new HashMap<>();

    public static Player getPlayer(String player) {
        if(m.containsKey(player)) return m.get(player);
        else {
            if (player.equals("Terrorist")) m.put("Terrorist", new Terrorist());
            if (player.equals("CounterTerrorist")) m.put("CounterTerrorist", new CounterTerrorist());

            return m.get(player);
        }
    }
}
