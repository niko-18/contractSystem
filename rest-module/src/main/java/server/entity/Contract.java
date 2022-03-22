package server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "contracts")
public class Contract {
    @Id
    private String id;
    private String name;
    private int number;
    private long date;
    private long lastUpdate;
}
