package davvo.homebase.misc;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class HomeData {
    String homeName;
    UUID homeOwner;
    Location homeLocation;

    public HomeData(String homeName, UUID homeOwner, Location homeLocation){
        this.homeName = homeName;
        this.homeOwner = homeOwner;
        this.homeLocation = homeLocation;
    }

    public String getName(){
        return homeName;
    }

    public Player getOwner(){
        return Bukkit.getPlayer(homeOwner);
    }

    public Location getLocation(){
        return homeLocation;
    }
}
