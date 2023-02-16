public class Package {
    private Address origin;
    private Address destination;
    private double weight; //in pounds;  >= 0.1
    private double length; //measurements in inches; >= 2
    private double height;
    private double width;

    public boolean checkWeight(double weight){
        if(weight < 0.1){
            return false;
        }
        return true;
    }

    public boolean checkMeasurements(double l, double h, double w){
        if(l < 2 || h < 2 || w < 2){
            return false;
        }
        return true;
    }

    public Address getOrigin() {
        return origin;
    }

    public void setOrigin(Address origin) {
        this.origin = origin;
    }

    public Address getDestination() {
        return destination;
    }

    public void setDestination(Address destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }


}
