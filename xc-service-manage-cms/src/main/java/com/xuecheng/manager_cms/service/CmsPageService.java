package com.xuecheng.manager_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsCode;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.exception.CustomException;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manager_cms.dao.CmsPageRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: houyong
 * @Date: 2019/3/3 12:16
 * @describe
 */
@Service
public class CmsPageService {
    @Resource
    public CmsPageRepository cmsPageRepository;

    public QueryResponseResult findAll(Integer page, Integer size, QueryPageRequest queryPageRequest) {
        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 20;
        }
        ExampleMatcher matcher = ExampleMatcher.matching();
        matcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        CmsPage cmsPage = new CmsPage();
        /*cmsPage.setSiteId(queryPageRequest.getSiteId());
        cmsPage.setPageAliase(queryPageRequest.getPageAliase());*/
        Example<CmsPage> example = Example.of(cmsPage, matcher);
        Pageable pageable = new PageRequest(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(all.getContent());
        queryResult.setTotal(all.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    public CmsPageResult add(CmsPage cmsPage) {
        String siteId = cmsPage.getSiteId();
        String pageName = cmsPage.getPageName();
        String pageWebPath = cmsPage.getPageWebPath();
        //校验该网站是否存在
        CmsPage cmsPageBy = cmsPageRepository.findBySiteIdAndPageNameAndPageWebPath(siteId, pageName, pageWebPath);
        if (cmsPageBy != null) {
            throw new CustomException(CmsCode.CMS_ADDPAGE_EXISTSNAME);
        }
        CmsPage cm = cmsPageRepository.save(cmsPage);
        return new CmsPageResult(CommonCode.SUCCESS, cmsPage);
    }
}
