package com.mokon.spring.boot.backend.domain;

import org.hibernate.validator.constraints.NotEmpty;

import java.time.LocalDate;

/**
 * Created by mokon on 20.02.2017.
 */
public class AddNoteForm {

    @NotEmpty
    private String note = "";

    @NotEmpty
    private LocalDate date;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
