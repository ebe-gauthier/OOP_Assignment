package exo3;
import java.time.LocalDate;
public class RoadsideAssistancePolicy extends InsurancePolicy {
    private boolean registrationVerified;

    public RoadsideAssistancePolicy(String policyId, Vehicle vehicle, Person policyHolder,
                                    double coverageAmount, LocalDate start, LocalDate end, boolean registrationVerified) {
        super(policyId, vehicle, policyHolder, coverageAmount, start, end);
        this.registrationVerified = registrationVerified;
        validatePolicy();
        calculatePremium();
    }

    @Override
    public void calculatePremium() {
        premiumAmount = 50 + (vehicle.getVehicleYear() < 2015 ? 20 : 10);
    }

    @Override
    public void processClaim(double amount) {
        if (amount <= coverageAmount) {
            System.out.println("Roadside assistance claim approved.");
        } else {
            System.out.println("Claim exceeds coverage.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("\n--- Roadside Assistance Report ---");
        System.out.println("Policy ID: " + policyId);
        System.out.println("Holder: " + policyHolder);
        System.out.println("Vehicle: " + vehicle);
        System.out.println("Registration Verified: " + registrationVerified);
        System.out.println("Premium: $" + premiumAmount);
    }

    @Override
    public void validatePolicy() {
        if (!registrationVerified)
            throw new IllegalArgumentException("Vehicle registration must be verified.");
    }
}

