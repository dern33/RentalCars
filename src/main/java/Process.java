import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.*;



public class Process {
    public static Car[] getCars()throws Exception{
        String json = getJson();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);
        JsonNode list = root.path("Search").path("VehicleList");
        Car[] listCars = mapper.treeToValue(list, Car[].class);
        return listCars;
    }

    //Get Data
    public static String getJson() throws Exception {

        String url = "http://www.rentalcars.com/js/vehicles.json";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String json = response.toString();
        return json;

    }
    //Part 1.1
    public static Car[] getAscList(Car[] list){
        Arrays.sort(list);
        return list;
    }
    //Part 1.2
    public static Car[] getSpecList(Car[] list){
        return list;
    }
    //Part 1.3
    public static List<Car> getHighSup(Car[] list){
        Map<String,Car> mapCarTypes = new HashMap();
        for(Car item:list){
            if(!mapCarTypes.containsKey(item.getCarType())||item.getRating()>mapCarTypes.get(item.getCarType()).getRating()){
                mapCarTypes.put(item.getCarType(),item);
            }
        }
        List<Car> highSupList = new ArrayList<Car>(mapCarTypes.values());
        Collections.sort(highSupList, new Comparator<Car>() {
            public int compare(Car o1, Car o2) {
                if(o1.getScore() > o2.getScore()){
                    return -1;
                }else if(o1.getScore() < o2.getScore()) {
                    return 1;
                }
                return 0;
            }
        });

        return highSupList;

    }
    //Part 1.4
    public static Car[] getCarScore(Car[] list){
        Arrays.sort(list, new Comparator<Car>() {
            public int compare(Car o1, Car o2) {
                //return o1.getSumScores().compareTo(o2.getSumScores());
                if(o1.getSumScores() > o2.getSumScores()){
                    return -1;
                }else if(o1.getSumScores() < o2.getSumScores()) {
                    return 1;
                }
                return 0;
            }
        });
        return list;
    }
}
