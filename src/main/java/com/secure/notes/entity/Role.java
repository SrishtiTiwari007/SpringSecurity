package com.secure.notes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "roles")
public class Role {

    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer roleId;

    @Enumerated(EnumType.STRING)
    @ToString.Exclude
    @Column(name = "role_name", length = 20)
    private AppRole roleName;

    @ToString.Exclude
    @JsonBackReference
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Set<User> users = new HashSet<>();

    public Role(AppRole roleName){
        this.roleName = roleName;
    }
}
