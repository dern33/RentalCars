import java.util.List;

public class PrintHelper {
    public static String printAscList(Car[] list) {
        StringBuffer result = new StringBuffer();
        int counter = 1;
        for(Car item: list){
            //System.out.println(item.printP11());
            result.append(counter++ + ". " + item.printP11() + "<br>");
        }
        return result.toString();
    }
    public static String printSpecList(Car[] list){
        StringBuffer result = new StringBuffer();
        int counter = 1;
        for(Car item: list){
            //System.out.println(item.printP12());
            result.append(counter++ + ". " + item.printP12() + "<br>");
        }
        return result.toString();
    }
    public static String printHighSup(List<Car> list){


        StringBuffer result = new StringBuffer();
        int counter = 1;
        for(Car item:list){
            //System.out.println(item.printP13());
            result.append(counter++ + ". " + item.printP13() + "<br>");
        }
        return result.toString();

    }
    public static String printCarScore(Car[] list){

        StringBuffer result = new StringBuffer();
        int counter = 1;
        for(Car item:list){
            //System.out.println(item.printP14());
            result.append(counter++ + ". " + item.printP14() + "<br>");
        }
        return result.toString();
    }
}
