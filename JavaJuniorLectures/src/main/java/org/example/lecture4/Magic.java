package org.example.lecture4;

import org.hibernate.Session;
import org.hibernate.annotations.*;
import org.hibernate.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@javax.persistence.Entity
@Table(name = "test.magic")
public class Magic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "название")
    private String name;
    @Column(name = "повреждение")
    private String damage;
    @Column(name = "атака")
    private int attBonus;

    public Magic(String name, String damage, int attBonus) {
        this.name = name;
        this.damage = damage;
        this.attBonus = attBonus;
    }

    public Magic() {
    }
}
