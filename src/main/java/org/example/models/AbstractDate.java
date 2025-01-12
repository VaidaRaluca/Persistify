package org.example.models;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

public abstract class AbstractDate {
    private int year;
    private int month;
    private int day;

    public AbstractDate(int year, int month, int day) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day must be between 1 and 31");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public AbstractDate() {}

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public static AbstractDate parse(String dateString) {
        String[] parts = dateString.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return new Date(year, month, day); // Use a concrete implementation here
    }

    public boolean after(AbstractDate otherDate) {
        if (otherDate.year < this.year) return true;
        else if (otherDate.year > this.year) return false;
        if (otherDate.month < this.month) return true;
        else if (otherDate.month > this.month) return false;
        return otherDate.day < this.day;
    }

    public Instant toInstant() {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
    }

    @Override
    public String toString() {
        return "AbstractDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
