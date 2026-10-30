import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLEncoder;
import java.nio.channels.IllegalChannelGroupException;

public class WikiAPIClient {
    private WikiAPIClient(){}


    private static class Holder{
        private static final WikiAPIClient INSTANCE=new WikiAPIClient();
    }

    public static WikiAPIClient getInstance() {
        return Holder.INSTANCE;
    }

    public String fetchRawJSON(String searchQuery){
        try {
            searchQuery = URLEncoder.encode(searchQuery, "UTF-8");//преобразуем введенные данные в корректные для ссылки
            String fullAddress = "https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch="
                    + searchQuery;//формируем ссылку для википедии
            URL url = new URL(fullAddress);// создаем объект url для валидации и разбора структуры интернет-адреса

            // открваем сетевое http-соединение с сервером
            HttpURLConnection httpConnection =(HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("GET");//выставляем метод http запроса, GET-получить данные

            StringBuilder response=new StringBuilder();//String неизменяем, поэтому используем StringBuilder чтобы не захломлять память

            //принимаем ответ от сервера Википедии
            BufferedReader reader =new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            String line;
            while((line=reader.readLine())!=null){
                response.append(line);
            }
            reader.close();

            return response.toString();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

}
