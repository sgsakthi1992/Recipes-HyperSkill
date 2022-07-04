import java.util.*;


class MapFunctions {

    public static void calcTheSamePairs(Map<String, String> map1, Map<String, String> map2) {
        var count = map1.entrySet().stream()
                .filter(entry -> map2.containsKey(entry.getKey()))
                .filter(entry -> Objects.equals(map2.get(entry.getKey()), entry.getValue()))
                .count();
        System.out.println(count);
    }
}