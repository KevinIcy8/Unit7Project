import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("What would you like to do? \n1.Calculate cost of one package \n2.Simulate packages \n3.How package costs are calculated\n4.Exit\nInput: ");
        String choice = s.nextLine();
        if(choice.equals("1")){
            System.out.println("---------------------------------------------");
            System.out.print("Enter the zip code of the origin package: ");
            String origin = s.nextLine();
            System.out.print("Enter the zip code of the destination package: ");
            String destination = s.nextLine();
            System.out.print("Enter the weight of the package: ");
            String weight = s.nextLine();
            while(!Package.checkWeight(Double.parseDouble(weight))){
                System.out.println("The weight of the package is too light; it must be greater than 0.1 pound");
                System.out.print("Enter the weight of the package: ");
                weight = s.nextLine();
            }
            System.out.print("Enter the height of the package: ");
            String height = s.nextLine();
            while(!Package.checkHeight(Double.parseDouble(height))){
                System.out.println("The height of the package is too small; it must be greater than 2 inches");
                System.out.print("Enter the weight of the package: ");
                height = s.nextLine();
            }
            System.out.print("Enter the length of the package: ");
            String length = s.nextLine();
            while(!Package.checkLength(Double.parseDouble(length))){
                System.out.println("The length of the package is too small; it must be greater than 2 inches");
                System.out.print("Enter the weight of the package: ");
                length = s.nextLine();
            }
            System.out.print("Enter the width of the package: ");
            String width = s.nextLine();
            while(!Package.checkWidth(Double.parseDouble(width))){
                System.out.println("The width of the package is too small; it must be greater than 2 inches");
                System.out.print("Enter the width of the package: ");
                width = s.nextLine();
            }
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println("Cost: $" + df.format((PostageCalculator.calculatePackage(Integer.parseInt(origin), Integer.parseInt(destination), Double.parseDouble(weight), Double.parseDouble(height), Double.parseDouble(length), Double.parseDouble(width)))));
        }
        else if(choice.equals("2")){
            System.out.print("How many packages would you like to simulate? ");
            String numOfPack = s.nextLine();
            System.out.println("Randomly generated packages info: ");
            PackageSimulator simulator = new PackageSimulator();
            simulator.generatePackages(Integer.parseInt(numOfPack));
            for(int i = 0; i < simulator.getPackages().size();i++){
                System.out.println("Package " + (i+1) + ": ____________________________________________");
                System.out.println(simulator.getSimulationInfo(i));
            }
            System.out.println("____________________________________________");
            System.out.println("Total cost of all packages: " + simulator.generateTotalCost());
        }
        else if(choice.equals("3")){
            System.out.println();
            System.out.println("How we calculate our packages: \n" +
                    "The base cost is $3.75\n" +
                    "We add 5 cents for each tenth of a pound\n" +
                    "We then divide the difference in county codes by 100 and add that to calculate the final total\n" +
                    "The county code is the first 3 digits of the zip code\n");
            System.out.println("Accounting for oversize packages:\n" +
                    "Any package that exceeds a combined 36 inches will cost an additional 10 cents per inch.\n" +
                    "Additionally, packages that are more than 40 pounds will be charged 10 cents per tenth of a pound over the 40 pound limit.\n");

            System.out.println("Example: \nWeight of package: 1 pound\nOrigin zipcode: 20000\nDestination zipcode: 10000\n" +
                    "3.75 + (1/0.1) * 0.05 + (200-100)/100");
        }

    }
}

