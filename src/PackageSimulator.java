import java.util.ArrayList;

public class PackageSimulator {
    private ArrayList<Package> packages;

   public ArrayList<Package> generatePackages(int numOfPackages){
        for(int i = 0; i < numOfPackages; i++){
            packages.add(new Package());
        }
        return packages;
    }

    public Address addressGenerator(){
        String stateNames = "Alabama, Alaska, Arizona, Arkansas, California, Colorado, Connecticut, Delaware," +
                "Florida, Georgia, Hawaii, Idaho, Illinois, Indiana, Iowa, Kansas, Kentucky, Louisiana, Maine, Maryland," +
                "Massachusetts, Michigan, Minnesota, Mississippi, Missouri, Montana, Nebraska, Nevada, New Hampshire, " +
                "New Jersey, New Mexico, New York, North Carolina, North Dakota, Ohio, Oklahoma, Oregon, Pennsylvania, " +
                "Rhode Island, South Carolina, South Dakota, Tennessee, Texas, Utah, Vermont, Virginia, Washington," +
                " West Virginia, Wisconsin, Wyoming";
        String[] states = stateNames.split(",");
        int randomNum = (int)(Math.random()*50);
        String randomState = states[randomNum];
        int randomHouseNumber = (int)(Math.random()*9899)+100;
        String rHN = String.valueOf(randomHouseNumber);
        String streetSuffixes = "Street, Lane, Boulevard, Road, Drive, Way";


        //Address random = new Address()

    }



    public double generateTotalCost(){
        return 0.0;
    }

    public String getSimulationInfo(){
        return "";
    }

    public void resetSimulation(){

    }
}


