package com.pirvate.store.entity;

import lombok.ToString;

import java.util.Date;
@ToString
public class ProductCategory {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_category.id
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_category.parent_id
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private Long parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_category.name
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_category.status
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_category.sort_order
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private Integer sortOrder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_category.is_parent
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private Integer isParent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_category.created_time
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_category.modified_time
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private Date modifiedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_category.created_user
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private String createdUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_category.modified_user
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    private String modifiedUser;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_category.id
     *
     * @return the value of t_product_category.id
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_category.id
     *
     * @param id the value for t_product_category.id
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_category.parent_id
     *
     * @return the value of t_product_category.parent_id
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_category.parent_id
     *
     * @param parentId the value for t_product_category.parent_id
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_category.name
     *
     * @return the value of t_product_category.name
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_category.name
     *
     * @param name the value for t_product_category.name
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_category.status
     *
     * @return the value of t_product_category.status
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_category.status
     *
     * @param status the value for t_product_category.status
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_category.sort_order
     *
     * @return the value of t_product_category.sort_order
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_category.sort_order
     *
     * @param sortOrder the value for t_product_category.sort_order
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_category.is_parent
     *
     * @return the value of t_product_category.is_parent
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public Integer getIsParent() {
        return isParent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_category.is_parent
     *
     * @param isParent the value for t_product_category.is_parent
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_category.created_time
     *
     * @return the value of t_product_category.created_time
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_category.created_time
     *
     * @param createdTime the value for t_product_category.created_time
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_category.modified_time
     *
     * @return the value of t_product_category.modified_time
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_category.modified_time
     *
     * @param modifiedTime the value for t_product_category.modified_time
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_category.created_user
     *
     * @return the value of t_product_category.created_user
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public String getCreatedUser() {
        return createdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_category.created_user
     *
     * @param createdUser the value for t_product_category.created_user
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser == null ? null : createdUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_category.modified_user
     *
     * @return the value of t_product_category.modified_user
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public String getModifiedUser() {
        return modifiedUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_category.modified_user
     *
     * @param modifiedUser the value for t_product_category.modified_user
     *
     * @mbggenerated Wed Jul 20 23:44:47 CST 2022
     */
    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser == null ? null : modifiedUser.trim();
    }
}