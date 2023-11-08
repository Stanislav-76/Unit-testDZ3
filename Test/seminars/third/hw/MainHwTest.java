package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.hw.MainHW;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainHwTest {

    MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @Test
    void correctCheckEventNumber() {
        assertThat(mainHW.evenOddNumber(8)).isTrue();
        assertThat(mainHW.evenOddNumber(11)).isFalse();
    }

    @Test
    void correctCheckIntervalNumber() {
        assertTrue(mainHW.numberInInterval(25));
        assertTrue(mainHW.numberInInterval(100));
        assertFalse(mainHW.numberInInterval(10));
    }
}
