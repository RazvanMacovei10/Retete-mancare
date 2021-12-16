package com.spring.macoveirazvanionut.entities;

import javax.persistence.*;

@Entity
@Table(name="instruction")
public class Instruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="inst_description",nullable = false,length = 3000)
    private String instructionDesc;

    @ManyToOne
    @JoinColumn(name = "recipeId")
    private Recipe recipe;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstructionDesc() {
        return instructionDesc;
    }

    public void setInstructionDesc(String instructionDesc) {
        this.instructionDesc = instructionDesc;
    }
}
