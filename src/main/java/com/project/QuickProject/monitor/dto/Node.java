package com.project.QuickProject.monitor.dto;

import lombok.Data;

import java.util.List;

/**
 * Node
 *
 * @author Jimmey-Jiang
 * @date 2020/7/25
 */
@Data
public class Node {

    private String key;

    private String fullName;

    private String title;

    private String nodeType;

    private List<Node> children;
}
