import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.logging.Logger;

public class WebCrawler {

    private static final Logger log = Logger.getLogger(WebCrawler.class.getName());

    public static void main(String args[]){
        Document doc = null;
        try {
            final String searchTerm = "small engine";
            doc = Jsoup.connect("https://classifieds.ksl.com/search?category[]=&subCategory[]=&keyword=" + searchTerm + "&priceFrom=&priceTo=&zip=&miles=25&sellerType[]=&marketType[]=Sale&hasPhotos[]=&postedTimeFQ[]=").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        log(doc.title());
        String pagesource = doc.html();
        System.out.println(pagesource.replaceAll(".*listings: ", ""));
//        for (Element headline : links) {
//            log.info("%s\n\t%s" + headline.attr("title") + headline.absUrl("href"));
//        }
    }
}
