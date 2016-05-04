package beatGoogle;

import java.util.ArrayList;
import java.util.List;

public class Sort
{
	public List<WebPage> sort(List<WebPage> webPages)
	{	
		if (webPages.size()<=1)
		{
			return webPages;
		}else{
			List<WebPage> lt = new ArrayList<>();
			List<WebPage> eq = new ArrayList<>();
			List<WebPage> gt = new ArrayList<>();
			List<WebPage> retVal = new ArrayList<>();
			
			int indexOfPivot = webPages.size() / 2;
			WebPage pivot = webPages.get(indexOfPivot);
			
			for (WebPage webPage : webPages)
			{
				if (webPage.getScore()<pivot.getScore())
				{
					lt.add(webPage);
				}else if (webPage.getScore()==pivot.getScore()) {
					eq.add(webPage);
				}else {
					gt.add(webPage);
				}
			}
			retVal.addAll(sort(lt));
			retVal.addAll(eq);
			retVal.addAll(sort(gt));
			return retVal;
		}
	}
	
	

}
