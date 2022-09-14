package no.hvl.dat250.jpa.assignment2;

    import lombok.Data;
    import javax.persistence.*;


@Entity
@Data
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pincode;

    private Integer count;


    public Long getId() {
        return id;
    }

    public String getPincode() {
        return this.pincode;
    }

    public Integer getCount() {
        return this.count;
    }
}
