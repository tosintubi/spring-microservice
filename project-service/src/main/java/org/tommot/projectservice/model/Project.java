package org.tommot.projectservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    private Long id;
    private String projectCode;
    private String projectTitle;
    private String Location;

}
