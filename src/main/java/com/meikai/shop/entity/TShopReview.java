package com.meikai.shop.entity;

import java.io.Serializable;
import java.util.Date;

public class TShopReview implements Serializable {
    /**
     * 主键ID，商品评价
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 商品项目编号
     */
    private Long itemNo;

    /**
     * 会员ID
     */
    private Long memberId;

    /**
     * 评分，1到5分
     */
    private Double mark;

    /**
     * 排序，首评序号为1，追加为2
     */
    private Integer sort;

    /**
     * 图片1
     */
    private String pictureUrlOne;

    /**
     * 图片2
     */
    private String pictureUrlTwo;

    /**
     * 图片3
     */
    private String pictureUrlThree;

    /**
     * 图片4
     */
    private String pictureUrlFour;

    /**
     * 图片5
     */
    private String pictureUrlFive;

    /**
     * 图片6
     */
    private String pictureUrlSix;

    /**
     * 评论内容
     */
    private String content;

    /**
     * t_shop_review
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID，商品评价
     * @return ID 主键ID，商品评价
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID，商品评价
     * @param id 主键ID，商品评价
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 创建时间
     * @return CREATE_DATE 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 商品项目编号
     * @return item_no 商品项目编号
     */
    public Long getItemNo() {
        return itemNo;
    }

    /**
     * 商品项目编号
     * @param itemNo 商品项目编号
     */
    public void setItemNo(Long itemNo) {
        this.itemNo = itemNo;
    }

    /**
     * 会员ID
     * @return member_id 会员ID
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * 会员ID
     * @param memberId 会员ID
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * 评分，1到5分
     * @return mark 评分，1到5分
     */
    public Double getMark() {
        return mark;
    }

    /**
     * 评分，1到5分
     * @param mark 评分，1到5分
     */
    public void setMark(Double mark) {
        this.mark = mark;
    }

    /**
     * 排序，首评序号为1，追加为2
     * @return sort 排序，首评序号为1，追加为2
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序，首评序号为1，追加为2
     * @param sort 排序，首评序号为1，追加为2
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 图片1
     * @return picture_url_one 图片1
     */
    public String getPictureUrlOne() {
        return pictureUrlOne;
    }

    /**
     * 图片1
     * @param pictureUrlOne 图片1
     */
    public void setPictureUrlOne(String pictureUrlOne) {
        this.pictureUrlOne = pictureUrlOne == null ? null : pictureUrlOne.trim();
    }

    /**
     * 图片2
     * @return picture_url_two 图片2
     */
    public String getPictureUrlTwo() {
        return pictureUrlTwo;
    }

    /**
     * 图片2
     * @param pictureUrlTwo 图片2
     */
    public void setPictureUrlTwo(String pictureUrlTwo) {
        this.pictureUrlTwo = pictureUrlTwo == null ? null : pictureUrlTwo.trim();
    }

    /**
     * 图片3
     * @return picture_url_three 图片3
     */
    public String getPictureUrlThree() {
        return pictureUrlThree;
    }

    /**
     * 图片3
     * @param pictureUrlThree 图片3
     */
    public void setPictureUrlThree(String pictureUrlThree) {
        this.pictureUrlThree = pictureUrlThree == null ? null : pictureUrlThree.trim();
    }

    /**
     * 图片4
     * @return picture_url_four 图片4
     */
    public String getPictureUrlFour() {
        return pictureUrlFour;
    }

    /**
     * 图片4
     * @param pictureUrlFour 图片4
     */
    public void setPictureUrlFour(String pictureUrlFour) {
        this.pictureUrlFour = pictureUrlFour == null ? null : pictureUrlFour.trim();
    }

    /**
     * 图片5
     * @return picture_url_five 图片5
     */
    public String getPictureUrlFive() {
        return pictureUrlFive;
    }

    /**
     * 图片5
     * @param pictureUrlFive 图片5
     */
    public void setPictureUrlFive(String pictureUrlFive) {
        this.pictureUrlFive = pictureUrlFive == null ? null : pictureUrlFive.trim();
    }

    /**
     * 图片6
     * @return picture_url_six 图片6
     */
    public String getPictureUrlSix() {
        return pictureUrlSix;
    }

    /**
     * 图片6
     * @param pictureUrlSix 图片6
     */
    public void setPictureUrlSix(String pictureUrlSix) {
        this.pictureUrlSix = pictureUrlSix == null ? null : pictureUrlSix.trim();
    }

    /**
     * 评论内容
     * @return content 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 评论内容
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TShopReview other = (TShopReview) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getItemNo() == null ? other.getItemNo() == null : this.getItemNo().equals(other.getItemNo()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getMark() == null ? other.getMark() == null : this.getMark().equals(other.getMark()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getPictureUrlOne() == null ? other.getPictureUrlOne() == null : this.getPictureUrlOne().equals(other.getPictureUrlOne()))
            && (this.getPictureUrlTwo() == null ? other.getPictureUrlTwo() == null : this.getPictureUrlTwo().equals(other.getPictureUrlTwo()))
            && (this.getPictureUrlThree() == null ? other.getPictureUrlThree() == null : this.getPictureUrlThree().equals(other.getPictureUrlThree()))
            && (this.getPictureUrlFour() == null ? other.getPictureUrlFour() == null : this.getPictureUrlFour().equals(other.getPictureUrlFour()))
            && (this.getPictureUrlFive() == null ? other.getPictureUrlFive() == null : this.getPictureUrlFive().equals(other.getPictureUrlFive()))
            && (this.getPictureUrlSix() == null ? other.getPictureUrlSix() == null : this.getPictureUrlSix().equals(other.getPictureUrlSix()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getItemNo() == null) ? 0 : getItemNo().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getMark() == null) ? 0 : getMark().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getPictureUrlOne() == null) ? 0 : getPictureUrlOne().hashCode());
        result = prime * result + ((getPictureUrlTwo() == null) ? 0 : getPictureUrlTwo().hashCode());
        result = prime * result + ((getPictureUrlThree() == null) ? 0 : getPictureUrlThree().hashCode());
        result = prime * result + ((getPictureUrlFour() == null) ? 0 : getPictureUrlFour().hashCode());
        result = prime * result + ((getPictureUrlFive() == null) ? 0 : getPictureUrlFive().hashCode());
        result = prime * result + ((getPictureUrlSix() == null) ? 0 : getPictureUrlSix().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createDate=").append(createDate);
        sb.append(", itemNo=").append(itemNo);
        sb.append(", memberId=").append(memberId);
        sb.append(", mark=").append(mark);
        sb.append(", sort=").append(sort);
        sb.append(", pictureUrlOne=").append(pictureUrlOne);
        sb.append(", pictureUrlTwo=").append(pictureUrlTwo);
        sb.append(", pictureUrlThree=").append(pictureUrlThree);
        sb.append(", pictureUrlFour=").append(pictureUrlFour);
        sb.append(", pictureUrlFive=").append(pictureUrlFive);
        sb.append(", pictureUrlSix=").append(pictureUrlSix);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}