package com.company.sample.web.screens.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.sample.entity.Product;

@UiController("sample_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class ProductBrowse extends MasterDetailScreen<Product> {
}