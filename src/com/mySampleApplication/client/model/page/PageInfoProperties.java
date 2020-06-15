package com.mySampleApplication.client.model.page;


import com.mySampleApplication.client.dto.PageInfoDTO;
import com.sencha.gxt.core.client.ValueProvider;

public interface PageInfoProperties {

    ValueProvider<PageInfoDTO, String> totalNum();
    ValueProvider<PageInfoDTO, String> currentPage();
    ValueProvider<PageInfoDTO, String> pageSize();
    ValueProvider<PageInfoDTO, String> totalPage();
}
