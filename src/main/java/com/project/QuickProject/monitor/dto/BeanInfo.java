package com.project.QuickProject.monitor.dto;

import lombok.Data;

import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import java.util.List;

/**
 * BeanInfo
 *
 * @author Jimmey-Jiang
 * @date 2020/8/5
 */
@Data
public class BeanInfo {

    private List<BeanAttributeInfo> beanAttributeInfos;

    private MBeanOperationInfo[] operationInfos;

    private MBeanNotificationInfo[] notificationInfos;
}
