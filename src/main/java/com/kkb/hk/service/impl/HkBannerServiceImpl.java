package com.kkb.hk.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkb.hk.dao.HkBannerDao;
import com.kkb.hk.entity.HkBanner;
import com.kkb.hk.entity.page.PageResult;
import com.kkb.hk.service.HkBannerService;
import com.kkb.hk.utils.PageUtils;
import com.kkb.hk.utils.StringUtils;
import com.kkb.hk.vo.request.banner.HkBannerRequest;
import com.kkb.hk.vo.response.banner.HkBannerResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className HkBannerServiceImpl
 * @description:  banner表(HkBanner)表服务实现类
 * @author Allen
 * @date 2021/12/16 15:57
 */
@Service("hkBannerService")
public class HkBannerServiceImpl implements HkBannerService {
    @Resource
    private HkBannerDao hkBannerDao;
    private HkBannerRequest request = new HkBannerRequest();

    /**
     * @description:  查询banner列表
     * @param: [hkBannerRequest]
     * @return: java.util.List<com.kkb.hk.vo.response.banner.HkBannerResponse>
     * @author Allen
     * @date: 2021/12/16 19:29
     */
    @Override
    public List<HkBannerResponse> qryList(HkBannerRequest hkBannerRequest) {
        //此处代码需要先从redis中获取，获取不到则取查数据库
        String historyJsON = null;

        if (StringUtils.isEmpty(historyJsON)) {
            //缓存中没有数据，查询数据库
            List<HkBannerResponse> list = hkBannerDao.qryList(hkBannerRequest);
            //此处代码需要把查出来的结果set redis缓存
            return list;
        }
        List<HkBannerResponse> list = JSON.parseObject(historyJsON, new TypeReference<List<HkBannerResponse>>() {});
        return list;
    }

    /**
     * @description:  查询banner列表分页查询
     * @param: [hkBannerRequest]
     * @return: com.kkb.hk.entity.page.PageResult
     * @author Allen
     * @date: 2021/12/16 17:48
     */
    @Override
    public PageResult qryListByPage(HkBannerRequest hkBannerRequest) {
        int pageNum = hkBannerRequest.getPageNum();
        int pageSize = hkBannerRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<HkBannerResponse> responseList = this.hkBannerDao.qryListByPage(hkBannerRequest);
        return PageUtils.getPageResult(new PageInfo<HkBannerResponse>(responseList));
    }

    /**
     * @description: 添加banner列表数据
     * @param: hkBannerRequest
     * @return: java.lang.Integer
     * @author NingYueFeng
     * @date: 2021/12/22 15:27
     */
    @Override
    public Integer addHkBanner(HkBanner banner) {
        request.setBannerId(banner.getBannerId());
        //判断需要新增的banner是否已经存在于数据库
        if (hkBannerDao.qryOneById(request) == null) {
            //如果不存在则允许添加
            return hkBannerDao.addHkBanner(banner);
        }
        return null;
    }

    /**
     * @description: 删除banner列表数据
     * @param: hkBannerRequest
     * @return: java.lang.Integer
     * @author NingYueFeng
     * @date: 2021/12/22 15:27
     */
    @Override
    public Integer delHkBannerById(HkBannerRequest hkBannerRequest) {
        //判断需要新增的banner是否已经存在于数据库
        if (hkBannerDao.qryOneById(hkBannerRequest) != null){
            //如果存在则允许删除
            return hkBannerDao.delHkBannerById(hkBannerRequest);
        }
        return null;
    }

    /**
     * @description: 更新banner列表数据
     * @param: hkBannerRequest
     * @return: java.lang.Integer
     * @author NingYueFeng
     * @date: 2021/12/22 15:27
     */
    @Override
    public Integer modHkBannerById(HkBanner banner) {
        request.setBannerId(banner.getBannerId());
        //判断需要新增的banner是否已经存在于数据库
        if (hkBannerDao.qryOneById(request) == null) {
            //如果存在则允许修改
            return hkBannerDao.modHkBannerById(banner);
        }
        return null;
    }

}
