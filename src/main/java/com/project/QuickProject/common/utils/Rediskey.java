package com.project.QuickProject.common.utils;

/**
 * @author Jimmey-Jiang
 * @Date: 2020/11/23 17:52
 * @Description:
 */
public class Rediskey {

	
	
	public static final int NOTRECEIVED = 1;//任务状态:未领取
	public static final int RECEIVED = 2;//已领取
	public static final int UPLOADED =3;//已上传
	public static final int UNDERINSPECTION=4;//检验中
	public static final int PIECEWORK=5;//已计件
	public static final int SETTLED=6;//已结算
	
    public static final String ARTICLE_VIEWCOUNT_CODE = "ARTICLEVIEWCOUNTCODE_";
    public static final String ARTICLE_VIEWCOUNT_KEY = "ARTICLE_VIEWCOUNT_KEY";

    public static final String STORE_VIEWCOUNT_CODE = "STOREVIEWCOUNTCODE_";
    public static final String STORE_VIEWCOUNT_KEY = "STORE_VIEWCOUNT_KEY";

    public static final String GOODS_VIEWCOUNT_CODE = "GOODSVIEWCOUNTCODE_";
    public static final String GOODS_VIEWCOUNT_KEY = "GOODS_VIEWCOUNT_KEY";
    public static final String KDWL_INFO_CACHE = "KDWL_INFO_CACHE";

    public static String appletBannerKey = "appletBannerKey";
    public static String appletCategoryKey = "appletCategoryKey";
    public static String appletNavIconKey = "appletNavIconKey";
    public static String appletHotProductsKey = "appletHotProductsKey";
    public static String appletNewProductsKey = "appletNewProductsKey";
    public static String appletCateProductsKey = "appletCateProductsKey";
    public static String appletsmsFlashPromotionProductKey = "appletsmsFlashPromotionProductKey";


    public static String allTreesList = "allTreesList:%s";
    public static String menuTreesList = "menuTreesList:%s";
    public static String permissionTreesList = "permissionTreesList:%s";
    public static String allMenuList = "menuList:%s";
    public static String menuList = "menuList:%s";
    public static String user = "user:%s";

    public static String HomeContentResult = "HomeContentResult";
    public static String PmsProductResult = "PmsProductResult";
    public static String orderDetailResult = "orderDetailResult";

    public static String PmsProductConsult = "PmsProductConsult";


    public static String GOODSDETAIL = "GOODSDETAIL:%s";
    public static String GOODSDETAIL1 = "GOODSDETAIL1:%s";
    public static String GOODSHISTORY = "GOODSHISTORY:%s";
    
    public static String APPUSERMODULAR_YAPEI = "user:%s:yapei";//雅培业务系统
    public static String APPUSERMODULAR_PNC = "user:%s:pnc";//雅培业务系统
    public static String APPUSERMODULAR_BI = "user:%s:bi";//quickbi业务系统

}
