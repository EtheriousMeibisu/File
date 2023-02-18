import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();

        creatingDirectory("D://Game", "src",stringBuilder);
        creatingDirectory("D://Game", "res",stringBuilder);
        creatingDirectory("D://Game", "savegames",stringBuilder);
        creatingDirectory("D://Game", "temp",stringBuilder);

        creatingDirectory("D://Game/src", "main",stringBuilder);
        creatingDirectory("D://Game/src", "test",stringBuilder);

        createFiles("D://Game/src/main", "Main.java",stringBuilder);
        createFiles("D://Game/src/main", "Utils.java",stringBuilder);

        creatingDirectory("D://Game/res", "drawables",stringBuilder);
        creatingDirectory("D://Game/res", "vectors",stringBuilder);
        creatingDirectory("D://Game/res", "icons",stringBuilder);

        createFiles("D://Game/temp", "temp.txt",stringBuilder);

        try(FileOutputStream fou = new FileOutputStream("D://Game/temp/temp.txt")) {
            byte[] bytes = stringBuilder.toString().getBytes();
            fou.write(bytes,0, bytes.length);
        }catch (IOException io){
            System.out.println("Не удалось записать текст в файл!");
        }
    }

    public static void creatingDirectory(String filePath ,String nameDirectory, StringBuilder stringBuilder){
        File directory = new File(filePath, nameDirectory);
        String str;
        if (directory.mkdir()){
            str = "Папка " + directory.getName() + " создана!";
        }else {
            str = "Папку " + directory.getName() + " не удалось создать.";
        }
        stringBuilder.append(str + "\n");
        System.out.println(str);
    }

    public static void createFiles(String filePath, String nameFile, StringBuilder stringBuilder){
        File file = new File(filePath, nameFile);
        String str;
        try {
            if (file.createNewFile()){
                str = "Файл " + file.getName() + " создан!";
            }else {
                str = "Файл " + file.getName() + " не удалось создать.";
            }
            stringBuilder.append(str + "\n");
            System.out.println(str);
        }catch (IOException e ){
            System.out.println("Системе не удается найти указанный путь!");
        }
    }
}