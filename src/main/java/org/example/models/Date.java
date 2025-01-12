package org.example.models;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

public class Date extends AbstractDate{

    public Date(int year, int month, int day) {
        super(year,month,day);
    }

    public Date() {
        super();
    }

}
