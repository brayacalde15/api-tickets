package com.api.tickets.apitickets.data;

import org.springframework.data.repository.CrudRepository;

import com.api.tickets.apitickets.data.models.Ticket;

public interface TicketRepository extends CrudRepository<Ticket,Integer>{   }
