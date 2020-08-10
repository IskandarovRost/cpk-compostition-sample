package com.company.sample.web.screens.orderline;

import com.haulmont.cuba.gui.screen.*;
import com.company.sample.entity.OrderLine;

@UiController("sample_OrderLine.browse")
@UiDescriptor("order-line-browse.xml")
@LookupComponent("orderLinesTable")
@LoadDataBeforeShow
public class OrderLineBrowse extends StandardLookup<OrderLine> {
}