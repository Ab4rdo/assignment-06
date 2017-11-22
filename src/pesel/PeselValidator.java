package pesel;


import java.time.LocalDate;

public class PeselValidator {

    public final static int controlVars[] = {1,3,7,9,1,3,7,9,1,3};

    public PeselValidator() {

    }


    public boolean validate(String pesel) {

        // checks if pesel has lenght 11 and contains only numbers
        if(pesel.length()!=11) { return false; }

        int[] peselArr = toIntArray(pesel);

        return  checkSum(peselArr) && chechMonth(peselArr) && checkDay(peselArr);
    }


    // more efficient ???
    private boolean checkDay(int peselArr[]) {
        int day = getDay(peselArr);
        int month = getMonth(peselArr[2]*10 + peselArr[3]);
        int year = getYear(peselArr[0]*10+peselArr[1],peselArr[2]*10+peselArr[3]);
        if(day < 0) { return false; }

        if(day < 32 && (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)) {
            return true;
        } else if (day < 31 &&(month==4 || month==6 || month==9 || month==11)) {
            return true;
        } else if(day < 29 && !isLeapYear(year) || day <30 && isLeapYear(year)) {
            return true;
        }

        return false;
    }

    private boolean chechMonth(int peselArr[]) {
        int month = getMonth(peselArr[2]*10 + peselArr[3]);
        return month>0 && month<13;
    }

    private boolean checkSum(int peselArr[]) {

        int controlSum=0;
        for(int i = 0; i < 10 ; i++) {
            controlSum += peselArr[i] * controlVars[i];
        }

        controlSum %= 10;
        controlSum = 10 - controlSum;
        controlSum %= 10;

        return controlSum==peselArr[10];
    }

    public boolean isLeapYear(int year) {
        return (year%400==0 || year%100!=0 && year%4==0);
    }

    public int getDay(int peselArr[]) {
        return peselArr[4]*10+peselArr[5];
    }

    // argument PESEL month
    public int getMonth(int month) {

        // 1800 - 1899
        if(month > 80 && month < 93){
            month -= 80;
        } else if(month > 20 && month < 33) {
            //2000 - 2099
            month -= 20;
        } else if(month > 40 && month < 53) {
            //2100 - 2199
            month -= 40;
        } else if(month > 60 && month < 73) {
            //2200 - 2299
            month -= 60;
        }

        return month;
    }

    // rgument PESEL year
    public int getYear(int year, int month) {

        if(month > 80 && month < 93) {
            year += 1800;
        } else if(month > 20 && month < 33) {
            year += 2000;
        } else if(month > 40 && month < 53) {
            year += 2100;
        } else if(month > 60 && month < 73) {
            year += 2200;
        } else {
            year += 1900;
        }

        return year;
    }

    private int[] toIntArray(String s) {
        int[] arr = new int[s.length()];
        for(int i = 0 ; i < arr.length ; i++) {
            arr[i] = Character.getNumericValue(s.charAt(i));
        }
        return arr;
    }

    public int calculateControlNumber(String numbers) {

        int[] arr = toIntArray(numbers);
        int controlSum=0;
        for(int i = 0; i < 10 ; i++) {
            controlSum += arr[i] * controlVars[i];
        }

        controlSum %= 10;
        controlSum = 10 - controlSum;
        controlSum %= 10;

        return controlSum;
    }

    public LocalDate getDateFromPesel(String pesel) {
        LocalDate date;
        int year, month, day;
            int arr[] = toIntArray(pesel);
            year = this.getYear(arr[0]*10 + arr[1] , arr[2]*10 + arr[3]);
            month = this.getMonth(arr[2]*10 + arr[3]);
            day = this.getDay(arr);
            return LocalDate.of(year, month, day);
    }
}
