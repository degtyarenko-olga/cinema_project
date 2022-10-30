package com.noirix.controller.dto.ticket;

import lombok.Data;

@Data
public class TicketCreateRequest {

    private Long movieId;

    private Long sessionId;

    private Long placeId;

}
