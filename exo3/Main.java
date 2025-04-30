package exo3;
import java.time.LocalDate;
import java.util.Scanner;



    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Policy ID:");
            String policyId = sc.nextLine();

            System.out.println("Enter Vehicle ID, Make, Model, Year, Type:");
            String vid = sc.nextLine();
            String make = sc.nextLine();
            String model = sc.nextLine();
            int year = sc.nextInt(); sc.nextLine();
            String type = sc.nextLine();
            Vehicle vehicle = new Vehicle(vid, make, model, year, type);

            System.out.println("Enter Person ID, Full Name, DOB(yyyy-mm-dd), Email, Phone:");
            String pid = sc.nextLine();
            String name = sc.nextLine();
            LocalDate dob = LocalDate.parse(sc.nextLine());
            String email = sc.nextLine();
            String phone = sc.nextLine();
            Person person = new Person(pid, name, dob, email, phone);

            System.out.println("Enter Coverage Amount:");
            double coverage = sc.nextDouble(); sc.nextLine();
            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusYears(1);

            System.out.println("Choose Policy Type (1-5):\n1. Comprehensive\n2. Third Party\n3. Collision\n4. Liability\n5. Roadside");
            int choice = sc.nextInt();

            InsurancePolicy policy = null;

            switch (choice) {
                case 1:
                    policy = new ComprehensivePolicy(policyId, vehicle, person, coverage, startDate, endDate);
                    break;
                case 2:
                    System.out.println("Enter engine capacity:");
                    double cc = sc.nextDouble();
                    policy = new ThirdPartyPolicy(policyId, vehicle, person, coverage, startDate, endDate, cc);
                    break;
                case 3:
                    System.out.println("Is the driver safe (true/false)?");
                    boolean safe = sc.nextBoolean();
                    policy = new CollisionPolicy(policyId, vehicle, person, coverage, startDate, endDate, safe);
                    break;
                case 4:
                    System.out.println("Did the person pass a medical checkup (true/false)?");
                    boolean passed = sc.nextBoolean();
                    policy = new LiabilityPolicy(policyId, vehicle, person, coverage, startDate, endDate, passed);
                    break;
                case 5:
                    System.out.println("Is registration verified (true/false)?");
                    boolean verified = sc.nextBoolean();
                    policy = new RoadsideAssistancePolicy(policyId, vehicle, person, coverage, startDate, endDate, verified);
                    break;
                default:
                    System.out.println("Invalid option.");
            }

            if (policy != null) {
                policy.generatePolicyReport();
            }

            sc.close();
        }
    }


