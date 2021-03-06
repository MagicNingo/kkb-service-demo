package com.kkb.hk.service;

import com.kkb.hk.entity.HkBanner;
import com.kkb.hk.entity.page.PageResult;
import com.kkb.hk.vo.request.banner.HkBannerRequest;
import com.kkb.hk.vo.response.banner.HkBannerResponse;

import java.util.List;

/**
 * @className HkBannerService
 * @description:  表(HkBanner)表服务接口
 * @author Allen
 * @date 2021/12/16 15:56
 */
public interface HkBannerService {

    /**
     * @description:  查询banner列表
     * @param: [hkBannerRequest]
     * @return: java.util.List<com.kkb.hk.vo.response.banner.HkBannerResponse>
     * @author Allen
     * @date: 2021/12/16 16:23
     */
    List<HkBannerResponse> qryList(HkBannerRequest hkBannerRequest);

    /**
     * @description:  查询banner列表分页查询
     * @param: [hkBannerRequest]
     * @return: com.kkb.hk.entity.page.PageResult
     * @author Allen
     * @date: 2021/12/16 16:23
     */
    PageResult qryListByPage(HkBannerRequest hkBannerRequest);

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
