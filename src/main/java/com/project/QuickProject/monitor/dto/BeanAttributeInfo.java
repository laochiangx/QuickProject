package com.project.QuickProject.monitor.dto;

import lombok.Data;

import javax.management.MBeanAttributeInfo;

/**
 * BeanAttributeInfo
 *
 * @author Jimmey-Jiang
 * @date 2020/8/1
 */
@Data
public class BeanAttributeInfo {

    private String name;

    private BeanAttributeValue value;

    private MBeanAttributeInfo attributeInfo;



}
