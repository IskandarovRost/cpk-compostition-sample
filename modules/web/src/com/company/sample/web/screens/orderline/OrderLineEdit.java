package com.company.sample.web.screens.orderline;

import com.haulmont.cuba.gui.screen.*;
import com.company.sample.entity.OrderLine;

@UiController("sample_OrderLine.edit")
@UiDescriptor("order-line-edit.xml")
@EditedEntityContainer("orderLineDc")
@LoadDataBeforeShow
public class OrderLineEdit extends StandardEditor<OrderLine> {
}