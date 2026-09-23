import java.util.Objects;

public class Court {

    private final String id;
    private final String name;
    private final String surface;
    private final boolean indoor;
    private boolean active;

    public Court(String id, String name, String surface, boolean indoor, boolean active) {
        this.id = requireText(id, "id");
        this.name = requireText(name, "name");
        this.surface = requireText(surface, "surface");
        this.indoor = indoor;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurface() {
        return surface;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }
        return value;
    }

    @Override
    public String toString() {
        return name + " (" + surface + ", " + (indoor ? "indoor" : "outdoor") + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Court)) {
            return false;
        }
        Court court = (Court) other;
        return id.equals(court.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
