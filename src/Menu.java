import java.text.DecimalFormat;
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
    }
}

