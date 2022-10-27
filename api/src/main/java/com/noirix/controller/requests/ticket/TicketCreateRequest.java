package com.noirix.controller.requests.ticket;

import lombok.Data;

@Data
public class TicketCreateRequest {

    //private Long userId;

    private Long movieId;

    private Long sessionId;

    private Long placeId;

}
