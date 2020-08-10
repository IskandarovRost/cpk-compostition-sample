package com.company.sample.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import com.company.sample.entity.Order;

@UiController("sample_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {
}