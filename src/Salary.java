import java.util.Scanner;
public class Salary {
    public static int calculateSalary(int[] hoursWorkedPerDay, int totalHoursInWeek){

        int salary = 0;
        int extraHoursEarning = 0;
        int bonus = 0;

        if(totalHoursInWeek>40){
            extraHoursEarning = (totalHoursInWeek - 40) * 25;
        }

        for (int day=0; day<7; day++){
            int perHourWage = 100;
            if(hoursWorkedPerDay[day]<=8){
                salary += hoursWorkedPerDay[day]*perHourWage;
            } else {
                int extraHour = hoursWorkedPerDay[day]-8;
                salary += 800;
                salary += extraHour * 115;
            }

            if(day == 0){
                bonus = 50 * hoursWorkedPerDay[day];
            }else if(day == 6){
                bonus = 25 * hoursWorkedPerDay[day];
            }

            salary += bonus;
        }

        salary += extraHoursEarning;
        return salary ;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] hoursWorkedInWeekPerDay = new int[7];
        int totalHoursWorkedInWeek = 0;
        int salary;

        for(int day=0; day<7; day++){
            System.out.println("Hours worked on day " + (day+1) + " : ");
            hoursWorkedInWeekPerDay[day] = input.nextInt();
            totalHoursWorkedInWeek += hoursWorkedInWeekPerDay[day];
        }

        totalHoursWorkedInWeek -= hoursWorkedInWeekPerDay[0]+hoursWorkedInWeekPerDay[6];

        salary = calculateSalary(hoursWorkedInWeekPerDay, totalHoursWorkedInWeek);

        System.out.println(salary);
    }
}