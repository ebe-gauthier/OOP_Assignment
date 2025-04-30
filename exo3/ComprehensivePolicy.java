package exo3;
import java.time.LocalDate;
public class ComprehensivePolicy extends InsurancePolicy {

    public ComprehensivePolicy(String policyId, Vehicle vehicle, Person policyHolder,
                               double coverageAmount, LocalDate start, LocalDate end) {
        super(policyId, vehicle, policyHolder, coverageAmount, start, end);
        validatePolicy();
        calculatePremium();
    }

    @Override
    public void calculatePremium() {
        int age = LocalDate.now().getYear() - vehicle.getVehicleYear();
        this.premiumAmount = coverageAmount * (0.02 + age * 0.001);
    }

    @Override
    public void processClaim(double amount) {
        if (amount <= coverageAmount) {
            System.out.println("Claim approved: $" + amount);
        } else {
            System.out.println("Claim denied. Amount exceeds coverage.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("\n--- Comprehensive Policy Report ---");
        System.out.println("Policy ID: " + policyId);
        System.out.println("Holder: " + policyHolder);
        System.out.println("Vehicle: " + vehicle);
        System.out.println("Premium: $" + premiumAmount);
        System.out.println("Coverage: $" + coverageAmount);
    }

    @Override
    public void validatePolicy() {
        if (!vehicle.getVehicleType().equalsIgnoreCase("private")) {
            throw new IllegalArgumentException("Only private vehicles allowed.");
        }
    }
}

