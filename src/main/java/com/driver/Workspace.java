package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Workspace extends Gmail {


    private ArrayList<Meeting> calendar; // Stores all the meetings
     private final int defaultInboxCapacity = Integer.MAX_VALUE;
    //super(emailId, password);





    public Workspace(String emailId) {
        super(emailId);
        this.inboxCapacity = DEFAULT_CAPACITY;
        this.calendar = new ArrayList<>();
    }



    public Workspace(String emailId, String password) {
        super(emailId, password);
        this.inboxCapacity = DEFAULT_CAPACITY;
        this.calendar = new ArrayList<>();
    }

    public Workspace(String emailId, String password, int inboxCapacity) {
        super(emailId, password, inboxCapacity);
        this.calendar = new ArrayList<>();
    }




    public void addMeeting(Meeting meeting) {

        for (Meeting m : calendar) {
            if (m.getStartTime().isBefore(meeting.getEndTime()) && meeting.getStartTime().isBefore(m.getEndTime())) {
                throw new IllegalStateException("Meeting schedule conflict");
            }
        }
        calendar.add(meeting);
    }



    public int findMaxMeetings() {

        int maxMeetings = 0;
        for (LocalTime t = LocalTime.of(0, 0); t.isBefore(LocalTime.of(23, 59)); t = t.plusMinutes(1)) {
            int count = 0;
            for (Meeting m : calendar) {
                if (t.isAfter(m.getStartTime()) && t.isBefore(m.getEndTime())) {
                    count++;
                }
            }
            if (count > maxMeetings) {
                maxMeetings = count;
            }
        }
        return maxMeetings;


    }









}











/*
    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId);
        this.setInboxCapacity(defaultInboxCapacity);
        this.calendar = new ArrayList<>();


    }








    public void addMeeting(Meeting meeting){
        //add the meeting to calendar

        this.calendar.add(meeting);

    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        int maxMeetings = 0;
        int currentMeetings = 0;
        List<Meeting> sortedCalendar = new ArrayList<>(this.calendar);
        sortedCalendar.sort((m1, m2) -> m1.getStartTime().compareTo(m2.getStartTime()));
        for (Meeting meeting : sortedCalendar) {
            if (meeting.getStartTime().isAfter(LocalTime.now())) {
                currentMeetings++;
                maxMeetings = Math.max(maxMeetings, currentMeetings);
            }
            if (meeting.getEndTime().isBefore(LocalTime.now())) {
                currentMeetings--;
            }
        }
        return maxMeetings;




    }

*/