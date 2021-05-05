package com.project.QuickProject.common.utils;


import com.project.QuickProject.common.exception.BizException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

/**
@author Jimmey-Jiang
 * @desc Assert 断言
 */
public class Assert {
    /**
     * 断言这个 boolean 为 true
     * <p>为 false 则抛出异常</p>
     *
     * @param expression boolean 值
     * @param message    消息
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BizException(message);
        }
    }

    /**
     * 断言这个 collection 不为 empty
     * <p>为 empty 则抛异常</p>
     *
     * @param collection 集合
     * @param message    消息
     */
    public static void notEmpty(Collection<?> collection, String message) {
        isTrue(CollectionUtils.isNotEmpty(collection), message);
    }

    /**
     * 断言这个 string 不为 blank
     * <p>为 blank 则抛异常</p>
     *
     * @param object  对象
     * @param message 消息
     */
    public static void notBlank(String object, String message) {
        isTrue(StringUtils.isNotBlank(object), message);
    }

    /**
     * 断言这个 string 不为 blank
     * <p>为 blank 则抛异常</p>
     *
     * @param object  对象
     * @param message 消息
     */
    public static void notBlanks(String message, String... object) {
        boolean tag = true;
        for (String one : object) {
            if (StringUtils.isBlank(one)) {
                tag = false;
                break;
            }
        }
        isTrue(tag, message);
    }

    /**
     * 断言这个 object 不为 null
     * <p>为 null 则抛异常</p>
     *
     * @param object  对象
     * @param message 消息
     */
    public static void notNull(Object object, String message) {
        isTrue(object != null, message);
    }

    /**
     * 断言这个 object 为 null
     * <p>为 null 则抛异常</p>
     *
     * @param object  对象
     * @param message 消息
     */
    public static void isNull(Object object, String message) {
        isTrue(object == null, message);
    }


}
