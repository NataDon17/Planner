package Planner;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    boolean appearsIn(LocalDate date) {
        return date.equals(getDateTime().toLocalDate()) ||
                date.getDayOfMonth() == (getDateTime().toLocalDate().getDayOfMonth());
    }

    @Override
    public String toString() {
        return super.toString() + "тип задачи: ежемесячная";
    }
}
