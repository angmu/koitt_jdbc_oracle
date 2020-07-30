package jsp_0420_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemDao {
	private MemDao() {}
	//싱글톤
	static MemDao instance=new MemDao();
	
	//유일한 생성객체 :D
	public MemDao getInstance() {
		return instance;
	};
	
	//공통
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql;
	DataSource ds=null;
	
	
	//id, pw check;
	
}
