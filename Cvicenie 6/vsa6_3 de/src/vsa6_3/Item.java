/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsa6_3;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;

/**
 *
 * @author Viktor
 */
@Entity
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private MyData data;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Item next;

    public Long getId() {
        return id;
    }

    public MyData getData() {
        return data;
    }

    public void setData(MyData data) {
        this.data = data;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }
    
    public void addData(MyData d)
    {

        Item nxt = this.getNext();
        Item nw = new Item();
        nw.setData(d);
        
        if(nxt != null)
        {
            nw.setNext(nxt);
        }
        
        this.setNext(nw);

    }

    void appendData(MyData d)
    {
        Item nw = new Item();
        Item next = this;
        while(next.getNext() != null)
        {
            next = next.getNext();
        }
        
        nw.setData(d);
        next.setNext(nw);
        
        
    }
    
    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vsa6_3.Item[ id=" + id + " ]";
    }
    
}
