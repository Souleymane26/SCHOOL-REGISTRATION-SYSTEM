package university.model;

import java.time.LocalTime;
import java.util.Objects;

/**
 * Represents a specific meeting period for a section, defined by a day,
 * start time, end time, and room.
 * This class is crucial for performing schedule conflict checks.
 * It is marked as final and immutable (all fields are final).
 */
public final class TimeSlot implements Comparable<TimeSlot> {

    // The day of the week the class meets (e.g: MONDAY).
    private final DayOfWeek day;

    // The time the class session begins.
    private final LocalTime start;

    // The time the class session ends.
    private final LocalTime end;

    // The physical location/room number where the class is held.
    private final String room;

    /**
     * Constructor for a TimeSlot.
     * Enforces the business rule that the start time must precede the end time.
     * * @param day The DayOfWeek constant.
     * @param start The start time of the meeting.
     * @param end The end time of the meeting.
     * @param room The location of the meeting.
     * @throws IllegalArgumentException if start is on or after end time.
     */
    public TimeSlot(DayOfWeek day, LocalTime start, LocalTime end, String room) {
        if (start.isAfter(end) || start.equals(end)) {
            throw new IllegalArgumentException("start time must be strictly before end time");
        }
        // Ensure inputs are non-null
        this.day = Objects.requireNonNull(day);
        this.start = Objects.requireNonNull(start);
        this.end = Objects.requireNonNull(end);
        this.room = room; // Room can be null if not assigned
    }

    // --- Getter Methods ---

    public DayOfWeek getDay() { return day; }
    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }
    public String getRoom() { return room; }

    /**
     * Checks if this TimeSlot overlaps with another TimeSlot.
     * This is the core logic for the schedule conflict validator in RegistrationService.
     * Two time slots overlap if and only if they are on the same day, AND
     * (Start A is before End B) AND (Start B is before End A).
     * * @param other The other TimeSlot to check against.
     * @return true if the two time slots conflict, false otherwise.
     */
    public boolean overlapsWith(TimeSlot other) {
        // Must be on the same day to conflict
        if (other == null || this.day != other.day) return false;

        // Overlap logic: (Start A < End B) AND (Start B < End A)
        return this.start.isBefore(other.end) && other.start.isBefore(this.end);
    }

    /**
     * Defines the natural ordering for TimeSlot objects, used primarily for sorting schedules.
     * Time slots are sorted first by day, and then by start time.
     */
    @Override
    public int compareTo(TimeSlot o) {
        // 1. Compare by day
        int cmp = day.compareTo(o.day);
        if (cmp != 0) return cmp;

        // 2. If days are the same, compare by start time
        return this.start.compareTo(o.start);
    }

    /**
     * Returns a string representation of the time slot for display purposes.
     * Example: "MONDAY 10:00-12:00 (A1-76)"
     */
    @Override
    public String toString() {
        return day + " " + start + "-" + end + (room != null ? " (" + room + ")" : "");
    }
}
