import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DiscountCodeReader {

    public static List<DiscountCode> readDiscountCodes() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Unterstützung für Instant-Werte wie 2026-01-15T09:00:00Z
        objectMapper.registerModule(new JavaTimeModule());

        // Pfad relativ zum Projektordner
        Path filePath = Path.of("data", "rabattcodes.json");

        if (!Files.exists(filePath)) {
            throw new IOException(
                    "Die Datei wurde nicht gefunden: "
                            + filePath.toAbsolutePath()
            );
        }

        return objectMapper.readValue(
                filePath.toFile(),
                new TypeReference<List<DiscountCode>>() {
                }
        );
    }
}