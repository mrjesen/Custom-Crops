package net.momirealms.customcrops.datamanager;

import net.momirealms.customcrops.CustomCrops;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Objects;

public class NextSeason {

    public static void changeSeason(){
        FileConfiguration config = CustomCrops.instance.getConfig();
        String currentSeason = ConfigManager.Config.current;
        String nextSeason;
        switch (Objects.requireNonNull(currentSeason)) {
            case "spring":
                nextSeason = "summer";
                break;
            case "summer":
                nextSeason = "autumn";
                break;
            case "autumn":
                nextSeason = "winter";
                break;
            case "winter":
                nextSeason = "spring";
                break;
            default:
                nextSeason = null;
                break;
        }
        if(nextSeason != null){
            config.set("current-season", nextSeason);
            ConfigManager.Config.current = nextSeason;
            CustomCrops.instance.saveConfig();
        }else {
            CustomCrops.instance.getLogger().warning("季节配置文件出错!");
        }
    }
}