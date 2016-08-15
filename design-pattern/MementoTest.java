public class MementoTest {
    public static void main(String[] args) {
        // 创建原始类
        Original original = new Original("egg");

        // 创建备忘录
        Storage storage = new Storage(original.createMemento());

        // 修改原始类的状态
        System.out.println("original value: " + original.getValue());
        original.setValue("milk");
        System.out.println("value changed: " + original.getValue());

        // 回复原始类的状态
        original.restoreMemento(storage.getMemento());
        System.out.println("restore from memento: " + original.getValue());
    }
}
