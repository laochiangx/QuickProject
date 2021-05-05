package com.project.QuickProject.monitor.dto;

import lombok.Data;

/**
 * MetaSpace
 *
 * @author Jimmey-Jiang
 * @date 2020/8/16
 */
@Data
public class MetaSpace {

    private String unit = "Byte";

    private long committed;

    private long init;

    private long max;

    private long used;
}
