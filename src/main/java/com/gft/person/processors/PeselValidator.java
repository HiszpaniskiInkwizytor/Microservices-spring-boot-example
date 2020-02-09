package com.gft.person.processors;

import java.util.ArrayList;
import java.util.List;

public class PeselValidator {

    public PeselValidator() {
    }

    public boolean isValid(String PESEL) {
        if (PESEL == null)
            return false;
        if (PESEL.length() != 11)
            return false;
        return true;
    }

    /*
            private int getBirthYear(String PESEL) {
                int year;
                int month;
                year = 10 * PESEL.charAt(0);
                year += PESEL.charAt(1);
                month = 10 * PESEL.charAt(2);
                month += PESEL.charAt(3);
                if (month > 80 && month < 93) {
                   return year += 1800;
                }
                if (month > 0 && month < 13) {
                    return year += 1900;
                }
                if (month > 20 && month < 33) {
                    return year += 2000;
                }
                if (month > 40 && month < 53) {
                    return year += 2100;
                }
                if (month > 60 && month < 73) {
                    return year += 2200;
                }
                return 0;
            }

            private int getBirthMonth(String PESEL) {
                int month;
                month = 10 * PESEL.charAt(2);
                month += PESEL.charAt(3);
                if (month > 80 && month < 93) {
                    return month -= 80;
                }
                if (month > 20 && month < 33) {
                    return month -= 20;
                }
                if (month > 40 && month < 53) {
                    return month -= 40;
                }
                if (month > 60 && month < 73) {
                    return month -= 60;
                }
                return 0;
            }


            private int getBirthDay(String PESEL) {
                int day;
                day = 10 * PESEL.charAt(4);
                day += PESEL.charAt(5);
                return day;
            }
    */

    public boolean checkSum(String PESEL) {
        List<Integer> PESELMap = new ArrayList<>();
        PESELMap.add(PESEL.charAt(0) -'0');
        PESELMap.add((PESEL.charAt(1) -'0')* 3);
        PESELMap.add((PESEL.charAt(2) -'0')* 7);
        PESELMap.add((PESEL.charAt(3) -'0')* 9);
        PESELMap.add((PESEL.charAt(4) - '0'));
        PESELMap.add((PESEL.charAt(5) -'0')* 3);
        PESELMap.add((PESEL.charAt(6) -'0')* 7);
        PESELMap.add((PESEL.charAt(7) -'0')* 9);
        PESELMap.add((PESEL.charAt(8) - '0'));
        PESELMap.add((PESEL.charAt(9) -'0')* 3);
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = sum + PESELMap.get(i);
        }
        int lastNumber = sum % 10;
        int controlNumber = 10 - lastNumber;

        return controlNumber == Character.getNumericValue(PESEL.charAt(10));
    }

        /*

        private boolean checkMonth() {
            int month = getBirthMonth();
            int day = getBirthDay();
            if (month > 0 && month < 13) {
                return true;
            }
            else {
                return false;
            }
        }

        private boolean checkDay() {
            int year = getBirthYear();
            int month = getBirthMonth();
            int day = getBirthDay();
            if ((day >0 && day < 32) &&
                    (month == 1 || month == 3 || month == 5 ||
                            month == 7 || month == 8 || month == 10 ||
                            month == 12)) {
                return true;
            }
            else if ((day >0 && day < 31) &&
                    (month == 4 || month == 6 || month == 9 ||
                            month == 11)) {
                return true;
            }
            else if ((day >0 && day < 30 && leapYear(year)) ||
                    (day >0 && day < 29 && !leapYear(year))) {
                return true;
            }
            else {
                return false;
            }
        }

        private boolean leapYear(int year) {
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
                return true;
            else
                return false;
        }

 */
}




