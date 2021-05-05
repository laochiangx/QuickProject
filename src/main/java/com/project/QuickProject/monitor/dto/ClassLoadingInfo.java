package com.project.QuickProject.monitor.dto;

import lombok.Data;

/**
 * ClassLoadingInfo
 *
 * @author Jimmey-Jiang
 * @date 2020/8/16
 */
@Data
public class ClassLoadingInfo {

    private long totalLoadedClassCount;

    private int loadedClassCount;

    private long unloadedClassCount;

}
