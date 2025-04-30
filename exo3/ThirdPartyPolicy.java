package exo3;
import java.time.LocalDate;
public class ThirdPartyPolicy extends InsurancePolicy {
    private double engineCapacity;

    public ThirdPartyPolicy(String policyId, Vehicle vehicle, Person policyHolder,
                            double coverageAmount, LocalDate start, LocalDate end, double engineCapacity) {
        super(policyId, vehicle, policyHolder, coverageAmount, start, end);
        this.engineCapacity = engineCapacity;
        validatePolicy();
        calculatePremium();
    }

    @Override
    public void calculatePremium() {
        this.premiumAmount = 100 + engineCapacity * 0.05;
    }

    @Override
    public void processClaim(double amount) {
        if (amount <= coverageAmount) {
            System.out.println("Third-party claim approved: $" + amount);
        } else {
            System.out.println("Claim denied. Exceeds third-party coverage.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("\n--- Third-Party Policy Report ---");
        System.out.println("Policy ID: " + policyId);
        System.out.println("Holder: " + policyHolder);
        System.out.println("Vehicle: " + vehicle);
        System.out.println("Engine Capacity: " + engineCapacity + "cc");
        System.out.println("Premium: $" + premiumAmount);
    }

    @Override
    public void validatePolicy() {
        if (engineCapacity <= 0) throw new IllegalArgumentException("Invalid engine capacity.");
    }
}

