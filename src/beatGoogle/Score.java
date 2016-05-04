package beatGoogle;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;

public class Score
{

	public List<WebPage> countScore(List<WebPage>webPages,String keyword) throws IOException
	{
		int weight = 1;
		int count = 0;
		int score = 0;
		
		for (WebPage webPage : webPages)
		{
			String html = Jsoup.connect(webPage.getUrl())
					.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_5)")
					.get().text() + "!";
			if (html.contains(keyword))
			{
				count = html.split(keyword).length-1;
				
				if (keyword.contains("����"))
				{
					score = score + (weight * 5 * count);
				}
				if (keyword.contains("�\�U"))
				{
					score = score + (weight * 4 * count);
				}
				if (keyword.contains("�]"))
				{
					score = score + (weight * 4 * count);
				}
				if (keyword.contains("�@�k"))
				{
					score = score + (weight * 3 * count);
				}
				if (keyword.contains("����"))
				{
					score = score + (weight * 3 * count);
				}
				if (keyword.contains("����"))
				{
					score = score + (weight * 3 * count);
				}
			}
			webPage.setScore(score);
		}
		return webPages;
	}
}
