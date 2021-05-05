package com.project.QuickProject.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * tree TODO <br>
 *
 * @author Jimmey-Jiang 2020-10-14
 * 权限树形结构
 */
public class Tree<T> {
    /**
     * 节点ID
     */
    private String id;
    /**
     * 显示节点文本
     */
    private String title;
    /**
     * 节点状态，open closed
     */
    private Map<String, Object> state;
    /**
     * 节点是否被选中 true false
     */
    private boolean checked = false;
    /**
     * 节点属性
     */
    private Map<String, Object> meta;

    /**
     * 节点的子节点
     */
    private List<Tree<T>> children = new ArrayList<Tree<T>>();

    private String component;

    /**
     * 父ID
     */
    private String parentId;

    private String path;

    private String name;
    /**
     * 是否有父节点
     */
    private boolean hasParent = false;
    /**
     * 是否有子节点
     */
    private boolean hasChildren = false;

    public Tree(String id, String text, Map<String, Object> state, boolean checked, Map<String, Object> attributes,
                List<Tree<T>> children, boolean isParent, boolean isChildren, String parentID) {
        super();
        this.id = id;
        this.title = text;
        this.state = state;
        this.checked = checked;
        this.meta = attributes;
        this.children = children;
        this.hasParent = isParent;
        this.hasChildren = isChildren;
        this.parentId = parentID;
    }

    public Tree() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Object> getState() {
        return state;
    }

    public void setState(Map<String, Object> state) {
        this.state = state;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    public void setChildren(boolean isChildren) {
        this.hasChildren = isChildren;
    }

    public void setChildren(List<Tree<T>> children) {
        this.children = children;
    }

    public boolean isHasParent() {
        return hasParent;
    }

    public void setHasParent(boolean isParent) {
        this.hasParent = isParent;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {

        //return JSON.toJSONString(this);
    	return null;
    }

}