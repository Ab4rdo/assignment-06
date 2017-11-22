package tests;

import org.junit.Assert;
import org.junit.Test;
import pesel.PeselValidator;

public class PeselValidatorTest {

    private final PeselValidator validator = new PeselValidator();
    private String pesel = "97010275216";
    private String notPesel = "00000000001";
    private String notPesel2 = "aaaaaaaaab1";


    @Test
    public void validateTest() {
        Assert.assertTrue(validator.validate(pesel));
        Assert.assertFalse(validator.validate(notPesel));
        Assert.assertFalse(validator.validate(notPesel2));
    }




}
