package com.template.jdbc;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * author:曲终、人散
 * Date:2019/4/11 22:34
 */
public class MemberDao extends JdbcTemplate {

    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<?> selectAll(){
        String sql = "select * from t_member";
        return super.executeQuery(sql, new RowMapper<Member>(){
            public Member mapRow(ResultSet rs, int row) throws Exception {
                Member member = new Member();
                member.setUsername(rs.getString("username"));
                member.setAge(rs.getInt("age"));
                return member;
            }
        },null);

    }
}
