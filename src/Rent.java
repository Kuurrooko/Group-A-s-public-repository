import java.math.BigDecimal;
import java.util.Objects;

public class Rent {

    private final String id;
    private final String itemName;
    private final BigDecimal price;
    private boolean returned;

    public Rent(String id, String itemName, BigDecimal price) {
        this.id = requireText(id, "id");
        this.itemName = requireText(itemName, "itemName");
        if (price == null || price.signum() < 0) {
            throw new IllegalArgumentException("price must not be negative");
        }
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isReturned() {
        return returned;
    }

    public void markAsReturned() {
        returned = true;
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Rent)) {
            return false;
        }
        Rent rent = (Rent) other;
        return id.equals(rent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
