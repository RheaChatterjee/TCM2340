package controller;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;

import cleanWaterApp.MainApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.stage.Window;


import model.*;
import netscape.javascript.JSObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class MapController implements Initializable, MapComponentInitializedListener {
    @FXML
    private GoogleMapView mapView;

    private GoogleMap map;

    private MainApp theApp;

    private User user;

    private final ArrayList<Report> reportArrayList = SubmittedReports.getSubmittedReports();

    /** called automatically
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInializedListener(this);
    }

    /** sets stage and app
     * @param app main app
     */
    public void setCallbacks( MainApp app) {
        theApp = app;
    }

    /** Initializes map
     */
    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();

        //set up the center location for the map
        LatLong center;
        if (reportArrayList.isEmpty()) {
            center = new LatLong(34, -88);
        } else {
            Location lastLocation = reportArrayList.get(reportArrayList.size() - 1).getLocation();
            center = new LatLong(lastLocation.getLatitude(), lastLocation.getLongitude());
        }
        options.center(center)
                .zoom(5)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .mapType(MapTypeIdEnum.TERRAIN);

        map = mapView.createMap(options);


        /** now we communciate with the model to get all the locations for markers */
        List<Location> locations = new ArrayList<>();
        for (Report r : reportArrayList) {
            locations.add(r.getLocation());
        }

        for (Location l: locations) {
            MarkerOptions markerOptions = new MarkerOptions();
            LatLong loc = new LatLong(l.getLatitude(), l.getLongitude());

            markerOptions.position(loc)
                    .visible(Boolean.TRUE)
                    .title(l.getTitle());

            Marker marker = new Marker(markerOptions);

            map.addUIEventHandler(marker,
                    UIEventType.click,
                    (JSObject obj) -> {
                        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
                        infoWindowOptions.content(l.getDescription());

                        InfoWindow window = new InfoWindow(infoWindowOptions);
                        window.open(map, marker);
                    });

            map.addMarker(marker);
        }


    }


    /** closes map on click
     */
    @FXML
    public void onCloseMenu() {
        theApp.showMainScreen(user);
    }


    public void setMainApp(MainApp mainApplication) {
        theApp = mainApplication;
    }

    /** sets the user
     * @param user the logged in user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
