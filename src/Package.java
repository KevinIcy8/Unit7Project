public class Package {
    private Address origin;
    private Address destination;
    private double weight; //in pounds;  >= 0.1
    private double length; //measurements in inches; >= 2
    private double height;
    private double width;

    public Package(Address o, Address d, double weight, double l, double h, double w){
        origin = o;
        destination = d;
        this.weight = weight;
        length = l;
        height = h;
        width = w;
    }

    public static boolean checkWeight(double weight){
        if(weight < 0.1){
            return false;
        }
        return true;
    }

    public static boolean checkLength(double l){
        if(l < 2){
            return false;
        }
        return true;
    }

    public static boolean checkHeight(double h){
        if( h < 2){
            return false;
        }
        return true;
    }
    public static boolean checkWidth(double w){
        if(w < 2){
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
