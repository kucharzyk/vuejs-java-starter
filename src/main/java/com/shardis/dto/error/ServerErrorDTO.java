package com.shardis.dto.error;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Tomasz Kucharzyk
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServerErrorDTO {
    private String error;
    private String description;
    private List<Object> details = Lists.newArrayList();
}
