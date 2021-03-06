package com.shunyi.attendancecontext.domain;

import java.time.LocalDate;

/**
 * @author zhang
 * @create 2021-01-07 14:58
 */
public class Leave {
    private String employeeId;
    private LocalDate askLeaveDay;
    private LeaveType leaveType;

    private Leave(String employeeId, LocalDate askLeaveDay, LeaveType leaveType) {
        this.employeeId = employeeId;
        this.askLeaveDay = askLeaveDay;
        this.leaveType = leaveType;
    }

    public static Leave of(String employeeId, LocalDate askLeaveDay, LeaveType leaveType) {
        return new Leave(employeeId, askLeaveDay, leaveType);
    }

    public AttendanceStatus attendanceStatus() {
        return leaveType.toAttendanceStatus();
    }

    public boolean sameDay(LocalDate workDay) {
        return askLeaveDay.isEqual(workDay);
    }
}