package model;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Elizabeth on 10/22/2016.
 */
public class Facade {

    private static final Facade instance = new Facade();
    public static Facade getInstance() { return instance; }

    //this is our simple model
    private List<Location> locations = new ArrayList<>();



    private Facade() {
        //make up some dummy data
        for (int i = 0; i < 10; ++i) {
            Location l = new Location(34.0 + (i/10.0), -88.0 - (i/10.0), "Marker " + i, "<h2>Test "  + i + "</h2> <br> some data");
            locations.add(l);
        }
    }

    public List<Location> getLocations() { return locations; }

    public void addLocations() {
        locations.add(new Location(34.043, -88.043, "New Marker", "Some new data"));
    }
}
