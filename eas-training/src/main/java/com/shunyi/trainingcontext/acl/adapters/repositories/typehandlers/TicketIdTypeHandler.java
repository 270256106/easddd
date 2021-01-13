package com.shunyi.trainingcontext.acl.adapters.repositories.typehandlers;

import com.shunyi.trainingcontext.domain.course.CourseId;
import com.shunyi.trainingcontext.domain.ticket.Ticket;
import com.shunyi.trainingcontext.domain.ticket.TicketId;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhang
 * @create 2021-01-12 16:06
 */
@MappedTypes(TicketId.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class TicketIdTypeHandler extends BaseTypeHandler<TicketId> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, TicketId ticketId, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,ticketId.value());
    }

    @Override
    public TicketId getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return TicketId.from(resultSet.getString(s));
    }

    @Override
    public TicketId getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return TicketId.from(resultSet.getString(i));
    }

    @Override
    public TicketId getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return TicketId.from(callableStatement.getString(i));
    }
}