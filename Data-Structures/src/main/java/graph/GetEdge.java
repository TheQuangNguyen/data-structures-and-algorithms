package graph;

import java.util.List;
import java.util.Set;

public class GetEdge {

    //
    public static int tripCost(Graph<String> citiesMap, String[] itinerary) {

        if (itinerary.length < 2) {
            return -1;
        }

        int cityIndex = 0;
        int cost = 0;
        Node<String> currentCity = null;
        Set<Node<String>> listOfCities = citiesMap.getNodes();

        // find the node that contains the first city in the itinerary to start
        for (Node<String> city: listOfCities) {
            if (city.getValue().equals(itinerary[cityIndex])) {
                currentCity = city;
                break;
            }
        }
        cityIndex++;

        // while there are still cities left to fly to in the itinerary
        // check the current cities neighbors and see if the next city is one of those neighbors
        // if yes, add the cost of the flight to the total and move to the next city
        // if not, return -1 right away
        while (cityIndex < itinerary.length) {
            List<Edge<String>> neighbors = currentCity.getNeighbors();
            boolean foundNextCity = false;
            for(Edge<String> neighbor : neighbors) {
                if (neighbor.getNode().getValue().equals(itinerary[cityIndex])) {
                    cost += neighbor.getWeight();
                    cityIndex++;
                    currentCity = neighbor.getNode();
                    foundNextCity = true;
                    break;
                }
            }

            if (!foundNextCity) {
                return -1;
            }
        }

        return cost;
    }
}
