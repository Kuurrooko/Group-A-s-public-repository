import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public class DiscountCode {

    @JsonProperty("discount_code_id")
    private String discountCodeId;

    private String code;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("discount_type")
    private String discountType;

    @JsonProperty("discount_value")
    private double discountValue;

    @JsonProperty("issued_after_booking_count")
    private int issuedAfterBookingCount;

    @JsonProperty("valid_from")
    private Instant validFrom;

    @JsonProperty("valid_until")
    private Instant validUntil;

    private String status;

    @JsonProperty("created_at")
    private Instant createdAt;

    @JsonProperty("used_at")
    private Instant usedAt;

    @JsonProperty("used_for_booking_id")
    private String usedForBookingId;

    public DiscountCode() {
    }

    public String getDiscountCodeId() {
        return discountCodeId;
    }

    public String getCode() {
        return code;
    }

    public String getUserId() {
        return userId;
    }

    public String getDiscountType() {
        return discountType;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public int getIssuedAfterBookingCount() {
        return issuedAfterBookingCount;
    }

    public Instant getValidFrom() {
        return validFrom;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public String getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUsedAt() {
        return usedAt;
    }

    public String getUsedForBookingId() {
        return usedForBookingId;
    }

    @Override
    public String toString() {
        return "DiscountCode{" +
                "discountCodeId='" + discountCodeId + '\'' +
                ", code='" + code + '\'' +
                ", userId='" + userId + '\'' +
                ", discountType='" + discountType + '\'' +
                ", discountValue=" + discountValue +
                ", status='" + status + '\'' +
                '}';
    }
}