package exo3;
import java.time.LocalDate;

public class CollisionPolicy extends InsurancePolicy {
    private boolean safeDriver;

    public CollisionPolicy(String policyId, Vehicle vehicle, Person policyHolder,
                           double coverageAmount, LocalDate start, LocalDate end, boolean safeDriver) {
        super(policyId, vehicle, policyHolder, coverageAmount, start, end);
        this.safeDriver = safeDriver;
        validatePolicy();
        calculatePremium();
    }

    @Override
    public void calculatePremium() {
        premiumAmount = coverageAmount * 0.03;
        if (safeDriver) premiumAmount *= 0.9;  // 10% discount
    }

    @Override
    public void processClaim(double amount) {
        if (amount <= coverageAmount) {
            System.out.println("Collision claim approved.");
        } else {
            System.out.println("Claim rejected.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("\n--- Collision Policy Report ---");
        System.out.println("Policy ID: " + policyId);
        System.out.println("Holder: " + policyHolder);
        System.out.println("Safe Driver: " + safeDriver);
        System.out.println("Premium: $" + premiumAmount);
    }

    @Override
    public void validatePolicy() {
        System.out.println("Safety inspection passed for " + vehicle.getVehicleId());
    }
}

