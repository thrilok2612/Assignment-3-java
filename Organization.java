import java.util.Scanner;

class Organization implements Cloneable {
    private int organizationCode;
    private String organizationName;
    private String organizationAddress;

    public Organization(int organizationCode, String organizationName, String organizationAddress) {
        this.organizationCode = organizationCode;
        this.organizationName = organizationName;
        this.organizationAddress = organizationAddress;
    }

    public void printDetails() {
        System.out.println("Organization Code: " + organizationCode);
        System.out.println("Organization Name: " + organizationName);
        System.out.println("Organization Address: " + organizationAddress);
    }

    @Override
    public Organization clone() {
        try {
            return (Organization) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter organization code:");
        int orgCode = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter organization name:");
        String orgName = scanner.nextLine();
        System.out.println("Enter organization address:");
        String orgAddress = scanner.nextLine();

        Organization org1 = new Organization(orgCode, orgName, orgAddress);
        Organization org2 = org1.clone();

        System.out.println("Details of Org1:");
        org1.printDetails();
        System.out.println("\nDetails of Cloned Org2:");
        org2.printDetails();

        scanner.close();
    }
}
