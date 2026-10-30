import java.util.List;

class WikiArticle{// класс статьи (поля title,pageid)
    String title;
    int pageid;

    public int getPageid() {
        return pageid;
    }

    public String getTitle() {
        return title;
    }
}
class QueryData{//класс массива статей (поле search)
    List<WikiArticle> search;

    public List<WikiArticle> getSearch() {
        return search;
    }
}
//класс как параметр на вход функции парса
//после отработки в нем будет лежать массив статей с названием и ID для каждой
class WikiResponse{
    QueryData query;

    public QueryData getQuery() {
        return query;
    }
}