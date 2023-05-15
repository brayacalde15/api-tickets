package com.api.tickets.apitickets.data.models;


import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;

@Entity


public class Ticket {
    @Id
    @GeneratedValue
    private Integer ticketId;
    private Integer userId;
    private Timestamp creationDate;
    private Timestamp updatedDate;
    public Integer getTicketId() {
        return ticketId;
    }
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Timestamp getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
    public Timestamp getUpdatedDate() {
        return updatedDate;
    }
    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

   

   

}
