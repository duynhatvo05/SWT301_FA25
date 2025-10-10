package VoNhatDuy.example;

public class InsuranceClaim {

    private String claimId;
    private double amount;
    private String claimStatus;

    private static final double PAYOUT_RATE = 0.85;

    /**
     * Constructor to initialize the insurance claim.
     * @param id Claim ID
     * @param claimAmount Amount claimed
     * @throws IllegalArgumentException if id is null/empty or amount is zero/negative
     */
    public InsuranceClaim(String id, double claimAmount) {
        // >>> Bổ sung theo Bước 1 (null-check cho id)
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Claim ID cannot be null or empty");
        }

        if (claimAmount <= 0) {
            throw new IllegalArgumentException("Claim amount must be positive.");
        }
        this.claimId = id;
        this.amount = claimAmount;
        this.claimStatus = "Pending";
    }

    /**
     * Processes the claim by updating its status if currently pending.
     * @param statusUpdate New status to apply
     * @return true if update was applied, false otherwise
     */
    public boolean processClaim(String statusUpdate) {
        // >>> Để test Bước 2 pass: ném IAE khi truyền null
        if (statusUpdate == null) {
            throw new IllegalArgumentException("Status update cannot be null");
        }

        if ("Pending".equals(this.claimStatus)) {
            this.claimStatus = statusUpdate;
            return true;
        }
        return false;
    }

    public double calculatePayout() {
        if ("Approved".equals(this.claimStatus)) {
            return amount * PAYOUT_RATE;
        } else {
            return 0;
        }
    }

    public void updateClaimAmount(double newAmount) {
        if (newAmount <= 0) {
            throw new IllegalArgumentException("New amount must be positive.");
        }
        this.amount = newAmount;
    }

    public String getClaimId() { return claimId; }
    public double getAmount() { return amount; }
    public String getClaimStatus() { return claimStatus; }

    @Override
    public String toString() {
        return "InsuranceClaim{" +
                "claimId='" + claimId + '\'' +
                ", amount=" + amount +
                ", claimStatus='" + claimStatus + '\'' +
                '}';
    }
}
