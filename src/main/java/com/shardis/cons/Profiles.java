package com.shardis.cons;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Tomasz Kucharzyk
 */

@Getter
@AllArgsConstructor
public enum Profiles {

    DEV("dev"),
    PROD("prod");

    private String profileName;


}
