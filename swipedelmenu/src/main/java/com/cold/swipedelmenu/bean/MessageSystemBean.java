package com.cold.swipedelmenu.bean;

/**
 * Created by Administrator on 2018/1/22 0022.
 */

public class MessageSystemBean extends MessageBean {

    public static final int MESSAGE_SYSTEM_TYPE_TIME = 1;
    public static final int MESSAGE_SYSTEM_TYPE_CONTENT = 2;

    /**
     * 是否为图片 1 是 0 否，暂时没有图片消息类型（消息内容为一张图片）
     * 现阶段均为文字跳转到页面
     */
    private boolean is_image;

    /**
     * 图片地址
     */
    private String image_url;

    /**
     * 标题
     */
    private String title;

    /**
     * 客户端跳转地址
     */
    private String url;

    /**
     * 网页版跳转内容
     */
    private String web_url;

    /**
     * 活动开始时间
     */
    private long act_stime;

    /**
     * 活动结束时间
     */
    private long act_etime;

    /**
     * 帮会id
     */
    private String fid;

    /**
     * 是否为申请加入帮会消息 1 是 0 否
     */
    private boolean is_join_gang;

    /**
     * 接受加入（帮会/好友）
     */
    private boolean is_join_accept;

    /**
     * 标识否是是消息，否则是时间类型，true：消息 false：时间
     */
    private boolean is_message;

    /**
     * 显示类型
     */
    public int msgType;

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    @Override
    public int getItemType() {
        return msgType;
    }

    public MessageSystemBean(){
        type = MSG_TYPE_SYS;
    }

    public MessageSystemBean(int msgType, String content){
        type = MSG_TYPE_SYS;
        this.msgType = msgType;
        this.content = content;
    }

    public boolean is_image() {
        return is_image;
    }

    public void setIs_image(boolean is_image) {
        this.is_image = is_image;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public long getAct_stime() {
        return act_stime;
    }

    public void setAct_stime(long act_stime) {
        this.act_stime = act_stime;
    }

    public long getAct_etime() {
        return act_etime;
    }

    public void setAct_etime(long act_etime) {
        this.act_etime = act_etime;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public boolean is_join_gang() {
        return is_join_gang;
    }

    public void setIs_join_gang(boolean is_join_gang) {
        this.is_join_gang = is_join_gang;
    }

    public boolean is_join_accept() {
        return is_join_accept;
    }

    public void setIs_join_accept(boolean is_join_accept) {
        this.is_join_accept = is_join_accept;
    }
}
