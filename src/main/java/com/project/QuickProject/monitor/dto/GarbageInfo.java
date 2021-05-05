package com.project.QuickProject.monitor.dto;

import lombok.Data;

/**
 * GarbageInfo
 *
 * @author Jimmey-Jiang
 * @date 2020/8/16
 */
@Data
public class GarbageInfo {

    private String name;

    private long collectionCount;

    private String[] memoryPoolNames;
}
