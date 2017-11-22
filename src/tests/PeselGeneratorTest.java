package tests;

import generators.PeselGenerator;
import org.junit.Assert;
import org.junit.Test;
import pesel.PeselValidator;

public class PeselGeneratorTest {


    private PeselValidator validator = new PeselValidator();
    private PeselGenerator generator = new PeselGenerator();

    @Test
    public void generatePeselTest() {
        int i = 0;
        while (i < 1000) {
            String pesel = generator.generatePesel(true);
            Assert.assertTrue(validator.validate(pesel));
            i++;
        }
    }

}
