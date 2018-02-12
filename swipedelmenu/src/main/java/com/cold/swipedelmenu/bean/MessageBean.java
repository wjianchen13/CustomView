package com.cold.swipedelmenu.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2018/1/22.
 */

public abstract class MessageBean implements MultiItemEntity {

    public static final int MSG_TYPE_SYS = 1;
    public static final int MSG_TYPE_SERVICE = 2;
    public static final int MSG_TYPE_COMMON = 3;

    /**
     * 消息类型 1 系统消息 2 客服消息 3 普通消息
     */
    protected int type;

    /**
     * 是否广播 1 是 0 否
     */
    protected boolean is_all;

    /**
     * 内容
     */
    protected String content;

    /**
     * 创建时间
     */
    protected long ctime;

    /**
     * 1 启用/ 2 禁用
     */
    protected String activate;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean is_all() {
        return is_all;
    }

    public void setIs_all(boolean is_all) {
        this.is_all = is_all;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }

    public String getActivate() {
        return activate;
    }

    public void setActivate(String activate) {
        this.activate = activate;
    }
}
