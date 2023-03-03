package Student;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class ConnectDB {

	public Connection con;
	java.sql.Statement state;
	ResultSet rs;
	
	public static String name_m,password_m,sex_m,id_m;  //管理员静态变量
	public static String name_s,password_s,id_s,sex_s,address_s,department_s,class_s,birth_s,time_s,description_s,level_s,statement_s;   //学生静态变量

	public ConnectDB() {     //无参构造函数进行数据库连接的初始化
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/学生信息管理系统?useSSL=false&maas?useUnicode=true&characterEncoding=utf8";   //数据库驱动程序的连接
			con = DriverManager.getConnection(url, "root", "zlp0404");     //数据库的链接
			if (con != null) {
				System.out.println("链接成功");
			} else
				System.out.println("链接失败");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 学生登录信息验证
	public boolean studentLand(String id_s,String password_s){
		this.id_s = id_s;
		this.password_s = password_s;
		boolean flag = false;
		try{
			state = con.createStatement();
			rs = state.executeQuery("SELECT* FROM student");
			while(rs.next() && flag == false){
				String id = rs.getString("id_s").trim();  //
				String password = rs.getString("password_s").trim();
				//System.out.println(id+password);  测试与数据库中的表是否链接成功
				if(id.equals(id_s)){
					if(password != null && password_s.equals(password)){
						flag = true;
					}
				}
				
			}
		}catch (Exception b){
			b.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	//教师登陆验证
	public boolean teacherLand(String id_m,String password_m){
		this.id_m = id_m.trim();
		this.password_m = password_m.trim();
		boolean flag = false;
		try{
			state = con.createStatement();
			rs = state.executeQuery("SELECT* FROM manager");
			while(rs.next() && flag == false){
				String id = rs.getString("id_m").trim();  //去掉首尾空格，因为输入时用户名和密码长度不定
				String password = rs.getString("password_m").trim();
				System.out.println(id+password);  //测试与数据库中的表是否链接成功
				if(id.equals(id_m)){
					System.out.println("id正确");
					if(password != null && password_m.equals(password)){
						flag = true;
					}
				}
				
				
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	//教师注册
	public boolean teacherRegister(String name_m,String password_m,String id_m,String sex_m){
		this.name_m = name_m;
		this.password_m = password_m;
		this.id_m = id_m;
		this.sex_m = sex_m;
	//	System.out.println(id_m+password_m);
		boolean flag = false;
		try{
			state = con.createStatement();
			if(state.executeUpdate("INSERT INTO manager (name_m,id_m,sex_m,password_m)  "
					+ "VALUES ('" +name_m+"','"+id_m+"','"+ sex_m + "','"+ password_m + "');") == 1){
				flag = true;
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	//学生注册
	public boolean studentRegister(String id_s,String name_s,String password_s,String sex_s,String class_s,String department_s,String address_s,String birth_s){
		
		
		boolean flag = true;
		try{
			state = con.createStatement();
			if(state.executeUpdate("INSERT INTO student (id_s,name_s,password_s,sex_s,class_s,department_s,address_s,birth_s,statement_s)  "
					+ "VALUES ('" +id_s+"','"+name_s+"','"+ password_s + "','"+ sex_s + "','"+class_s+"','"+department_s+"','"+address_s+"','"+birth_s+"','"+"在校"+"');")<1)
			{
				flag = false;
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	
	public void Teacher_Query(DefaultTableModel table){
		try{
			state = con.createStatement();
			rs = state.executeQuery("SELECT* FROM student");
			
			while(rs.next()){
				String id_s = rs.getString("id_s");
				String name_s = rs.getString("name_s");
				String sex_s = rs.getString("sex_s");
				String class_s = rs.getString("class_s");
				String department_s = rs.getString("department_s");
				String address_s = rs.getString("address_s");
				String birth_s = rs.getString("birth_s");
				String statement_s = rs.getString("statement_s");
				
				table.addRow(new Object[]{id_s,name_s,sex_s,class_s,department_s,address_s,birth_s,statement_s});
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int student_Change(String sql){
		int  flag = 1;
		try{
			state = con.createStatement();
			if(state.executeUpdate(sql)<1){
				flag = 0;
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	
	public void reward_Query(DefaultTableModel table){
		try{
			state = con.createStatement();
			rs = state.executeQuery("SELECT student.id_s,name_s,class_s,department_s,description_s,level_s,time_s FROM reward ,student WHERE student.id_s=reward.id_s");
			while(rs.next()){
				String id_s = rs.getString("id_s");
				String name_s = rs.getString("name_s");
				String class_s = rs.getString("class_s");
				String department_s = rs.getString("department_s");
				String description_s = rs.getString("description_s");
				String level_s = rs.getString("level_s");
				String time_s = rs.getString("time_s");
				
				table.addRow(new Object[]{id_s,name_s,class_s,department_s,description_s,level_s,time_s});
			}
		}
			catch (Exception e){
				e.printStackTrace();
			}finally{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	public void punish_Query(DefaultTableModel table){
		try{
			state = con.createStatement();
			rs = state.executeQuery("SELECT student.id_s,name_s,class_s,department_s,description_s,level_s,time_s FROM punish,student WHERE student.id_s=punish.id_s");
			
			while(rs.next()){
				String id_s = rs.getString("id_s");
				String name_s = rs.getString("name_s");
				String class_s = rs.getString("class_s");
				String department_s = rs.getString("department_s");
				String description_s = rs.getString("description_s");
				String level_s = rs.getString("level_s");
				String time_s = rs.getString("time_s");
				
				table.addRow(new Object[]{id_s,name_s,class_s,department_s,description_s,level_s,time_s});
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean reward_Insert(String sql) {
		boolean flag = true;
		try{
			state = con.createStatement();
			if(state.executeUpdate(sql)<1){
				flag = false;
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag ;
	}
	
	public boolean punish_Insert(String sql){
		boolean flag = true ;
		try{
			state = con.createStatement();
			if(state.executeUpdate(sql)<1){
				flag = false;
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag ;
	}
	
	public int  delete_S(String id_s){
		int flag = 1;
		try{
			state = con.createStatement();
			if(state.executeUpdate("DELETE FROM student WHERE id_s = '"+id_s+ "'; ")<1){
				flag = 0;
			}
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	
	public boolean  student_Query_R(DefaultTableModel table, String id){
		boolean flag = false;
		try{
			state = con.createStatement();
			rs = state.executeQuery("SELECT student.id_s,name_s,department_s,description_s,level_s,time_s FROM reward,student WHERE student.id_s = reward.id_s AND student.id_s= '"+id+"';");
			
			while(rs.next()){
				String id_s = rs.getString("id_s");
				String name_s = rs.getString("name_s");
				String description_s = rs.getString("description_s");
				String department_s = rs.getString("department_s");
				String level_s = rs.getString("level_s");
				String time_s = rs.getString("time_s");
				
				table.addRow(new Object[]{id_s,name_s,department_s,description_s,level_s,time_s});
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public boolean student_Query_P(DefaultTableModel table, String id){
		boolean flag = false;
		try{
			state = con.createStatement();
			rs = state.executeQuery("SELECT student.id_s,name_s,department_s,description_s,level_s,time_s FROM punish,student WHERE student.id_s = punish.id_s AND student.id_s= '"+id+"';");
			
			while(rs.next()){
				String id_s = rs.getString("id_s");
				String name_s = rs.getString("name_s");
				String description_s = rs.getString("description_s");
				String department_s = rs.getString("department_s");
				String level_s = rs.getString("level_s");
				String time_s = rs.getString("time_s");
				table.addRow(new Object[]{id_s,name_s,department_s,description_s,level_s,time_s});
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public int change_M(String sql){
		int  flag = 1;
		try{
			state = con.createStatement();
			if(state.executeUpdate(sql)<1){
				flag = 0;
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public String[] student_Query(String[] str){
		//String[] str  = new String[8];
		try{
			state = con.createStatement();
			rs = state.executeQuery("SELECT* FROM student WHERE student.id_s= '"+Welcome.id_s+"';");
			while(rs.next()){
				str[0] = rs.getString("id_s");
				str[1] = rs.getString("name_s");
				str[2] = rs.getString("password_s");
				str[3] = rs.getString("sex_s");
				str[4] = rs.getString("department_s");
				str[5] = rs.getString("address_s");
				str[6] = rs.getString("birth_s");
				str[7] = rs.getString("class_s");
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return str;
	}
	
	public boolean Query_id(String id_s){
		boolean flag = false;
		try{
			state = con.createStatement();
			rs = state.executeQuery("SELECT* FROM student");
			while(rs.next() && flag == false){
				String id = rs.getString("id_s").trim();  //
				if(id.equals(id_s)){
						flag = true;
				}
				
			}
		}catch (Exception b){
			b.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public int count_R (){
		int count  = 0;
		try{
			state = con.createStatement();
			rs = state.executeQuery("SELECT COUNT(*) AS total FROM reward");
			if(rs.next()){
				count = rs.getInt("total");
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public int count_P(){
		int count  = 0;
		try{
			state = con.createStatement();
			rs = state.executeQuery("SELECT COUNT(*) AS total FROM punish");
			if(rs.next()){
				count = rs.getInt("total");
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	
	public void department_Query(DefaultTableModel table){
		try{
			state = con.createStatement();
			rs = state.executeQuery("SELECT* FROM department");
			
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				String dean = rs.getString("dean");
				String school = rs.getString("school");
				
				table.addRow(new Object[]{id,name,dean,school});
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void class_Query(DefaultTableModel table){
		try{
			state = con.createStatement();
			rs = state.executeQuery("SELECT* FROM class");
			
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				String moniter = rs.getString("moniter");
				String teacher = rs.getString("teacher");
				String department = rs.getString("department");
				
				table.addRow(new Object[]{id,name,moniter,teacher,department});
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean change(String str){
		boolean flag = true;
		try{
			state = con.createStatement();
			if(state.executeUpdate(str)<1){
				flag = false;
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
}