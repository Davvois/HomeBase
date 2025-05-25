package davvo.homebase.manager;

import davvo.homebase.misc.HomeData;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HomeManager {
    public Map<UUID, HomeData> homeMap = new HashMap<>();

    public void setHome(UUID playerUUID, HomeData home){
        homeMap.put(playerUUID, home);
    }

    public void removeHome(UUID playerUUID, HomeData home){
        homeMap.remove(playerUUID, home);
    }

    public HomeData getHome(UUID playerUUID){
        return homeMap.get(playerUUID);
    }
}
