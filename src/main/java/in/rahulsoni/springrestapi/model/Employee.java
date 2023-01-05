package in.rahulsoni.springrestapi.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


@Setter
@Getter
@ToString
@Entity //adding this annotation makes this class as database table ..( Similar to roomDb)
@Table(name = "tbl_employee") //persistance package
public class Employee {
    //    @JsonProperty("full_name") //same as @SerializedName("data") in android...  remote name...
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //hibernate gen 5 and later req Identity
//                                                          if we want gen 4 or below , we can use Auto
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name should not be empty")
//    @NotNull(message = "Name should not be null")
    private String name;

    //    @JsonIgnore //used to hide this properties which are not supposed to be accessed in responseBody...
    @Column(name = "age")
    private Long age = 0L;

    @Column(name = "location")
    @NotBlank(message = "location should not be empty")
//    @NotEmpty(message = "location should not be empty")
    @NotNull(message = "location should not be null")
    private String location;

    @Column(name = "email")
    @NotBlank(message = "email should not be empty")
//    @NotEmpty(message = "email should not be empty")
    @Email(message = "please enter valid email address")
//    @NotNull(message = "email should not be null")
    private String email;

    @Column(name = "department")
    @NotBlank(message = "department should not be empty")
//    @NotEmpty(message = "department should not be empty")
//    @NotNull(message = "department should not be null")
    private String department;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

}
