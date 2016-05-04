package beatGoogle;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class Steagle
 */
@WebServlet("/Steagle")
public class Steagle extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Steagle()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String keywrd = new String(request.getParameter("q").getBytes("iso-8859-1"), "UTF-8");
		System.out.println(keywrd);

		response.getWriter().println(new GsonBuilder().setPrettyPrinting()
				.create().toJson(fResult(keywrd)));
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private List<WebPage> fResult(String keywrd)
			throws UnsupportedEncodingException, IOException
	{
		List<WebPage> result = new ArrayList<>();

		Parser gSearch = new Parser();
		List<WebPage> myWbs = gSearch.myParse();
		Score score = new Score();
		List<WebPage> myscr = score.countScore(myWbs, keywrd);
		Sort sort = new Sort();
		List<WebPage> grt = gSearch.gParse(URLEncoder.encode(keywrd, "UTF-8"));
		List<WebPage> myrt = sort.sort(myscr);

		if (myscr.get(0).getScore() == 0)
		{
			result.addAll(grt);
			result.addAll(myrt);

		} else
		{
			result.addAll(myrt);
			result.addAll(grt);
		}
		return result;
	}

}
