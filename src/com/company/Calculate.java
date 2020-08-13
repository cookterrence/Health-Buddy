package com.company;

import com.sun.jdi.connect.Connector;

import java.util.Scanner;

public class Calculate {
    private int fat = 3500;
    double caloriesPerDay;


    public void currentcal() {
        double BMR = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Input Current Weight: ");
        int currentWeight = scan.nextInt();

        System.out.print("Input Current height: ");
        int height = scan.nextInt();

        System.out.print("Input Current age: ");
        int age = scan.nextInt();

        System.out.println("Are you Male or Female? ");
        String gender = scan.next();

        if (gender.equals("male")) {
//            BMR = 10W + 6.25H - 5A + 5
            // Adult male: 66 + (6.3 x body weight in lbs.) +
            // (12.9 x height in inches) - (6.8 x age in years) = BMR
            BMR = 10 * currentWeight + 6.25 * height - 5 * age + 5;
            System.out.println("Your BMR is: " + BMR);

        } else if (gender.equals("female")) {
            //        BMR = 10W + 6.25H - 5A - 161
            BMR = 10 * currentWeight + 6.25 * height - 5 * age - 161;
            System.out.println("Your BMR is: " + BMR);
        }


        System.out.println("Now please enter how active you are to estimate your calories per day");
//      (little or no exercise) : Calorie-Calculation = BMR * 1.2
        System.out.println("If you are sedentatry (little or no exercise) enter 1 ");

//        If you are lightly active (light exercise/sports 1-3 days/week) : Calorie-Calculation = BMR * 1.375
        System.out.println("If you are lightly active (light exercise/sports 1-3 days/week) Enter 2 ");

//        If you are moderately active (moderate exercise/sports 3-5 days/week) : Calorie-Calculation = BMR * 1.55
        System.out.println("If you are moderately active (moderate exercise/sports 3-5 days/week) Enter 3 ");

//        If you are very active (hard exercise/sports 6-7 days a week) : Calorie-Calculation = BMR * 1.725
        System.out.println("If you are very active (hard exercise/sports 6-7 days a week) Enter 4");

//        If you are extra active (very hard exercise/sports & physical job or 2x training) : Calorie-Calculation = BMR * 1.9
        System.out.println("If you are extra active (very hard exercise/sports & physical job or 2x training) Enter 5");

        int active = scan.nextInt();

        if (active < 1 || active > 5) {
            throw new IllegalArgumentException("You have to choose Between 1 and 5");
        } else if (active == 1) {
            caloriesPerDay = BMR * 1.2;
            System.out.println("Estimated Calories Per Day: " + caloriesPerDay);

        } else if (active == 2) {
            caloriesPerDay = BMR * 1.375;
            System.out.println("Estimated Calories Per Day: " + caloriesPerDay);

        } else if (active == 3) {
            caloriesPerDay = BMR * 1.55;
            System.out.println("Estimated Calories Per Day: " + caloriesPerDay);

        } else if (active == 4) {
            caloriesPerDay = BMR * 1.725;
            System.out.println("Estimated Calories Per Day: " + caloriesPerDay);

        } else if (active == 5) {
            caloriesPerDay = BMR * 1.9;
            System.out.println("Estimated Calories Per Day: " + caloriesPerDay);

        }

        // }


        System.out.print("Would you like to plan out a weight loss program, Enter Yes or No? ");
        String str = scan.next();


        if (str.equals("no")) {
            System.out.println("Well Since You are at your target weight then try to maintain your recommended Calories Per Day! " + caloriesPerDay);

        } else {
            currentcal(caloriesPerDay);
        }
    }


    public void male(int currentWeight, int height, int age) {
//        BMR = 10W + 6.25H - 5A + 5
        // Adult male: 66 + (6.3 x body weight in lbs.) +
        // (12.9 x height in inches) - (6.8 x age in years) = BMR
        double BMR = 10 * currentWeight + 6.25 * height - 5 * age + 5;
        System.out.println("Your BMR is: " + BMR);
        currentcal(BMR);
    }


    public void female(int currentWeight, int height, int age) {
//        BMR = 10W + 6.25H - 5A - 161
        double BMR = 10 * currentWeight + 6.25 * height - 5 * age - 161;
        System.out.println("Your BMR is: " + BMR);
        currentcal(BMR);
    }


    public void currentcal(double caloriesPerDay) {
        int caloriesInFat = 3500;
        System.out.print("How many pounds would you like to lose? ");
        Scanner scan = new Scanner(System.in);
        int weightLoss = scan.nextInt();
        System.out.println("Doctors reccomend not losing more than 2 pounds a week, that would take you " + weightLoss / 2 + " weeks");
        System.out.println("If you wanted something less strenious like 1 pound a week it will take you " + weightLoss + " weeks");
        System.out.println("Wich one would you like to develop a plan for?  1 or 2?");
        int choice = scan.nextInt();

        if (choice == 1) {
            easyChoice(caloriesPerDay, weightLoss);
        } else {
            hardChoice(caloriesPerDay, weightLoss);
        }

    }


    public void easyChoice(double caloriesPerDay, int weightloss) {
        System.out.println("This choice will give you the amount of calories you need  to take in to lose  a pound a week");
        System.out.println("Since you want lose " + weightloss + "pounds you need to cut 500 calories a day to reach that goal in " + weightloss + " weeks");
        double newcaloriesPerDay = caloriesPerDay - 500;
        if (newcaloriesPerDay < 1200) {
            System.out.println("The suggested minimum amount of calories needed in a day is 1,200 ");
            System.out.println("Based off your information(BMR) the amount of calories that you would need is below that " + newcaloriesPerDay + " So we suggest that you lower your caloric intake to 1,200 calories a day.");
        } else {
            System.out.println("This is now your target calories per day: " + newcaloriesPerDay);
        }
    }


    public void hardChoice(double caloriesPerDay, int weightLoss) {
        System.out.println("This choice will give you the amount of calories you need to take in to lose 2 pounds a week");
        System.out.println("Based on health guidelines this is as maximum amount of pounds(2) we suggest  you try to lose a week");
        double newcaloriesPerDay = caloriesPerDay - 1000;
        if (newcaloriesPerDay < 1200) {
            System.out.println("The suggested minimum amount of calories needed in a day is 1,200 ");
            System.out.println("Based off your information(Calories per day) the amount of calories that you would need is below 1,200 " + newcaloriesPerDay + " So we suggest that you lower your caloric intake to 1,200 calories a day.");
        } else {
            System.out.println("This is now your target calories per day: " + newcaloriesPerDay);
        }
    }
}


