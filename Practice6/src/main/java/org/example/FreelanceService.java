package org.example;

public class FreelanceService {

    public int calculateRestMonths(int income, int expenses, int threshold) {
        int money = 0;
        int restMonths = 0;

        for (int month = 1; month <= 12; month++) {
            if (money >= threshold) {
                // Отдых
                money -= expenses;
                money /= 3;
                restMonths++;
            } else {
                // Работа
                money += income;
                money -= expenses;
            }
        }

        return restMonths;
    }
}