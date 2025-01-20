package Files;

import CharactersPack.HeroPack.Hero;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Save {

    public static void readFile() throws IOException {
        File file = new File("C:\\Users\\marti\\IdeaProjects\\RPG\\src\\Test.txt");
        int len = (int) file.length();
        byte[] bytes = new byte[len];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            assert len == fis.read(bytes);
        } catch (IOException e) {
            assert fis != null;
            close(fis);
            throw e;
        }
    }

    public static void writeFile(Hero hero) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("C:\\Users\\marti\\IdeaProjects\\RPG\\src\\Test.txt");
            String text = ("Name : " + hero.getName() + "\nMax HP : " + hero.getMaxHP() + "\nAttack : " + hero.getAttack() + "\nDefense : " + hero.getDefense());
            fos.write(text.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            assert fos != null;
            close(fos);
            throw e;
        }
    }

    public static void close(Closeable closeable) {
        try {
            closeable.close();
        } catch(IOException ignored) {
        }
    }
    public static void save (Hero hero) throws IOException {
        Save.readFile();
        Save.writeFile(hero);
        Save.readFile();
    }
}
