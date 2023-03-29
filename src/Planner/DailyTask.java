package Planner;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {
    public DailyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    boolean appearsIn(LocalDate date) {
        return date.equals(getDateTime().toLocalDate()) ||
                date.isAfter(getDateTime().toLocalDate());
    }

    @Override
    public String toString() {
        return super.toString() + "тип задачи: ежедневная";
    }
}
