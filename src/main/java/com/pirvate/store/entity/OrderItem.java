package com.pirvate.store.entity;

import lombok.ToString;

import java.util.Date;
@ToString
public class OrderItem {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.id
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.oid
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private Integer oid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.pid
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private Integer pid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.title
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.image
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private String image;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.price
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private Long price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.num
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private Integer num;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.created_user
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private String createdUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.created_time
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.modified_user
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private String modifiedUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_order_item.modified_time
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private Date modifiedTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.id
     *
     * @return the value of t_order_item.id
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.id
     *
     * @param id the value for t_order_item.id
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.oid
     *
     * @return the value of t_order_item.oid
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public Integer getOid() {
        return oid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.oid
     *
     * @param oid the value for t_order_item.oid
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setOid(Integer oid) {
        this.oid = oid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.pid
     *
     * @return the value of t_order_item.pid
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.pid
     *
     * @param pid the value for t_order_item.pid
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.title
     *
     * @return the value of t_order_item.title
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.title
     *
     * @param title the value for t_order_item.title
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.image
     *
     * @return the value of t_order_item.image
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public String getImage() {
        return image;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.image
     *
     * @param image the value for t_order_item.image
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.price
     *
     * @return the value of t_order_item.price
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public Long getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.price
     *
     * @param price the value for t_order_item.price
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.num
     *
     * @return the value of t_order_item.num
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public Integer getNum() {
        return num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.num
     *
     * @param num the value for t_order_item.num
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.created_user
     *
     * @return the value of t_order_item.created_user
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public String getCreatedUser() {
        return createdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.created_user
     *
     * @param createdUser the value for t_order_item.created_user
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser == null ? null : createdUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.created_time
     *
     * @return the value of t_order_item.created_time
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.created_time
     *
     * @param createdTime the value for t_order_item.created_time
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.modified_user
     *
     * @return the value of t_order_item.modified_user
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public String getModifiedUser() {
        return modifiedUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.modified_user
     *
     * @param modifiedUser the value for t_order_item.modified_user
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser == null ? null : modifiedUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_order_item.modified_time
     *
     * @return the value of t_order_item.modified_time
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_order_item.modified_time
     *
     * @param modifiedTime the value for t_order_item.modified_time
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}