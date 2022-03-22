package demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Contract {
    private String name;
    private int number;
    private long date;
    private long lastUpdate;

    public boolean isActive() {
        return (System.currentTimeMillis() - lastUpdate) < 5.184e+9;
    }
}
