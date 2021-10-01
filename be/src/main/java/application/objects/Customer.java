package application.objects;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name= "customer")
public class Customer {

    @Id
    private Integer id;

    private String name;

    private String phone;

}
