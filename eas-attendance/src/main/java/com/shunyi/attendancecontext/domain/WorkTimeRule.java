package com.shunyi.attendancecontext.domain;

import java.time.LocalTime;

/**
 * @author zhang
 * @create 2021-01-07 14:58
 */
public class WorkTimeRule {
    private LocalTime startWork;
    private LocalTime endWork;
    private int allowableLateMinutes;
    private int allowableLeaveEarlyMinutes;

    public WorkTimeRule(LocalTime startWork, LocalTime endWork, int allowableLateMinutes, int allowableLeaveEarlyMinutes) {
        this.startWork = startWork;
        this.endWork = endWork;
        this.allowableLateMinutes = allowableLateMinutes;
        this.allowableLeaveEarlyMinutes = allowableLeaveEarlyMinutes;
    }

    public static WorkTimeRule of(LocalTime startWork, LocalTime endWork, int allowableLateMinutes, int allowableLeaveEarlyMinutes) {
        return new WorkTimeRule(startWork, endWork, allowableLateMinutes, allowableLeaveEarlyMinutes);
    }

    public boolean isLate(LocalTime punchedTime) {
        return punchedTime.isAfter(startWork.plusMinutes(allowableLateMinutes));
    }

    public boolean isLeaveEarly(LocalTime punchedTime) {
        return punchedTime.isBefore(endWork.minusMinutes(allowableLeaveEarlyMinutes));
    }


}