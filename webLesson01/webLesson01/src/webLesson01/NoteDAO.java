package webLesson01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	static final String URL = "jdbc:mysql://localhost/dictionaly";
	static final String USER = "root";
	static final String PW = "";

	 //insert
	public int registNote(List<Note> note){

		int result = 0;

		try {
			 //ドライバーのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dictionary?useUnicode=true&characterEncoding=utf8", "root", "");

			 //DB接続
			if( con != null ){
				System.out.println("DB接続完了　\r\n---");
			}

			else{
					System.out.println("DB接続失敗\r\n---");
					return result;
			}

			for(int i = 0 ; i < note.size()  ; i++){
				String SQL = "INSERT INTO word(english, japanese, exe) VALUES(?, ?, ?)";
				Note nt = note.get(i);
				st = con.prepareStatement(SQL);
				st.setString(1, nt.getEnglish());
				st.setString(2, nt.getJapanese());
				st.setString(3, nt.getExe());
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

	 //単語一覧 select
	public List<Note> getWords(){
		List<Note> lists = new ArrayList<Note>();

		try {
			 //ドライバーのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dictionary", "root", "");

			 //DB接続
			if( con != null ){
				System.out.println("登録済み単語一覧");
			}

			else{
					System.out.println("DB接続失敗\r\n---");
					return lists;
			}

			 // 単語の読み出し
			String SQL = "SELECT * FROM word";
			st = con.prepareStatement(SQL);
			rs = st.executeQuery();

			while(rs.next()){
				Note nt = new Note(rs.getString("english"), rs.getString("japanese"), rs.getString("exe"));
				lists.add( nt );
			}

			System.out.println(lists);

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
		return lists;	// 結果を返す

	}

}
