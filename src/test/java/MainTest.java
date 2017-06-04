import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;


public class MainTest {

    private static Car[] listCars;
    @BeforeClass
    public static void testSetup() throws Exception {
        byte[] encoded = Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/java/test.json"));
        String json = new String(encoded, "utf-8");

        //To test json from URL
        //String json2 = Process.getJson();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);
        JsonNode list = root.path("Search").path("VehicleList");
        listCars = mapper.treeToValue(list, Car[].class);
    }

    @Test
    public void testNumberOfObjects() {
        assertTrue(listCars.length == 3);
    }
    @Test
    public void testSortPrice() {
        Car[] sortedList = Process.getAscList(listCars);
        for(int i = 0 ; i < sortedList.length - 1; i++) {
            assertTrue(sortedList[i].getPrice() <= sortedList[i+1].getPrice());
        }
    }
    @Test
    public void testSortHighSupplier() {
        List<Car> sortedList = Process.getHighSup(listCars);
        for(int i = 0 ; i < sortedList.size() - 1; i++) {
            assertTrue(sortedList.get(i).getScore() >= sortedList.get(i+1).getScore());
        }
    }
    @Test
    public void testSortCarScore() {
        Car[] sortedList = Process.getCarScore(listCars);
        for(int i = 0 ; i < sortedList.length - 1; i++) {
            assertTrue(sortedList[i].getSumScores() >= sortedList[i+1].getSumScores());
        }
    }
}
