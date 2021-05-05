package com.project.QuickProject.monitor.dto;

import lombok.Data;

/**
 * ThreadInfo
 *
 * @author Jimmey-Jiang
 * @date 2020/8/16
 */
@Data
public class ThreadInfo {

    private int liveThreadCount;

    private int livePeakThreadCount;

    private int daemonThreadCount;

    private long totalStartedThreadCount;


}
