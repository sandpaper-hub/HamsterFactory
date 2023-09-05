import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class HamsterFactory {
    Scanner scanner = new Scanner(System.in);
    HashSet<Hamster> hashCollection = new HashSet<>();
    // нужна структура данных, в которой можно хранить только уникальных хомяков

    public void start() {
        System.out.println("Добро пожаловать на фабрику хомяков!");
        System.out.println("Здесь вы можете создавать, удалять и даже печатать хомяков");
        System.out.println("Для работы с фабрикой используйте следующие команды:");
        System.out.println("'Печать' — показать всех хомяков в хранилище");
        System.out.println("'Создать [Имя]' — создать хомяка с выбранным именем");
        System.out.println("'Удалить [Имя]' — удалить хомяка с выбранным именем");
        System.out.println("'Очистить' — удалить всех, ранее созданных хомяков");
        System.out.println("'Размер' — вывести на экран текущее количество хомяков в хранилище");
        System.out.println("'Завершить' — завершить работу программы");

        while (true) {
            System.out.println("Введите команду...");

            String command = scanner.nextLine();
            if (command.equals("Завершить")) {
                System.out.println("Программа завершена! Спасибо, что пользуетесь нашей сетью хомячих фабрик");
                break;
            } else {
                //executeCommand();  иначе вызвать метод executeCommand(), который распознает команду и вызывает нужный метод для её обработки
                // обратите внимание, метод executeCommand() создавать не нужно, только вызвать
            }
        }
    }

    private void executePrint() {
        Iterator<Hamster> iterator = hashCollection.iterator();
        System.out.println("Вывожу актуальный список хомяков в хранилище:");
        while (iterator.hasNext()) {
            Hamster hamster = iterator.next();
            System.out.println("Хомяк '" + hamster.name + "'");
        }
        // выведите сообщение: "Вывожу актуальный список хомяков в хранилище:"
        // напечатайте всех хомяков, которые есть в хранилище в формате "Хомяк '[Имя хомяка]'"
    }

    private void executeCreate(String name) {
        Hamster hamster = new Hamster(name);
        if (hashCollection.contains(hamster)) {
            System.out.println("Хомяк '" + name + "' уже находится в хранилище");
        } else {
            hashCollection.add(hamster);
            System.out.println("Хомяк '" + name + "' создан и добавлен в хранилище");
        }
        // создайте хомяка с именем [name] и добавьте его в ваше хранилище
        // если такой хомяк уже есть в хранилище, выведите: "Хомяк '[name]' уже находится в хранилище"
        // иначе выведите сообщение: "Хомяк '[name]' создан и добавлен в хранилище"
    }

    private void executeRemoveByName(String name) {
        Hamster hamster = new Hamster(name);
        if (hashCollection.contains(hamster)) {
            hashCollection.remove(hamster);
            System.out.println("Хомяк '" + name + "' удалён успешно");
        } else {
            System.out.println("Хомяка с именем '" + name + "' не существует");
        }
        // если хомяк существует, то нужно удалить его и вывести сообщение: "Хомяк '[Имя удаленного хомяка]' удалён успешно"
        // иначе вывести сообщение: "Хомяка с именем '[Имя]' не существует"
    }

    private void executeClear() {
        for (Hamster hamster : hashCollection) {
            String name = hamster.name;
            System.out.println("Хомяк '" + name + "' удалён успешно");
        }
        hashCollection.clear();
        System.out.println("Операция очистки завершена успешно! Все хомяки были удалены из хранилища");
        // нужно удалить всех хомяков, которые есть в хранилище
        // каждый удаленный хомяк должен сопровождаться сообщением "Хомяк '[Имя удаленного хомяка]' удалён успешно"
        // после завершения очистки напечатайте "Операция очистки завершена успешно! Все хомяки были удалены из хранилища"
    }

    private void executeSize() {
        if (!hashCollection.isEmpty()) {
            System.out.println("Количество хомяков в хранилище равно " + hashCollection.size());
        } else {
            System.out.println("В хранилище нет хомяков");
        }
        // если в хранилище есть хомяки, нужно вывести сообщение: "Количество хомяков в хранилище равно [текущее количество хомяков в хранилище]"
        // иначе вывести: "В хранилище нет хомяков"
    }

    // этот метод мы реализовывали в прошлой фабрике, оставим без изменений
    private void showErrorMessage() {
        System.out.println("Неверная команда, попробуйте еще раз.");
    }
}
