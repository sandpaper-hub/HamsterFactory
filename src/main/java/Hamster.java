public class Hamster {
    String name;

    public Hamster(String name) {
        this.name = name;
    }

    // Функция boolean equals(Object object) определяет, равен ли один объект другому.
    // Функция int hashCode() возвращает хеш-код, связанный с вызывающим объектом.
    // Эти функции нужны для корректной работы HashSet, подробнее о них поговорим в одной из следующих тем спринта

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hamster hamster = (Hamster) o;
        return name.equals(hamster.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
