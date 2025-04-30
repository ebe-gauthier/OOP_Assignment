package exo3;
import java.time.LocalDate;
public class LiabilityPolicy extends InsurancePolicy {
    private boolean medicalCheckupPassed;

    public LiabilityPolicy(String policyId, Vehicle vehicle, Person policyHolder,
                           double coverageAmount, LocalDate start, LocalDate end, boolean medicalCheckupPassed) {
        super(policyId, vehicle, policyHolder, coverageAmount, start, end);
        this.medicalCheckupPassed = medicalCheckupPassed;
        validatePolicy();
        calculatePremium();
    }

    @Override
    public void calculatePremium() {
        premiumAmount = coverageAmount * 0.015;
    }

    @Override
    public void processClaim(double amount) {
        if (amount <= coverageAmount) {
            System.out.println("Liability claim approved.");
        } else {
            System.out.println("Liability claim denied.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("\n--- Liability Policy Report ---");
        System.out.println("Policy ID: " + policyId);
        System.out.println("Holder: " + policyHolder);
        System.out.println("Premium: $" + premiumAmount);
        System.out.println("Medical Checkup: " + (medicalCheckupPassed ? "Passed" : "Failed"));
    }

    @Override
    public void validatePolicy() {
        if (!medicalCheckupPassed)
            throw new IllegalArgumentException("Policyholder must pass medical checkup.");
    }
}

