package kodlamaio.hrms.Entities.Concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="language_levels")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","languageCandiates"})
public class LanguageLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    @Column(name="id")
    private int id;

    @Column(name="languages_level_name")
    private String levelName;

    @JsonIgnore
    @OneToMany(mappedBy = "languageLevel" )
    private List<LanguageCandiate> languageCandiates;


}
