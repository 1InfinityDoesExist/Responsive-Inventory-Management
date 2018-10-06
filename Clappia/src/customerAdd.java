import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;

public class customerAdd implements Filter 
{
	public void init(FilterConfig fconfig) throws ServletException {

	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain fchain) throws IOException, ServletException 
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		String N = req.getParameter("cadd");
		
		
		if(N.contains(" ") || N.length() < 4)
		//if(N.length() < 4)
		{
			out.println("Sorry But No Space will be Entertained / Accept");
			RequestDispatcher rd = req.getRequestDispatcher("Salesjsp.jsp");
			rd.include(req, res);
		}
		else
		{
			fchain.doFilter(request, response);
		}
	}

	public void destroy() {

	}
}
