import java.util.List;
class WikiSearchService {
    private WikiSearchService(){}

    private static class Holder{private static final WikiSearchService INSTANCE = new WikiSearchService();}

    public static WikiSearchService getInstance(){return Holder.INSTANCE;}

    public List<WikiArticle> executeSearch(String userInput) throws Exception{ //пропускаем исключения
        String rawJsonResponse=WikiAPIClient.getInstance().fetchRawJSON(userInput);
        WikiResponseParse parser =new WikiResponseParse();
        WikiResponse parsedJsonResponse=parser.parseJSON(rawJsonResponse);
        return parsedJsonResponse.getQuery().getSearch();
    }
}
