package com.shunyi.attendancecontext.domain;

/**
 * @author zhang
 * @create 2021-01-07 14:58
 */
public enum LeaveType {
    Sick,Casual,Maternity,Bereavement,Marriage,Other;

    public AttendanceStatus toAttendanceStatus() {
        switch (this) {
            case Sick:return AttendanceStatus.SickLeave;
            case Casual:return AttendanceStatus.CasualLeave;
            case Marriage:return AttendanceStatus.MarriageLeave;
            case Bereavement:return AttendanceStatus.BereavementLeave;
            case Maternity:return AttendanceStatus.MaternityLeave;
            default:return AttendanceStatus.Leave;
        }
    }
}