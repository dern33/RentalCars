import static org.omg.CORBA.ORB.init;

public class Main {
    public static void main(String[] args) throws Exception{

        Car[] list = Process.getCars();

        init();
        spark.Spark.get("/part2/asc", (request, response) -> {
            return PrintHelper.printAscList(Process.getAscList(list));
        });
        spark.Spark.get("/part2/spec", (request, response) -> {
            return PrintHelper.printSpecList(Process.getSpecList(list));
        });
        spark.Spark.get("/part2/highsuppliers", (request, response) -> {
            return PrintHelper.printHighSup(Process.getHighSup(list));
        });
        spark.Spark.get("/part2/carscore", (request, response) -> {
            return PrintHelper.printCarScore(Process.getCarScore(list));
        });
    }
}
