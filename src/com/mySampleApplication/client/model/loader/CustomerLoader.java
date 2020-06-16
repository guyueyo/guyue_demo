package com.mySampleApplication.client.model.loader;

import com.mySampleApplication.client.model.CustomerInfo;
import com.sencha.gxt.data.shared.loader.*;

public class CustomerLoader extends PagingLoader<PagingLoadConfig, PagingLoadResult<CustomerInfo>> {
    public CustomerLoader(DataProxy<PagingLoadConfig, PagingLoadResult<CustomerInfo>> proxy) {
        super(proxy);
    }
    @Override
    public void loadData(PagingLoadConfig config) {
        super.loadData(config);
    }


}
