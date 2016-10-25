package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by elizabethcooper on 10/22/16.
 * Just a class to hold some data we might want to display on the map
 */
public class Location implements Serializable {

    private static Logger LOGGER = Logger.getLogger("Location");
    private static FileHandler logFileHandler;

    static {
        LOGGER.setLevel(Level.FINER);
        try {
            logFileHandler = new FileHandler("LogFile");
            logFileHandler.setLevel(Level.ALL);
            LOGGER.addHandler(logFileHandler);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Failed to create log file", ex);
        }
    }

    private final double longitude;
    private final double latitude;
    private String description;
    private String title;

    public Location(double lat, double lg, String ti, String desc) {
        LOGGER.entering("Location", "Constructor");
        longitude = lg;
        latitude = lat;
        title = ti;
        description = desc;
        LOGGER.exiting("Location", "Constructor");
    }

    public Location() {
        longitude = 0;
        latitude = 0;
        title = "";
        description = "";
    }

    public String toString() {
        return latitude + ", " + longitude;
    }

    public double getLongitude() { return longitude; }
    public double getLatitude() {return latitude; }
    public String getDescription() {return description;}
    public String getTitle() { return title; }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}