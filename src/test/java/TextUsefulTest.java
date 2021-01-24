import org.junit.jupiter.api.Test;
import util.TextUseful;

import static org.junit.jupiter.api.Assertions.*;

public class TextUsefulTest {

    @Test
    public void validateTextSizeTest(){
        String text = "menorde20";
        int max = 20;
        assertTrue(TextUseful.validateTextSize(text, max));
    }

    @Test
    public void validateTextSizeIncorrectTest(){
        String text = "MAIORDE20CARACTERESSSSSSSSS";
        int max = 20;
        assertFalse(TextUseful.validateTextSize(text, max));
    }
}
