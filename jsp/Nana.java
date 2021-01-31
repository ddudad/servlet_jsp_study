import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Nana extends HttpServlet 
{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			OutputStream os = response.getOutputStream();
			PrintStream out = new PrintStream(os, true);
			//위 두 코드들은
			//PrintWriter out = response.getWriter();
			//로 대체할 수 있음(다국어 문자 사용 가능, 자바는 Stream, Writer 2가지 계열의 스트림이 있다.)
			out.println("Hello Servlet!!");
		}
}