
import static org.junit.Assert.*;
import org.junit.Test;  // Must be JUnit 4 (org.junit)

public class HolidayBonusGFATest {
    private double[][] dataSet1 = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };

    @Test  // This must be from org.junit (not org.junit.jupiter.api)
    public void testCalculateHolidayBonusA() {
        double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
        assertEquals(3000.0, result[0], .001);
    }
}
