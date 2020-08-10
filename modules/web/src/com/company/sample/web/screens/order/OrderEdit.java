package com.company.sample.web.screens.order;

import com.company.sample.entity.OrderLine;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.RemoveOperation;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.sample.entity.Order;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

@UiController("sample_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    private Metadata metadata;

    @Inject
    private DataManager dataManager;

    @Inject
    private Table<OrderLine> linesTable;

    @Install(to = "linesTable.create", subject = "newEntitySupplier")
    private OrderLine linesTableCreateNewEntitySupplier() {
        OrderLine ordrline = metadata.create(OrderLine.class);
        ordrline.setOrder(this.getEditedEntity());
        return ordrline;
    }

    @Install(to = "linesTable.remove", subject = "afterActionPerformedHandler")
    private void linesTableRemoveAfterActionPerformedHandler(RemoveOperation.AfterActionPerformedEvent<OrderLine> afterActionPerformedEvent) {
        List<OrderLine> orderLines = afterActionPerformedEvent.getItems();
        for (OrderLine ol : orderLines)
        {
            dataManager.remove(ol);
        }

    }

}