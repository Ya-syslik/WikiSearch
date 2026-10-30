import com.google.gson.Gson;

public class WikiResponseParse {
    public WikiResponse parseJSON(String rawJsonResponse) {
        Gson gson=new Gson();//обьект библиотеки Gson
        //вызов метода для извлечения нужной нам информации из ответа сервера
        WikiResponse response=gson.fromJson(rawJsonResponse,WikiResponse.class);
        return response;
    }
}

