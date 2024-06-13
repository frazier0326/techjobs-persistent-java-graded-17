package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank
    @Size(max=75)
    private String location;

    @OneToMany
//            (mappedBy = "job", cascade = CascadeType.ALL)
    @JoinColumn(name="employer_id")
    private final List<Job> jobs = new ArrayList<>();


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Employer(String location) {
        this.location = location;
    }

    public Employer() {}

    public List<Job> getJobs() {
        return jobs;
    }
}
