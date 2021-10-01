package application.objects;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name= "country")
public class Country {

    @Id
    private String code;

    private String name;

    private String regex;
}
