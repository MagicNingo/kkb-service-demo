package com.kkb.demo;

import com.kkb.hk.DemoApplication;
import com.kkb.hk.dao.HkBannerDao;
import com.kkb.hk.entity.HkBanner;
import com.kkb.hk.service.HkBannerService;
import com.kkb.hk.vo.request.banner.HkBannerRequest;
import com.kkb.hk.vo.response.banner.HkBannerResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.*;

/**
 * @Description
 * @Date 2021/9/25 9:27
 * @Created 30500
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class StoryTest {


    @Autowired
    private HkBannerDao bannerDao;
    @Autowired
    private HkBannerService service;

    @Test
    public void testQuery() {
        HkBannerRequest request = new HkBannerRequest();
        request.setTitle("Jack");
        List<HkBannerResponse> list = bannerDao.qryList(request);
        for (HkBannerResponse bannerResponse : list) {
            System.out.println(bannerResponse);
        }
    }
    @Test
    public void testDel() {
        HkBannerRequest request = new HkBannerRequest();
        request.setBannerId(2);
        Integer i = bannerDao.delHkBannerById(request);
        System.out.println(i);
    }
    @Test
    public void testAdd() {
        HkBanner banner = new HkBanner();
        banner.setBannerId(2);
        banner.setTitle("lili");
        banner.setImage("123");
        banner.setCreatedTime(new Date());
        banner.setSort(1);
        Integer i = bannerDao.addHkBanner(banner);
        System.out.println(i);
    }
    @Test
    public void testUp() {
        HkBanner banner = new HkBanner();
        banner.setBannerId(2);
        banner.setTitle("lili");
        banner.setImage("345");
        banner.setCreatedTime(new Date());
        banner.setSort(1);
        Integer i = bannerDao.modHkBannerById(banner);
        System.out.println(i);
    }
    @Test
    public void testQryOne() {
        HkBannerRequest request = new HkBannerRequest();
        request.setBannerId(1);
        HkBannerResponse bannerResponse = bannerDao.qryOneById(request);
        System.out.println(bannerResponse);
    }

    @Test
    public void testServiceQryOne() {
        HkBannerRequest request = new HkBannerRequest();
        request.setBannerId(2);
        Integer id = service.delHkBannerById(request);
        System.out.println(id);
    }



}
