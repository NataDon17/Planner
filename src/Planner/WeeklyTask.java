package Planner;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    boolean appearsIn(LocalDate date) {
        return date.equals(getDateTime().toLocalDate()) ||
                date.getDayOfWeek().equals(getDateTime().toLocalDate().getDayOfWeek());
    }

    @Override
    public String toString() {
        return super.toString() + "тип задачи: еженедельная";
    }
}
