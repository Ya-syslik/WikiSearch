import java.util.Scanner;
import java.util.List;

public class ConsoleUIService {
    private final Scanner scanner=new Scanner(System.in);

    public String inputQuery(){
        System.out.println("Введите свой запрос:");
        return scanner.nextLine();
    }

    public void outArticleList(List <WikiArticle> articles){
        if (articles==null||articles.isEmpty()){
            System.out.println("По вашему запросу ничего не найдено(");
        }
        System.out.println("Результаты поиска");
        int articleNumber=1;
        for (WikiArticle a:articles){
            System.out.println(articleNumber+". "+a.getTitle());
            articleNumber++;
        }
    }

    public int inputArticleNumber(int listSize){
        while (true) {
            System.out.println("Введите номер интересующей статьи:");
            String input = scanner.nextLine();
            try {
                int selected = Integer.parseInt(input);
                if (selected >= 0 && selected < (listSize + 1)) {
                    return selected;
                }
                System.out.println("Среди найденных нет статьи с таким номером");
            } catch (Exception e) {
                System.out.println("Номер вводится цифрами,попробуй еще раз");
            }
        }
    }
}
