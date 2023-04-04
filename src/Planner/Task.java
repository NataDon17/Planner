package Planner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    public static int idGenerator = 1;
    private String title;
    private final Type type;
    private final int id;
    private final LocalDateTime dateTime;
    private String description;

    public Task(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        setTitle(title);
        this.type = type;
        this.dateTime = dateTime;
        setDescription(description);
        id = idGenerator++;
    }

    abstract boolean appearsIn(LocalDate date);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }

    public String getTitle() {
        return title;
    }


    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) throws IncorrectArgumentException {
        if (title == null || title.isEmpty() || title.isBlank()) {
            throw new IncorrectArgumentException("<Заголовок>");
        } else {
            this.title = title;
        }
    }

    public void setDescription(String description) throws IncorrectArgumentException {
        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new IncorrectArgumentException("<Описание>");
        } else {
            this.description = description;
        }
    }

    @Override
    public String toString() {
        return "Задача номер " + id +
                "\nЗаголовок: " + title +
                ", тип задачи: " + type +
                ", дата выполнения " + dateTime +
                ", описание: " + description + '\n'
                ;
    }
}
