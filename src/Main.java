import java.io.*;
// Імпортуємо пакет java.io для роботи зі введенням/виведенням даних та файлами.
import java.util.Random;
// Імпортуємо клас Random з пакету java.util для генерації випадкових чисел.
import java.util.Scanner;
// Імпортуємо клас Scanner з пакету java.util для зчитування введених даних користувача.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Створюємо об'єкт класу Scanner для зчитування введених даних з консолі.

        System.out.print("Виберіть iм'я файлу: ");
        // Виводимо запит на вибір імені файлу.
        String File_name = scanner.nextLine();
        // Зчитуємо введене користувачем ім'я файлу.

        BufferedReader br = null;
        // Ініціалізуємо змінну для читання з файлу.

        try {
            File file = new File(File_name);
            // Створюємо об'єкт класу File з вказаним ім'ям.

            if (!file.exists()) {
                file.createNewFile();
            }
            // Перевіряємо, чи файл існує, і якщо ні - створюємо новий файл.

            Scanner scan = new Scanner(System.in);
            // Створюємо новий об'єкт класу Scanner для зчитування введених даних користувача.

            System.out.print("Виберіть нижню межу для генерації випадкових чисел, а=");
            // Виводимо запит на введення нижньої межі для генерації випадкових чисел.
            int a = scan.nextInt();

            System.out.print("Виберіть верхню межу для генерації випадкових чисел, b=");
            // Виводимо запит на введення верхньої межі для генерації випадкових чисел.
            int b = scan.nextInt();

            int b1 = Integer.parseInt(String.valueOf(a));
            int b2 = Integer.parseInt(String.valueOf(b));
            // Перетворюємо значення типу int на тип String, а потім знову на тип int.

            PrintWriter numbers = new PrintWriter(file);
            // Створюємо об'єкт класу PrintWriter для запису даних у файл.

            numbers.println(new Random().nextInt(b2 - b1 + 1) + b1);
            // Записуємо випадкове число у файл у межах [b1, b2].
            // Це число буде перше у файлі.

            // Аналогічно записуємо наступні випадкові числа.

            numbers.close();
            // Закриваємо потік запису в файл.

            br = new BufferedReader(new FileReader(File_name));
            // Ініціалізуємо об'єкт класу BufferedReader для читання з файлу.

            String line;
            // Оголошуємо змінну для зберігання рядка, який буде прочитаний з файлу.

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                // Виводимо рядок, прочитаний з файлу, на консоль.
            }
        } catch (Exception e) {
            System.out.println("помилка " + e);
            // Виводимо повідомлення про помилку, якщо виникла виключна ситуація.
        } finally {
            try {
                br.close();
                // Закриваємо потік читання з файлу.
            } catch (Exception e) {
                System.out.println("помилка " + e);
                // Виводимо повідомлення про помилку, якщо виникла виключна ситуація при спробі закрити потік читання з файлу.
            }
        }
    }
}
