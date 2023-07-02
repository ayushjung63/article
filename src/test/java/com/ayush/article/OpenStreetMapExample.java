package com.ayush.article;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenStreetMapExample {
    public static void main(String[] args) {
        // Generate the HTML file content
        String htmlContent = generateHTML();

        // Save the HTML content to a file
        try {
            Path htmlFilePath = Path.of("map.html"); // Replace with your desired file path
            Files.writeString(htmlFilePath, htmlContent, StandardOpenOption.CREATE);
            System.out.println("map.html file created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating map.html file: " + e.getMessage());
        }
    }

    private static String generateHTML() {
        double userLatitude = 27.6880028279767;  // User's latitude
        double userLongitude =  85.30734511406162;  // User's longitude


        StringBuilder sb = new StringBuilder();
        sb.append("<html>\n");
        sb.append("<head>\n");
        sb.append("    <link rel=\"stylesheet\" href=\"https://unpkg.com/leaflet@1.7.1/dist/leaflet.css\" />\n");
        sb.append("    <script src=\"https://unpkg.com/leaflet@1.7.1/dist/leaflet.js\"></script>\n");
        sb.append("</head>\n");
        sb.append("<body>\n");
        sb.append("    <div id=\"map\" style=\"height: 900px;\"></div>\n");
        sb.append("    <script>\n");
        sb.append("        var map = L.map('map').setView([27.687945878854304, 85.30814979851364], 10); // Set your initial map center coordinates and zoom level\n");
        sb.append("        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {\n");
        sb.append("            attribution: 'Map data &copy; <a href=\"https://www.openstreetmap.org/\">OpenStreetMap</a> contributors',\n");
        sb.append("            maxZoom: 19\n");
        sb.append("        }).addTo(map);\n");

        // Add multiple coordinates and markers
        double[][] coordinates  = {
                {27.687318805148372, 85.30699106255175},
                {27.68706229550731, 85.30760260624035},
                // Add more coordinates here
        };

        for (double[] coordinate : coordinates) {
            double locationLatitude = coordinate[0];
            double locationLongitude = coordinate[1];

            double distance = calculateDistance(userLatitude, userLongitude, locationLatitude, locationLongitude);

            sb.append("        var marker = L.marker([").append(locationLatitude).append(", ").append(locationLongitude).append("]).addTo(map);\n");
            sb.append("        marker.bindPopup('Distance: ").append(distance).append(" m');\n");
        }

        sb.append("    </script>\n");
        sb.append("</body>\n");
        sb.append("</html>");

        return sb.toString();
    }

    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Radius of the Earth in kilometers
        double earthRadius = 6371;

        // Convert latitude and longitude to radians
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);

        // Calculate the differences between coordinates
        double latDiff = lat2Rad - lat1Rad;
        double lonDiff = lon2Rad - lon1Rad;

        // Calculate the distance using the Haversine formula
        double a = Math.sin(latDiff / 2) * Math.sin(latDiff / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(lonDiff / 2) * Math.sin(lonDiff / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = earthRadius * c;

        return distance*1000;
    }





}



