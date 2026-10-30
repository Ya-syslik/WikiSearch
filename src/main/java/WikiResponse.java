import java.util.List;

class WikiArticle{// класс статьи (поля title,pageid)
    private String title;
    private int pageid;

    public int getPageid() {
        return pageid;
    }

    public String getTitle() {
        return title;
    }
}
class QueryData{//класс массива статей (поле search)
    private List<WikiArticle> search;

    public List<WikiArticle> getSearch() {
        return search;
    }
}
//класс как параметр на вход функции парса
//после отработки в нем будет лежать массив статей с названием и ID для каждой
class WikiResponse{
   private QueryData query;

    public QueryData getQuery() {
        return query;
    }
}