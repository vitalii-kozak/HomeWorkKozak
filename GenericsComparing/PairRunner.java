package GenericsComparing;


public class PairRunner {
    public static void main(String[] args) {

        Pair<String, String> pair1 = new Pair<String, String>("Left","Right");
        System.out.println(pair1);

        Pair pair2 = new Pair("111", 222);
        System.out.println(pair2);

        Pair<Boolean, Long> pair3 = new Pair<Boolean, Long>(true, 22222L);
        System.out.println(pair3);

        Pair pair4 = new Pair(0.123, 11.44);
        System.out.println(pair4);

    }

}
