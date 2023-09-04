import java.util.ArrayList;
import java.util.Scanner;

public class HamsterFactory {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Hamster> hamsters = new ArrayList<>();
    // нужна структура данных, в которой можно хранить хомяков
    // мы не знаем, сколько будет хомяков: 10 или 10_000, поэтому нужна сущность, которая может изменять свой размер

    public void start() {
        System.out.println("Добро пожаловать на фабрику хомяков!");
        System.out.println("Здесь вы можете создавать, удалять и даже заменять одних хомяков на других");
        System.out.println("Для работы с фабрикой используйте следующие команды:");
        System.out.println("'Печать' — показать всех активных хомяков");
        System.out.println("'Создать [Имя]' — создать хомяка с выбранным именем");
        System.out.println("'Удалить [Индекс]' — удалить хомяка по выбранному индексу");
        System.out.println("'Очистить' — удалить всех, ранее созданных хомяков");
        System.out.println("'Заменить [Индекс] [Имя]' — заменить хомяка под выбранным индексом на нового с выбранным именем");
        System.out.println("'Размер' — вывести на экран текущее количество хомяков в хранилище");
        System.out.println("'Завершить' — завершить работу программы");

        while (true) {
            System.out.println("Введите команду...");

            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("Завершить")) {// если пользователь ввел команду "Завершить", надо закончить работу программы (остановить цикл)
                System.out.println("Программа завершена! Спасибо, что пользуетесь нашей сетью хомячьих фабрик");// при завершении работы вывести сообщение "Программа завершена! Спасибо, что пользуетесь нашей сетью хомячьих фабрик"
                break;
            } else {
                //executeCommand();  иначе вызвать метод executeCommand(), который распознает команду и вызывает нужный метод для её обработки
                // обратите внимание, метод executeCommand() создавать не нужно, только вызвать
            }
        }
    }

    private void executePrint() {
        System.out.println("Вывожу актуальный список хомяков в хранилище");
        // выведите сообщение: "Вывожу актуальный список хомяков в хранилище:"
        for (Hamster hamster : hamsters) {
            System.out.println("Хомяк '" + hamster.name + "'");
            // нужно напечатать всех хомяков, которые есть в хранилище в формате "Хомяк '[Имя хомяка]'"
        }
    }

    private void executeCreate(String name) {
        Hamster hamster = new Hamster(name);
        hamsters.add(hamster); // создайте хомяка с именем [name] и добавьте его в ваше хранилище
        System.out.println("Хомяк '" + name + "' создан и добавлен в хранилище");
        // выведите сообщение: "Хомяк '[name]' создан и добавлен в хранилище"
    }

    private void executeRemoveByIndex(int index) {
        if (hamsters.size() > index) {
            System.out.println("Хомяк '" + hamsters.get(index).name + "' удален успешно");
            hamsters.remove(index);
            // если хомяк существует, надо удалить его и вывести сообщение: "Хомяк   '[Имя удаленного хомяка]' удалён успешно"
        } else {
            System.out.println("Хомяка по заданному индексу не существует");
            // иначе вывести сообщение: "Хомяка по заданному индексу не существует"
        }
    }

    private void executeClear() {
        hamsters.clear();
        System.out.println("Операция очистки завершена успешно! Все хомяки были удалены из хранилища");
        // очистить хранилище и вывести в лог сообщение: "Операция очистки завершена успешно! Все хомяки были удалены из хранилища"
    }

    private void executeSet(int index, String name) {
        if (hamsters.size() > index) {
            Hamster hamster = new Hamster(name);
            System.out.println("Хомяк '" + hamsters.get(index).name + "' был успешно заменен на хомяка '" + name + "'");
            // выведите сообщение "Хомяк '[Имя удаленного хомяка]' был успешно заменён на хомяка '[Имя нового хомяка]'"
            hamsters.set(index, hamster);
            // создайте хомяка с именем [name] и замените им хомяка на позиции [index]
        }
    }

    private void executeSize() {
        if (hamsters.size() > 0) {
            System.out.println("Количество хомяков в хранилище равно " + hamsters.size());
        } else {
            System.out.println("В хранилище нет хомяков");
        }
        // если в хранилище есть хомяки, надо вывести сообщение: "Количество хомяков в хранилище равно [текущее количество хомяков в хранилище]"
        // иначе вывести: "В хранилище нет хомяков"
    }

    private void showErrorMessage() {
        System.out.println("Неверная команда, попробуйте ещё раз");
        // выведите сообщение: "Неверная команда, попробуйте ещё раз."
    }
}
