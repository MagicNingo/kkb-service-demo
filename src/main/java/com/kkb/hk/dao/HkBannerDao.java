package com.kkb.hk.dao;

import com.kkb.hk.entity.HkBanner;
import com.kkb.hk.vo.request.banner.HkBannerRequest;
import com.kkb.hk.vo.response.banner.HkBannerResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className HkBannerDao
 * @description:  表(HkBanner)表数据库访问层
 * @author Allen
 * @date 2021/12/16 15:49
 */
@Mapper
public interface HkBannerDao {

    /**
     * @description:查询banner列表
     * @param: [hkBannerRequest]
     * @return: java.util.List<com.kkb.hk.vo.response.banner.HkBannerResponse>
     * @author Allen
     * @date: 2021/12/16 16:25
     */
    List<HkBannerResponse> qryList(HkBannerRequest hkBannerRequest);

    /**
     * @description:查询banner列表分页查询
     * @param: [hkBannerRequest]
     * @return: java.util.List<com.kkb.hk.vo.response.banner.HkBannerResponse>
     * @author Allen
     * @date: 2021/12/16 16:27
     */
    List<HkBannerResponse> qryListByPage(HkBannerRequest hkBannerRequest);

    /**
     * @description:查询banner列表单个数据
     * @param: hkBannerRequest
     * @return: HkBannerResponse<com.kkb.hk.vo.response.banner.HkBannerResponse>
     * @author NingYueFeng
     * @date: 2021/12/22 15:27
     */
    HkBannerResponse qryOneById(HkBannerRequest hkBannerRequest);

    /**
     * @description: 添加banner列表数据
     * @param: hkBannerRequest
     * @return: java.lang.Integer
     * @author NingYueFeng
     * @date: 2021/12/22 15:27
     */
    Integer addHkBanner(HkBanner banner);

    /**
     * @description: 删除banner列表数据
     * @param: hkBannerRequest
     * @return: java.lang.Integer
     * @author NingYueFeng
     * @date: 2021/12/22 15:27
     */
    Integer delHkBannerById(HkBannerRequest hkBannerRequest);

    /**
     * @description: 更新banner列表数据
     * @param: hkBannerRequest
     * @return: java.lang.Integer
     * @author NingYueFeng
     * @date: 2021/12/22 15:27
     */
    Integer modHkBannerById(HkBanner banner);


}

