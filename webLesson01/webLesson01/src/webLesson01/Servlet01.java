package webLesson01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
			req.setCharacterEncoding("UTF-8");

			String english = req.getParameter("english");
			String japanese = req.getParameter("japanese");
			String exe = req.getParameter("exe");

			req.setAttribute("english", english);
			req.setAttribute("japanese", japanese);
			req.setAttribute("exe", exe);

			//インスタンスつくる
			NoteDAO dao = new NoteDAO();
			//配列のインスタンスつくる
			List<Note> note = new ArrayList<Note>();
			//配列のインスタンスに値をセットしつつNote型のインスタンスつくる
			note.add( new Note(english, japanese, exe) );
			//insertのメソッドを呼びつつ数える
			int count = dao.registNote(note);
			count = note.size();

			//今登録した件数
			req.setAttribute("registcount", count);

			List<Note> ar = new ArrayList<>();
			ar = dao.getWords();

			int i = ar.size();

			//単語一覧
			req.setAttribute("ar", ar);

			//今登録してある件数
			req.setAttribute("registint", i);

			req.getRequestDispatcher("result.jsp").forward(req, res);
			req.getRequestDispatcher("list.jsp").forward(req, res);

	}

}
