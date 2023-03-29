package Planner;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    boolean appearsIn(LocalDate date) {

        return date.equals(getDateTime().toLocalDate()) ||
                date.getDayOfYear() == (getDateTime().toLocalDate().getDayOfYear());
    }

    @Override
    public String toString() {
        return super.toString() + "тип задачи: ежегодная";
    }
}
