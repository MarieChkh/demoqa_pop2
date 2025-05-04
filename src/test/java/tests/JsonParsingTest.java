package tests;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import Model.ClientData;
import Model.AtributesList;

public class JsonParsingTest {
    @Test
    void jsonFileParsingTest() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("client.json")) {
            assertNotNull(is, "Файл client.json не найден! ");

            ObjectMapper objectMapper = new ObjectMapper();
            ClientData cd = objectMapper.readValue(is, ClientData.class);

            assertEquals(12345, cd.getId());
            assertEquals("client", cd.getTitle());
            assertEquals("VIP", cd.getCategories());

            AtributesList atribute = cd.getAtribute();
            assertEquals("Nicola Tesla", atribute.getName());
            assertEquals("Level", atribute.getRating());
            assertEquals("mnogaya leta", atribute.getAge());
        }

    }
}
