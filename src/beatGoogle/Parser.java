package beatGoogle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser
{

	public List<WebPage> gParse(String qStr) throws IOException
	{
		List<WebPage> wbps = new ArrayList<>();

		String url = "http://www.google.com/search?q=%E7%89%9B%E6%8E%92" + qStr
				+ "&num=7&oe=UTF8";
		Document doc = Jsoup.connect(url)
				.userAgent(
						"Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
				.timeout(5000).get();
		
		Elements gResultClass = doc.select("div.g");

			for (Element gResult : gResultClass)
			{
				WebPage webPage = new WebPage();
				String wbName = gResult.select("a").get(0).text();
				String wbUrl = gResult.select("a").get(0).attr("href");
				webPage.setName(wbName);
				webPage.setUrl(wbUrl);
				wbps.add(webPage);
			}

		

		return wbps;
	}
	
	public List<WebPage> myParse()
	{
		List<WebPage> webPages = new ArrayList<>();
		
		WebPage w1 = new WebPage();

		w1.setName("牛排在家吃 - 食譜、作法 - 第 1 頁 - 愛料理");
		w1.setUrl("https://icook.tw/categories/204");
		webPages.add(w1);

		WebPage w2 = new WebPage();

		w2.setName("Olivia♥五分鐘韓式煎烤牛小排 - 愛料理");
		w2.setUrl("https://icook.tw/recipes/125836");
		webPages.add(w2);

		WebPage w3 = new WebPage();
		w3.setName("小廚娘Olivia (邱韻文)");
		w3.setUrl("http://goo.gl/306JB1");
		webPages.add(w3);

		WebPage w4 = new WebPage();

		w4.setName("甜蜜小廚娘♥Olivia邱韻文 :: 痞客邦 PIXNET ::");
		w4.setUrl("http://goo.gl/5P91uo");
		webPages.add(w4);

		WebPage w5 = new WebPage();

		w5.setName("【信豐農場】烙烤牛排與紅藜沙拉 - 愛料理");
		w5.setUrl("https://icook.tw/recipes/125638");
		webPages.add(w5);

		WebPage w6 = new WebPage();

		w6.setName("信豐農場-台灣紅藜藜麥養身食譜專家");
		w6.setUrl("http://www.sinfongfarm.com/");
		webPages.add(w6);
		
		return webPages;
		
	}
}
