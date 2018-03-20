/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa2xchov3;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.TypedQuery;

/**
 *
 * @author xrevay
 */
@Entity
@Table(name= "CLOVEK")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT c FROM Person c")})

public class Person implements Serializable {

    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="MENO")
    private String name;
    @Column(name="NARODENA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date born;
    @Column(name="VYSKA")
    private float height;
    @Column(name="VAHA")
    private float weight;
    
    @Transient
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public static void najdiVsetkych(EntityManager em)
    {
        TypedQuery<Person> all = em.createNamedQuery("Person.findAll", Person.class);
        
        for(Person o: all.getResultList())
        {
             System.out.println(o.toString());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vsa2xchov2.Clovek[ id=" + id + ", meno="+name+", narodena="+born+", vaha="+weight+", vyska="+height+" ]";
    }
    
}
