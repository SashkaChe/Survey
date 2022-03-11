import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args)
    {

        Map<String, Topic> map = new HashMap<>();

        Scanner scan = new Scanner(System.in);

        boolean start = true;

        while (start) {

            System.out.println("Введите команду:");

            String text = scan.nextLine();
            String[] array = text.split(" ");

            if (array[0].equals("exit")) {
                start = false;
            }

            if (array[0].equals("create")) {
                System.out.println("Введите вопрос:");
                String name = scan.nextLine();
                List<String> variants = new ArrayList<>();
                System.out.println("Укажите количество вариантов ответа:");
                int count = scan.nextInt();

                System.out.println("Введите варианты ответов:");
                while (count >= 0) {
                    variants.add(scan.nextLine());
                    count--;
                }
                variants.removeIf((s) -> s.equals(""));
                map.put(array[1], new Topic(name, variants));
                continue;
            }

            if (array[0].equals("list")) {
                for(Map.Entry<String, Topic> obj : map.entrySet()) {
                    System.out.println(obj.getKey() + "(" + obj.getValue().getName() + ")");
                }
                continue;
            }

            if (array[0].equals("view")) {
                Topic obj = map.get(array[1]);
                System.out.println(obj.getName());
                int count = 1;
                for (String topic : obj.getVariants()) {
                    System.out.println(count + " " + topic);
                    count++;
                }
                continue;
            }

            if (array[0].equals("delete")) {
                map.remove(array[1]);
                System.out.println("Запись " + array[1] + " удалена");
                continue;
            }

        }


     if (args.length > 0 && args[0].equals("savefile")) {
         System.out.println("Данные записаны в файл");

         try (BufferedWriter obj = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:/topic.txt")));) {

             for(Map.Entry<String, Topic> obj_topic : map.entrySet()) {

                 Topic topic = obj_topic.getValue();

                 obj.write(topic.getName() + "\n");

                 for (String var : topic.getVariants()) {
                     obj.write(var + "\n");
                 }
                 obj.write("\n");
             }

         }
         catch (IOException e) {

         }

       }


    }

}
