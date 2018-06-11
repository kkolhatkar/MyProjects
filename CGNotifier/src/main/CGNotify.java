import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CGNotify{
	public static void main(String[] args) {
		List l = new LinkedList();
		Set s = new LinkedHashSet();
				
		while (true) {
			Document doc;
			try {
				doc = Jsoup.connect("https://chicago.craigslist.org/search/chc/zip").get();
				Elements anchors = doc.select("a");
				for (Element e : anchors) {
					String link = e.attr("href");
					//System.out.println(link);
					if (link.startsWith("https://chicago.craigslist.org/chc/zip/d/")) {
						String usefulllink =	link.substring(40);
						if (s.add(usefulllink)) {
							l.add(usefulllink);
						}
					}
				}
				System.out.println(l.size());

				Iterator itr = l.iterator();
				while (itr.hasNext()) {
					String ans = itr.next().toString();
					//String fans = ans.substring(11, ans.lastIndexOf('.'));
					System.out.println(ans);
							
					 String url =
					  "https://docs.google.com/forms/d/e/1FAIpQLSeLGLUFdRFvmZvmI1Go9XMCR4Fhwqw3beqVga9UQzPidK5tZA/formResponse";
					  Jsoup.connect(url) .data("entry.2005620554", ans)
					  .userAgent("Mozilla") .post();
					  Thread.sleep(10000);
					}
				
				l.clear();
				System.out.println("Going to Sleep");
				Thread.sleep(840000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			 
		}

	}

}
