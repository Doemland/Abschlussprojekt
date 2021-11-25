package at.wifi.bakeryservice.config;

import java.io.IOException;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.hsqldb.server.ServerAcl;

public class HSQLStarter{

    public static void main(String[] args){
        final Server server;
        final HsqlProperties properties = new HsqlProperties();
        properties.setProperty("server.database.0", "file:C:/Users/WarSp/OneDrive/Desktop/Software Developer Java für Einsteiger/WIFI15032021/Projekt/Abschlussprojekt/DB/bakery;user=sa;password=sa");
        properties.setProperty("server.dbname.0", "bakery");
        properties.setProperty("server.port", "9003");
        properties.setProperty("server.address", "127.0.0.1");

        server = new Server();
        try {
            server.setProperties(properties);
        } catch (IOException | ServerAcl.AclFormatException e) {
            e.printStackTrace();
        }
        server.start();
    }
}

