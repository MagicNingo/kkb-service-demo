package com.kkb.hk.vo.request.banner;

import com.kkb.hk.entity.page.PageRequest;
import lombok.Data;

import java.util.Date;

/**
 * @className HkBannerRequest
 * @description:banner请求参数
 * @author Allen
 * @date 2021/12/16 15:44
 */
@Data
public class HkBannerRequest extends PageRequest {
    /**
     * 编号
     */
    private Integer bannerId;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 封面
     */
    private String image;
    /**
     * 跳转地址
     */
    private String url;
    /**
     * 状态;0=上架 1=下架 2=删除
     */
    private Integer status;
    /**
     * 顺序;越小越靠前
     */
    private Integer sort;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updatedBy;
    /**
     * 更新时间
     */
    private Date updatedTime;
}
