package com.web.evm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_ID")
    private int eventId;

    @Column(name = "email_address", nullable = false, length = 50)
    private String emailAddress;

    @Column(name = "username", length = 30)
    private String username;

    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;

    @Column(name = "location", nullable = false, length = 30)
    private String location;

    @Column(name = "description", length = 170)
    private String description;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "time", length = 12)
    private String time;

    @Column(name = "date", length = 16)
    private String date;

    @Column(name = "date_time", nullable = false, length = 30)
    private String dateTime;

    @Column(name = "sponsor", nullable = false, length = 30)
    private String sponsor;

    @Column(name = "application_status", length = 10)
    private String applicationStatus = "pending";

    @Column(name = "application_permission")
    private Boolean applicationPermission;

    @Column(name = "personal_contact_num")
    private int personalContactNum;

    @Column(name = "work_contact_num")
    private int workContactNum;

    @Column(name = "budget", nullable = false)
    private int budget;

    // Constructors

    public Event() {
    }

    public Event(String emailAddress, String username, String firstName, String lastName,
                 String location, String description, String title, String time, String date, String dateTime,
                 String sponsor, String applicationStatus, Boolean applicationPermission, int personalContactNum,
                 int workContactNum, int budget) {
        this.emailAddress = emailAddress;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.description = description;
        this.title = title;
        this.time = time;
        this.date = date;
        this.dateTime = dateTime;
        this.sponsor = sponsor;
        this.applicationStatus = applicationStatus;
        this.applicationPermission = applicationPermission;
        this.personalContactNum = personalContactNum;
        this.workContactNum = workContactNum;
        this.budget = budget;
    }

    // Getters and setters

    // Getters and setters omitted for brevity, but they should be generated for all fields

    // toString(), equals(), and hashCode() methods

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", emailAddress='" + emailAddress + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", sponsor='" + sponsor + '\'' +
                ", applicationStatus='" + applicationStatus + '\'' +
                ", applicationPermission=" + applicationPermission +
                ", personalContactNum=" + personalContactNum +
                ", workContactNum=" + workContactNum +
                ", budget=" + budget +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        return eventId == event.eventId;
    }

    @Override
    public int hashCode() {
        return eventId;
    }
}
