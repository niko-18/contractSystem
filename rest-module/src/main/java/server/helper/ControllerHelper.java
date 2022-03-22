package server.helper;

import server.entity.Contract;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ControllerHelper {
    public static List<Contract> createRandomContracts() {
        return IntStream.range(0, 10).mapToObj(i -> {
            long date = createRandomInRange(System.currentTimeMillis() - convertDayToMs(90), System.currentTimeMillis());
            return new Contract(UUID.randomUUID().toString(), "Contract " + i, i, date, createRandomInRange(date, System.currentTimeMillis()));
        }).collect(Collectors.toList());
    }

    private static long createRandomInRange(long min, long max) {
        return min + (long) (Math.random() * (max - min));
    }

    private static long convertDayToMs(int day) {
        return (long) (day * 8.64e+7);
    }
}
