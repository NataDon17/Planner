package Planner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;


public class MainTask {

    public static void main(String[] args) throws IncorrectArgumentException {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        TaskService taskService = new TaskService();

        System.out.println("Привет! Твой ежедневник готов к работе! С чего начнем? Выбери из списка:");
        while (true) {

            System.out.println("Что ты хочешь сделать?" +
                    "\n1 — вывести список задач на дату" +
                    "\n2 — добавить новую задачу" +
                    "\n3 — удалить выбранную задачу" +
                    "\n0 — выход");
            if (scan.hasNextInt()) {
                int choice = scan.nextInt();
                if (choice == 1) {
                    System.out.println("Введи интересующую дату в формате гггг-мм-дд:");
                    String date = scan.next();
                    LocalDate dateFormat = LocalDate.parse(date);
                    if (taskService.getAllByDate(dateFormat).isEmpty()) {
                        System.out.println("Задач на выбранную дату не найдено, Добби свободен!");
                    } else {
                        System.out.println(taskService.getAllByDate(dateFormat));
                    }

                } else if (choice == 2) {
                    System.out.println("Введи заголовок задачи:");
                    String title = scan.next();
                    System.out.println("Введи описание задачи: ");
                    String description = scan.next();
                    System.out.println("Выбери тип задачи:\n 1-рабочая   2-личная");
                    int j = scan.nextInt();
                    Type type = (j == 1 ? Type.valueOf("WORK") : Type.valueOf("PERSONAL"));
                    System.out.println("Введи дату и время для выполнения задачи в формате гггг-мм-ддTчч:мм:сс:");
                    String date1 = scan.next();
                    LocalDateTime datePerform = LocalDateTime.parse(date1);
                    System.out.println("Выбери повторяемость для задачи:\n" +
                            "1-однокраная    2-ежедневная    3-еженедельная    4-ежемесячная    5-ежегодная");
                    int replay = scan.nextInt();
                    if (replay == 1) {
                        Task taskOneTime = new OneTimeTask(title, type, datePerform, description);
                        taskService.addTaskToMap(taskOneTime);
                    } else if (replay == 2) {
                        Task taskDaily = new DailyTask(title, type, datePerform, description);
                        taskService.addTaskToMap(taskDaily);
                    } else if (replay == 3) {
                        Task taskWeekly = new WeeklyTask(title, type, datePerform, description);
                        taskService.addTaskToMap(taskWeekly);
                    } else if (replay == 4) {
                        Task taskMonthly = new MonthlyTask(title, type, datePerform, description);
                        taskService.addTaskToMap(taskMonthly);
                    } else if (replay == 5) {
                        Task taskYearly = new YearlyTask(title, type, datePerform, description);
                        taskService.addTaskToMap(taskYearly);
                    } else {
                        System.out.println("Неверная команда");
                    }

                } else if (choice == 3) {
                    try {
                        System.out.println("Введи номер задачи, которую хочешь удалить:");
                        int i = scan.nextInt();
                        taskService.removeTasks(i);
                    } catch (TaskNotFoundException e) {
                        System.out.println("Задача c заданным номером не найдена.");
                    }
                } else if (choice == 0) {
                    System.out.println("Работа с ежедневником завершена.");
                    break;
                } else {
                    System.out.println("Извини, такой команды пока нет.");
                }
            } else {
                System.out.println("Извини, но ты ввел неверную команду. Перезапусти программу и попробуй снова!");
                break;
            }
        }
    }
}







