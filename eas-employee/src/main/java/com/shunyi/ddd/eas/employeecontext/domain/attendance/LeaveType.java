package com.shunyi.ddd.eas.employeecontext.domain.attendance;

/**
 * @author zhang
 * @create 2021-01-21 13:13
 */
public enum LeaveType {
    Sick,Casual,Maternity,Bereavement,Marriage,Other;

    public AttendanceStatus toAttendanceStatus() {
        switch (this) {
            case Sick:return AttendanceStatus.SickLeave;
            case Casual:return AttendanceStatus.CasualLeave;
            case Maternity:return AttendanceStatus.MaternityLeave;
            case Bereavement:return AttendanceStatus.BereavementLeave;
            case Marriage:return AttendanceStatus.MarriageLeave;
            default:return AttendanceStatus.Leave;
        }
    }
}