import java.util.ArrayList;

public class PackageSimulator {
    private ArrayList<Package> packages;

    public PackageSimulator() {
        packages = new ArrayList<>();
    }


    public void generatePackages(int numOfPackages){
        for(int i = 0; i < numOfPackages; i++){
            packages.add(new Package(addressGenerator(),addressGenerator(),weightGenerator(),sizeGenerator(),sizeGenerator(),sizeGenerator()));
        }
    }

    public ArrayList<Package> getPackages(){
       return packages;
    }

    public Address addressGenerator(){
        String stateNames = "AL, AK, AZ, AR, CA, CO, CT, DE, FL, GA, HI, " +
                "ID, IL, IN, IA, KS, KY, LA, ME, MD, MA, MI, MN, MS, MO, " +
                "MT, NE, NV, NH, NJ, NM, NY, NC, ND, OH, OK, OR, PA, RI, " +
                "SC, SD, TN, TX, UT, VT, VA, WA, WV, WI, WY";
        String[] states = stateNames.split(",");
        int randomNum = (int)(Math.random()*50);
        String randomState = states[randomNum];
        int randomHouseNumber = (int)(Math.random()*9899)+100;
        String rHN = String.valueOf(randomHouseNumber);
        String streetSuffixes = "Street, Lane, Boulevard, Road, Drive, Way";
        String[] sSuffix = streetSuffixes.split(",");
        String rSN = sSuffix[(int)(Math.random()*6)];
        if(yesOrNo()){ //yes means the street name is going to be a number
            int randomStreetNumber = (int)(Math.random()*220)+1;
            rSN = String.valueOf(randomStreetNumber) + "th " + rSN;
        }
        else{
            String streetPrefixes = "Melody, Das, MLK, Tech, Sunshine, Frosty, Gentle Rain, Royal, Hero";
            String[] sPrefix = streetPrefixes.split(",");
            rSN = sPrefix[(int)(Math.random()*9)] + rSN;
        }
        String rAN = "";
        if(yesOrNo()){ //yes means the address has an apartment number
            if(yesOrNo()){ //yes represents only numbers for apartment number;
                rAN = String.valueOf((int)(Math.random()*999)+1);
            }
            else{
                String letters = "ABCDE";
                int random = (int)(Math.random()*5);
                rAN = String.valueOf((int)((Math.random()*999)+1)) + letters.charAt(random);
            }
        }
        String cities = "Albany, Brooklyn, Bronx, Queens, Manhattan, Staten Island, Los Angeles, Malibu, San Francisco" +
                "Los Santos, Miami, Gotham, Emerald City, Naples, Beverly Hills";
        String[] cityNames = cities.split(",");
        String rC = cityNames[(int)(Math.random()*14)];
        int rZC = (int)(Math.random()*89950)+10000;

        Address random = new Address(rHN,rSN,rAN,rC,randomState,rZC);
        return random;
    }

    public double weightGenerator(){
        return (Math.random()*50)+1.0;
    }
    public double sizeGenerator(){
        return (Math.random()*25)+5.0;
    }
    public boolean yesOrNo(){
       int random = (int)(Math.random()*2)+1;
       return random == 1;
    }



    public double generateTotalCost(){
        double total = 0.0;
        for(int i = 0; i < packages.size(); i++){
            total = total + PostageCalculator.calculatePackage(packages.get(i));
        }
        return total;
    }

    public String getSimulationInfo(int i){
        return
        "Origin Address: " + getPackages().get(i).getOrigin() + "\n" +
        "Destination Address: " + getPackages().get(i).getDestination() + "\n" +
        "Weight: " + getPackages().get(i).getWeight() + "\n" +
        "Height: " + getPackages().get(i).getHeight() + "\n" +
        "Length: " + getPackages().get(i).getLength() + "\n" +
        "Width: " + getPackages().get(i).getWidth() + "\n" +
        "Cost: " + PostageCalculator.calculatePackage(getPackages().get(i));
    }


    public void resetSimulation(){
        for(int i = 0; i < packages.size(); i++){
            packages.remove(i);
            i--;
        }
    }

}


