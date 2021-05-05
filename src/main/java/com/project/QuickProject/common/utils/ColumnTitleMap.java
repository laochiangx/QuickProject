package com.project.QuickProject.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 获取导出的excel的表头信息
 * @author 杨飘
 * 2020/12/26
 */

public class ColumnTitleMap {
	private Map<String, String> columnTitleMap = new HashMap<String, String>();
    private ArrayList<String> titleKeyList = new ArrayList<String> ();

    public ColumnTitleMap(String datatype) {
        switch (datatype) {
            case "TaskInfo"://导出任务列表信息
                initUserInfoColu();
                initUserInfoTitleKeyList();
                break;
            case "UserExpenseInfo"://导出工资费用列表信息
                initUserExpenseInfoColu();
                initUserExpenseInfoTitleKeyList();
                break;
            default:
                break;
        }

    }
    /**
     * mysql工资费用列表需要导出字段--显示名称对应集合
     */
    private void initUserInfoColu() {
        columnTitleMap.put("taskCode", "编号");
        columnTitleMap.put("taskGroupNameShort", "产品代码");
        columnTitleMap.put("taskGroupName", "产品名称");
        columnTitleMap.put("taskGroupTypeName", "任务分类");
        columnTitleMap.put("assetName", "资产分类");
        columnTitleMap.put("taskGroupMarketName", "市场分类");
        columnTitleMap.put("taskReceiptorName", "领取人");
        columnTitleMap.put("taskReceiptorTime", "领取时间");
    }

    /**
     * mysql工资费用列表需要导出字段集
     */
    private void initUserInfoTitleKeyList() {
        titleKeyList.add("taskCode");
        titleKeyList.add("taskGroupNameShort");
        titleKeyList.add("taskGroupName");
        titleKeyList.add("taskGroupTypeName");
        titleKeyList.add("assetName");
        titleKeyList.add("taskGroupMarketName");
        titleKeyList.add("taskReceiptorName");
        titleKeyList.add("taskReceiptorTime");
    }
    /**
     * mysql用户表需要导出字段--显示名称对应集合
     */
    private void initUserExpenseInfoColu() {
        columnTitleMap.put("id", "编号");
        columnTitleMap.put("totalCost", "总费用");
        columnTitleMap.put("taskGroupName", "产品名称");
        columnTitleMap.put("taskStatusName", "任务状态");
        columnTitleMap.put("nickName", "用户名");
        columnTitleMap.put("taskGroupTypeName", "市场分类");
        columnTitleMap.put("amountspayable", "应付金额");
        columnTitleMap.put("unitprice", "单价");
    }

    /**
     * mysql用户表需要导出字段集
     */
    private void initUserExpenseInfoTitleKeyList() {
        titleKeyList.add("id");
        titleKeyList.add("totalCost");
        titleKeyList.add("taskGroupName");
        titleKeyList.add("taskStatusName");
        titleKeyList.add("nickName");
        titleKeyList.add("taskGroupTypeName");
        titleKeyList.add("amountspayable");
        titleKeyList.add("unitprice");
    }
    public Map<String, String> getColumnTitleMap() {
        return columnTitleMap;
    }

    public ArrayList<String> getTitleKeyList() {
        return titleKeyList;
    }
}
