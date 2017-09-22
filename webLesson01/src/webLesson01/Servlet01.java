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

			String title = req.getParameter("title");
			String naiyou = req.getParameter("naiyou");
			String answer = req.getParameter("answer");
			String site = req.getParameter("site");

			req.setAttribute("title", title);
			req.setAttribute("naiyou", naiyou);
			req.setAttribute("answer", answer);
			req.setAttribute("site", site);

			NoteDAO dao = new NoteDAO();
			List<Note> note = new ArrayList<Note>();
			dao.registNote(note);

			req.getRequestDispatcher("result.jsp").forward(req, res);

	}

}
