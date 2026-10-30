import java.util.List;

class Main {
    static void main(String[] args){
        WikiSearchService searchService= WikiSearchService.getInstance();
        ConsoleUIService uiService=ConsoleUIService.getInstance();
        BrowserService browserService=new BrowserService();
        while (true) {
            String userQuery = uiService.inputQuery();

            try {
                List<WikiArticle> articles= searchService.executeSearch(userQuery);
                uiService.outArticleList(articles);
                int chosenArticleNumber = uiService.inputArticleNumber(articles.size());
                if (chosenArticleNumber==0){
                    continue;
                }
                browserService.openArticleInBrowser(articles.get(chosenArticleNumber-1).getPageid());
            }catch (Exception e){
                System.out.println("Обьявлена беспилотная опастность!");
            }
        }
    }
}
