package webLesson01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NoteDAO {

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	static final String URL = "jdbc:mysql://localhost/dictionaly";
	static final String USER = "root";
	static final String PW = "";

	 //insert
	public int registNote(List<Note> lists){

		int result = 0;

		try {
			 //ドライバーのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dictionaly?useUnicode=true&characterEncoding=utf8", "root", "");

			 //DB接続
			if( con != null ){
				System.out.println("DB接続完了　\r\n---");
			}

			else{
					System.out.println("DB接続失敗\r\n---");
					return result;
			}

			for(int i = 0 ; i < lists.size()  ; i++){
				String SQL = "INSERT INTO java(id, title, naiyou, answer, site) VALUES(NULL, ?, ?, ?, ?)";
				Note nt = lists.get(i);
				st = con.prepareStatement(SQL);
				st.setString(2, nt.getTitle());
				st.setString(3, nt.getNaiyou());
				st.setString(4, nt.getAnswer());
				st.setString(5, nt.getSite());
				result = result + st.executeUpdate();
			}

		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if ( st != null) {

				try {
					st.close();
				}

				catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if ( con != null) {

				try {
					con.close();
				}

				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;	// 結果を返す
	}


	 //select 件数だけ
	public int notes(List<Note> notes){

		int res = 0;

		try {
			 //ドライバーのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dictionaly", "root", "");

			 //DB接続
			if( con != null ){
				System.out.println("登録済み");
			}

			else{
					System.out.println("DB接続失敗\r\n---");
					return res;
			}

			 // 単語の読み出し
			String SQL = "SELECT * FROM java";
			st = con.prepareStatement(SQL);
			rs = st.executeQuery();

			while(rs.next()){
				Note nt = new Note(rs.getString("title"), rs.getString("naiyou"), rs.getString("answer"), rs.getString("site"));
				notes.add( nt );
			}

				System.out.println(res + "件");
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if ( st != null) {

				try {
					st.close();
				}

				catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if ( con != null) {

				try {
					con.close();
				}

				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return res;	// 結果を返す

	}

}
