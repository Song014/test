package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.kosa.dto.RegisterDto;
import kr.or.kosa.utils.ConnectionHelper;

/*
1. DB연결 POOL
2. insert 작업 
insert into mvcregister(id,pwd,email) values(?,?,?)

*/
public class RegisterDao {

    //writeOk ...
    //insert into mvcregister(id,pwd,email) values(?,?,?)
    public int writeOk(RegisterDto dto) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int resultrow = 0;
        try {
            conn = ConnectionHelper.getConnection();
            String sql = "insert into mvcregister(id,pwd,email) values(?,?,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, dto.getId());
            pstmt.setString(2, dto.getPwd());
            pstmt.setString(3, dto.getEmail());

            resultrow = pstmt.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }
        return resultrow;
    }

    public RegisterDto selectByIdPwd(int id, String pwd) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        RegisterDto dto = null;
        try {
            conn = ConnectionHelper.getConnection();
            String sql = "SELECT * FROM MVCREGISTER WHERE ID = ? AND PWD = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, pwd);


            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto = new RegisterDto();
                dto.setId(rs.getInt("id"));
                dto.setEmail(rs.getString("email"));
                dto.setPwd(rs.getString("pwd"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionHelper.close(rs);
            ConnectionHelper.close(pstmt);
            ConnectionHelper.close(conn);
        }

        return dto;
    }
}
