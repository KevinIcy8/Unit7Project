public class PostageCalculator {

    public static double calculatePackage(int origin, int destination, double weight, double l, double h, double w){
        double base = 3.75;
        double oversizeCost = 0.0;
        double overweightCost = 0.0;
        if(weight > 40){
            overweightCost = (int)((weight - 40) / 0.1) * 0.10;
            weight = 40;
        }
        double weightCost = (int)(weight/0.1) * 0.05;
        String countyCode1 = String.valueOf(origin).substring(0,3);
        String countyCode2 = String.valueOf(destination).substring(0,3);
        double shippingCost = Math.abs(Integer.parseInt(countyCode1) - Integer.parseInt(countyCode2)) / 100.0;
        if(l + h + w > 36){
            double combinedDimensions = l+h+w;
            oversizeCost = ((int) (combinedDimensions - 36)) * 0.10;
        }
        double finalCost = base + weightCost + shippingCost + oversizeCost + overweightCost;
        return finalCost;
    }

    public static double calculatePackage(Address origin, Address destination,double weight, double l, double h, double w){
        double base = 3.75;
        double oversizeCost = 0.0;
        double overweightCost = 0.0;
        if(weight > 40){
            overweightCost = (int)((weight - 40) / 0.1) * 0.10;
            weight = 40;
        }
        double weightCost = (int)(weight/0.1) * 0.05;
        String countyCode1 = String.valueOf(origin.getZipCode()).substring(0,3);
        String countyCode2 = String.valueOf(destination.getZipCode()).substring(0,3);
        double shippingCost = Math.abs(Integer.parseInt(countyCode1) - Integer.parseInt(countyCode2)) / 100.0;
        if(l + h + w > 36){
            double combinedDimensions = l+h+w;
            oversizeCost = ((int) (combinedDimensions - 36)) * 0.10;
        }
        double finalCost = base + weightCost + shippingCost + oversizeCost + overweightCost;
        return finalCost;
    }

    public static double calculatePackage(Package pack){
        double base = 3.75;
        double oversizeCost = 0.0;
        double overweightCost = 0.0;
        double weightCost = 0.0;
        if(pack.getWeight() > 40){
            overweightCost = (int)((pack.getWeight() - 40) / 0.1) * 0.10;
            weightCost = (int)(40/0.1) * 0.05;
        }
        else{
            weightCost = (int)(pack.getWeight()/0.1) * 0.05;
        }
        String countyCode1 = String.valueOf(pack.getOrigin().getZipCode()).substring(0,3);
        String countyCode2 = String.valueOf(pack.getDestination().getZipCode()).substring(0,3);
        double shippingCost = Math.abs(Integer.parseInt(countyCode1) - Integer.parseInt(countyCode2)) / 100.0;
        if(pack.getLength() + pack.getHeight() + pack.getWidth() > 36){
            double combinedDimensions = pack.getLength() + pack.getHeight() + pack.getWidth();
            oversizeCost = ((int) (combinedDimensions - 36)) * 0.10;
        }
        double finalCost = base + weightCost + shippingCost + oversizeCost + overweightCost;
        return finalCost;
    }
}
