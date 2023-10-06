package it.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@Table(name = "groups")
@Entity
@Data
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String dateOfFinish;
    private String dateOfStart;
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "groups", cascade = CascadeType.ALL)
    private List<Student> students;

    @ManyToMany
    @JoinTable(name = "course_groups",
    joinColumns = @JoinColumn(name = "groups_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @Override
    public String toString() {
        return "Groups{" +
                "id=" + id +
                ", dateOfFinish='" + dateOfFinish + '\'' +
                ", dateOfStart='" + dateOfStart + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
