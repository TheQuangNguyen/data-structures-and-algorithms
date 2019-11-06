package graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static graph.GetEdge.*;

public class GetEdgeTest {

    Graph<String> citiesMap;

    @Before
    public void setUp() throws Exception {
        citiesMap = new Graph<>();
    }

    // Test for normal case where all cities are connect to one another and there is one flight
    @Test
    public void testTripCostWhereAllCitiesAreConnectedToEachOtherAndThereIsOneDirectFlight() {
        Node pandora = citiesMap.addNode("Pandora");
        Node arendelle = citiesMap.addNode("Arendelle");
        Node metroville = citiesMap.addNode("Metroville");
        Node monstropolis = citiesMap.addNode("Monstropolis");
        Node narnia = citiesMap.addNode("Narnia");
        Node naboo = citiesMap.addNode("Naboo");

        citiesMap.addEdge(pandora, arendelle, 150);
        citiesMap.addEdge(pandora, metroville, 82);
        citiesMap.addEdge(arendelle, pandora, 150);
        citiesMap.addEdge(arendelle, metroville, 99);
        citiesMap.addEdge(arendelle, monstropolis, 42);
        citiesMap.addEdge(metroville, pandora, 82);
        citiesMap.addEdge(metroville, arendelle, 99);
        citiesMap.addEdge(metroville, monstropolis, 105);
        citiesMap.addEdge(metroville, narnia, 37);
        citiesMap.addEdge(metroville, naboo, 26);
        citiesMap.addEdge(monstropolis, arendelle, 42);
        citiesMap.addEdge(monstropolis, metroville, 105);
        citiesMap.addEdge(monstropolis, naboo, 73);
        citiesMap.addEdge(naboo, narnia, 250);
        citiesMap.addEdge(naboo, metroville, 26);
        citiesMap.addEdge(naboo, monstropolis, 73);
        citiesMap.addEdge(narnia, metroville, 37);
        citiesMap.addEdge(narnia, naboo, 250);

        String[] itinerary = new String[]{"Arendelle", "Monstropolis", "Naboo"};
        int result = tripCost(citiesMap, itinerary);

        assertEquals(115, result);
    }

    // Test for normal case where all cities are connect to one another and there are two direct flights
    @Test
    public void testTripCostWhereAllCitiesAreConnectedToEachOtherAndThereAreTwoDirectFlights() {
        Node pandora = citiesMap.addNode("Pandora");
        Node arendelle = citiesMap.addNode("Arendelle");
        Node metroville = citiesMap.addNode("Metroville");
        Node monstropolis = citiesMap.addNode("Monstropolis");
        Node narnia = citiesMap.addNode("Narnia");
        Node naboo = citiesMap.addNode("Naboo");

        citiesMap.addEdge(pandora, arendelle, 150);
        citiesMap.addEdge(pandora, metroville, 82);
        citiesMap.addEdge(arendelle, pandora, 150);
        citiesMap.addEdge(arendelle, metroville, 99);
        citiesMap.addEdge(arendelle, monstropolis, 42);
        citiesMap.addEdge(metroville, pandora, 82);
        citiesMap.addEdge(metroville, arendelle, 99);
        citiesMap.addEdge(metroville, monstropolis, 105);
        citiesMap.addEdge(metroville, narnia, 37);
        citiesMap.addEdge(metroville, naboo, 26);
        citiesMap.addEdge(monstropolis, arendelle, 42);
        citiesMap.addEdge(monstropolis, metroville, 105);
        citiesMap.addEdge(monstropolis, naboo, 73);
        citiesMap.addEdge(naboo, narnia, 250);
        citiesMap.addEdge(naboo, metroville, 26);
        citiesMap.addEdge(naboo, monstropolis, 73);
        citiesMap.addEdge(narnia, metroville, 37);
        citiesMap.addEdge(narnia, naboo, 250);

        String[] itinerary = new String[]{"Metroville", "Pandora"};
        int result = tripCost(citiesMap, itinerary);

        assertEquals(82, result);
    }

    // Test for normal case where all cities are connect to one another and there are no direct flights
    @Test
    public void testTripCostWhereAllCitiesAreConnectedToEachOtherAndThereAreNoDirectFlight() {
        Node pandora = citiesMap.addNode("Pandora");
        Node arendelle = citiesMap.addNode("Arendelle");
        Node metroville = citiesMap.addNode("Metroville");
        Node monstropolis = citiesMap.addNode("Monstropolis");
        Node narnia = citiesMap.addNode("Narnia");
        Node naboo = citiesMap.addNode("Naboo");

        citiesMap.addEdge(pandora, arendelle, 150);
        citiesMap.addEdge(pandora, metroville, 82);
        citiesMap.addEdge(arendelle, pandora, 150);
        citiesMap.addEdge(arendelle, metroville, 99);
        citiesMap.addEdge(arendelle, monstropolis, 42);
        citiesMap.addEdge(metroville, pandora, 82);
        citiesMap.addEdge(metroville, arendelle, 99);
        citiesMap.addEdge(metroville, monstropolis, 105);
        citiesMap.addEdge(metroville, narnia, 37);
        citiesMap.addEdge(metroville, naboo, 26);
        citiesMap.addEdge(monstropolis, arendelle, 42);
        citiesMap.addEdge(monstropolis, metroville, 105);
        citiesMap.addEdge(monstropolis, naboo, 73);
        citiesMap.addEdge(naboo, narnia, 250);
        citiesMap.addEdge(naboo, metroville, 26);
        citiesMap.addEdge(naboo, monstropolis, 73);
        citiesMap.addEdge(narnia, metroville, 37);
        citiesMap.addEdge(narnia, naboo, 250);

        String[] itinerary = new String[]{"Naboo", "Narnia", "Pandora"};
        int result = tripCost(citiesMap, itinerary);

        assertEquals(-1, result);
    }

    // test for when there is only one city in the itinerary
    @Test
    public void testTripCostWhenThereOnlyOneCityInItinerary() {
        Node pandora = citiesMap.addNode("Pandora");
        Node arendelle = citiesMap.addNode("Arendelle");
        Node metroville = citiesMap.addNode("Metroville");
        Node monstropolis = citiesMap.addNode("Monstropolis");
        Node narnia = citiesMap.addNode("Narnia");
        Node naboo = citiesMap.addNode("Naboo");

        citiesMap.addEdge(pandora, arendelle, 150);
        citiesMap.addEdge(pandora, metroville, 82);
        citiesMap.addEdge(arendelle, pandora, 150);
        citiesMap.addEdge(arendelle, metroville, 99);
        citiesMap.addEdge(arendelle, monstropolis, 42);
        citiesMap.addEdge(metroville, pandora, 82);
        citiesMap.addEdge(metroville, arendelle, 99);
        citiesMap.addEdge(metroville, monstropolis, 105);
        citiesMap.addEdge(metroville, narnia, 37);
        citiesMap.addEdge(metroville, naboo, 26);
        citiesMap.addEdge(monstropolis, arendelle, 42);
        citiesMap.addEdge(monstropolis, metroville, 105);
        citiesMap.addEdge(monstropolis, naboo, 73);
        citiesMap.addEdge(naboo, narnia, 250);
        citiesMap.addEdge(naboo, metroville, 26);
        citiesMap.addEdge(naboo, monstropolis, 73);
        citiesMap.addEdge(narnia, metroville, 37);
        citiesMap.addEdge(narnia, naboo, 250);

        String[] itinerary = new String[]{"Naboo"};
        int result = tripCost(citiesMap, itinerary);

        assertEquals(-1, result);
    }
}