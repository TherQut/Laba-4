
public class RopeLength {
    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        joinRopes(ropes);
    }

    public static void joinRopes(int[] ropes) {
        int sumCosts = 0;

        System.out.println("Количество длин: " + ropes.length);
        printArray(ropes);
        System.out.println("-----------------");
        CustomMinPQueue mpq = new CustomMinPQueue(ropes.length);

        for (int num: ropes) {
            mpq.insert(num);
        }

        int cost;
        while ((cost = mpq.sumLeastElements()) != 0) {
            sumCosts += cost;
        }
        System.out.println("Общая длина веревки: " + mpq.min());
        System.out.println("Стоимость всех соединений: " + sumCosts);
    }

    public static void printArray(int[] arr) {
        for (int num: arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
