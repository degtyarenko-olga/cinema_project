package com.noirix.controller.dto.ticket;

import lombok.Data;

@Data
public class TicketChangeRequest{

    private Long id;

    private Long movieId;

    private Long sessionId;

    private Long placeId;
}
