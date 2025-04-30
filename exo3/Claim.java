package exo3;

import java.time.LocalDate;

public class Claim {
    private String claimId;
    private double claimAmount;
    private LocalDate claimDate;
    private String claimStatus;

    public Claim(String claimId, double claimAmount, LocalDate claimDate) {
        this.claimId = claimId;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.claimStatus = "Pending";
    }

    public double getClaimAmount() { return claimAmount; }
    public void approve() { this.claimStatus = "Approved"; }
    public void reject() { this.claimStatus = "Rejected"; }

    public String toString() {
        return "Claim ID: " + claimId + ", Amount: $" + claimAmount + ", Date: " + claimDate + ", Status: " + claimStatus;
    }
}

