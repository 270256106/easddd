package com.shunyi.trainingcontext.acl.adapters.repositories.typehandlers;

import com.shunyi.trainingcontext.domain.course.CourseId;
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
 * @create 2021-01-12 16:05
 */
@MappedTypes(CourseId.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class CourseIdTypHandler extends BaseTypeHandler<CourseId> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, CourseId courseId, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,courseId.value());
    }

    @Override
    public CourseId getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return CourseId.from(resultSet.getString(s));
    }

    @Override
    public CourseId getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return CourseId.from(resultSet.getString(i));
    }

    @Override
    public CourseId getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return CourseId.from(callableStatement.getString(i));
    }
}