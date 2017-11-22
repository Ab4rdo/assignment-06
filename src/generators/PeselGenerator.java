package generators;

import pesel.PeselValidator;

import java.util.Random;

public class PeselGenerator {

    private final int controlVars[] = PeselValidator.controlVars;

    private final PeselValidator validator;
    private final Random random;

    public PeselGenerator() {
        this.random = new Random();
        this.validator = new PeselValidator();

    }

    // method creates new random pesel number for given gender
    // PESEL : YYMMDDABCDK
    public String generatePesel(boolean isMale) {
        String date = this.generateDate();
        StringBuffer sb = new StringBuffer(date);
        int a, b, c, d;
        a = random.nextInt(10);
        b = random.nextInt(10);
        c = random.nextInt(10);
        d = random.nextInt(10);
        if(isMale && d%2!=0) { d--; } // check if it is male
        else if(!isMale && d%2==0) { d++; }
        sb.append(a);
        sb.append(b);
        sb.append(c);
        sb.append(d);

        int controlNumber = validator.calculateControlNumber(sb.toString());
        sb.append(controlNumber);

        return sb.toString();
    }

    private String generateDate() {
        int day, month, year, dayBound;
        month = random.nextInt(12)+1;
        year = random.nextInt(100);
        if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
            dayBound = 32;
        } else if(month==4 || month==6 || month==9 || month==11) {
            dayBound=31;
        } else {
            if(validator.isLeapYear(validator.getYear(year, month))) {
                dayBound=30;
            } else { dayBound=29; }

        }

        day = random.nextInt(dayBound);
        if(day == 0) { day++; }
        StringBuffer sb = new StringBuffer();
        if(year < 10) { sb.append("0"); }
        sb.append(year);
        if(month < 10) { sb.append("0"); }
        sb.append(month);
        if(day < 10) { sb.append("0"); }
        sb.append(day);

        return sb.toString();
    }





}
