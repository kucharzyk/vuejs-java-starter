package com.shardis.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by tomasz on 14.01.16.
 * All rights reserved Bazus 2016
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ChatMessage {
    private String message;
    private String author;
}
