public class Car implements Comparable<Car>{
    public String sipp;
    public String name;
    public Double price;
    public String supplier;
    public Double rating;


    public String getSipp() {
        return sipp;
    }

    public void setSipp(String sipp) {
        this.sipp = sipp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int compareTo(Car other) {
        return price.compareTo(other.price);
    }

    public String getCarType() {
        switch(sipp.charAt(sipp.length()-4)){
            case 'M': return "Mini";
            case 'E': return "Economy";
            case 'C': return "Compact";
            case 'I': return "Intermediate";
            case 'S': return "Standard";
            case 'F': return "Full size";
            case 'P': return "Premium";
            case 'L': return "Luxury";
            case 'X': return "Special";
            default: return "Unidentified";
        }
    }
    public String getCarDoors() {
        switch(sipp.charAt(sipp.length()-3)){
            case 'B': return "2 doors";
            case 'C': return "4 doors";
            case 'D': return "5 doors";
            case 'W': return "Estate";
            case 'T': return "Convertible";
            case 'F': return "SUV";
            case 'P': return "Pick Up";
            case 'V': return "Passanger Van";
            default: return "Unidentified";
        }
    }
    public String getTransmisson() {
        switch(sipp.charAt(sipp.length()-2)){
            case 'M': return "Manual";
            case 'A': return "Automatic";
            default: return "Unidentified";
        }
    }
    public String getAirCon() {
        switch(sipp.charAt(sipp.length()-1)){
            case 'N': return "No AC";
            case 'R': return "AC";
            default: return "Unidentified";
        }
    }
    public String getFuel() {
        switch(sipp.charAt(sipp.length()-1)){
            case 'N': return "Petrol";
            case 'R': return "Petrol";
            default: return "Unidentified";
        }
    }
    public int getScore(){
        int score = 0;
        if(getTransmisson().equals("Manual"))
            score++;
        if(getTransmisson().equals("Automatic"))
            score += 2;
        if(getAirCon().equals("AC"))
            score += 5;
        return score;
    }
    public double getSumScores(){
        return getScore()+getRating();
    }
    public String printP11(){
        return "{"+getName()+"}-{"+getPrice()+"}";
    }
    public String printP12(){
        return "{"+getName()+"}-{"+getSipp()+"}-{"+getCarType()+"}-{"+getCarDoors()+"}-{"+getTransmisson()
                +"}-{"+getFuel()+"}-{"+getAirCon()+"}";
    }
    public String printP13(){
        return "{"+getName()+"}-{"+getCarType()+"}-{"+getSupplier()+"}-{"+getRating()+"}";
    }
    public String printP14(){
        return "{"+getName()+"}-{"+getScore()+"}-{"+getRating()+"}-{"+getSumScores()+"}";
    }
}
