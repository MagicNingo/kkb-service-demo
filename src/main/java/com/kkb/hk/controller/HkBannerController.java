package com.kkb.hk.controller;

import com.kkb.hk.entity.HkBanner;
import com.kkb.hk.service.HkBannerService;
import com.kkb.hk.utils.ReqResultUtil;
import com.kkb.hk.vo.request.banner.HkBannerRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @className HkBannerController
 * @description:banner接口层
 * @author Allen
 * @date 2021/12/16 15:48
 */
@RestController
@RequestMapping("hkBanner")
@Slf4j
public class HkBannerController {


    @Resource
    private HkBannerService hkBannerService;

    /**
     * @description:  查询banner列表
     * @param: []
     * @return: org.springframework.http.ResponseEntity<java.lang.String>
     * @author Allen
     * @date: 2021/12/16 15:48
     */
    @RequestMapping(value = "/qryList", method = RequestMethod.POST)
    public ResponseEntity<String> qryList(HkBannerRequest hkBannerRequest) {
        log.info("进入banner列表接口");
        log.info("开始");
        return ReqResultUtil.genSuccessResultResponse(hkBannerService.qryList(hkBannerRequest));

    }

    /**
     * @description:分页查询banner列表
     * @param: [hkBannerRequest]
     * @return: org.springframework.http.ResponseEntity<java.lang.String>
     * @author Allen
     * @date: 2021/12/16 18:53
     */
    @RequestMapping(value = "/qryListByPage", method = RequestMethod.POST)
    public ResponseEntity<String> qryListByPage(HkBannerRequest hkBannerRequest) {
        log.info("进入banner列表接口");
        return ReqResultUtil.genSuccessResultResponse(hkBannerService.qryListByPage(hkBannerRequest));
    }

    /**
     * @description:添加banner列表数据
     * @param: [banner]
     * @return:java.lang.Integer
     * @author NingYueFeng
     * @date: 2021/12/22 15:27
     */
    @RequestMapping(value = "/addHKBanner", method = RequestMethod.POST)
    public Integer addHKBanner(HkBanner banner) {
        log.info("进入banner列表接口");
        return hkBannerService.addHkBanner(banner);
    }

    /**
     * @description:删除anner列表数据
     * @param: [hkBannerRequest]
     * @return:java.lang.Integer
     * @author NingYueFeng
     * @date: 2021/12/22 15:27
     */
    @RequestMapping(value = "/delHKBanner", method = RequestMethod.POST)
    public Integer delHKBanner(HkBannerRequest hkBannerRequest) {
        log.info("进入banner列表接口");
        return hkBannerService.delHkBannerById(hkBannerRequest);
    }

    /**
     * @description:修改banner列表数据
     * @param: [banner]
     * @return:java.lang.Integer
     * @author NingYueFeng
     * @date: 2021/12/22 15:27
     */
    @RequestMapping(value = "/upHKBanner", method = RequestMethod.POST)
    public Integer upHKBanner(HkBanner banner) {
        log.info("进入banner列表接口");
        return hkBannerService.modHkBannerById(banner);
    }
}

