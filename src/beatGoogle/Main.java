package beatGoogle;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		String keywrd = sc.next();
		Parser gSearch = new Parser();
		List<WebPage> myWbs = gSearch.myParse();
		Score score = new Score();
		List<WebPage> myscr = score.countScore(myWbs, keywrd);
		
		
		if (myscr.get(0).getScore()==0)
		{
			gSearch.gParse(URLEncoder.encode(keywrd, "UTF-8"));
			Sort sort = new Sort();
			sort.sort(myscr);
		}else{
			Sort sort = new Sort();
			sort.sort(myscr);
			gSearch.gParse(URLEncoder.encode(keywrd, "UTF-8"));
		}
		
		System.out.println("Done");
		sc.close();

	}

}
