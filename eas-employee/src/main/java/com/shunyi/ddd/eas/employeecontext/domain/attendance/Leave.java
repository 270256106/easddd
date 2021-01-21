package com.shunyi.ddd.eas.employeecontext.domain.attendance;

import java.time.LocalDate;

/**
 * @author zhang
 * @create 2021-01-21 13:13
 */
public class Leave {
    private String employeeId;
    private LocalDate askLeaveDay;
    private LeaveType leaveType;

    public Leave(String employeeId, LocalDate askLeaveDay, LeaveType leaveType) {
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