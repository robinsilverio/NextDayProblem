public class Main {
    public static void main(String[] args) {
        NextDate testSubjectNextDate = new NextDate(30, 9,1912);
        testSubjectNextDate.generateNewDay();
        System.out.println(testSubjectNextDate.showNewDate());
    }
}
