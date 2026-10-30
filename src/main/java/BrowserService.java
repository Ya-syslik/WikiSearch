import java.awt.*;
import java.net.URI;

public class BrowserService {
    public void openArticleInBrowser(int pageID){
        try{
            String articleAddress="https://ru.wikipedia.org/w/index.php?curid="+pageID;
            URI uri=new URI(articleAddress);
            Desktop.getDesktop().browse(uri);}
        catch (Exception e){
            throw new RuntimeException();
        }
    }
}
