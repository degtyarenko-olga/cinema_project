package com.noirix.controller.dto.session;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SessionCreateRequest {

    Timestamp sessionStart;

    Timestamp endOfSession;
}
