-- begin SAMPLE_ORDER_LINE
create table SAMPLE_ORDER_LINE (
    ORDER_LINK varchar(36),
    PRODUCT_CODE varchar(10),
    --
    QUANTITY integer,
    --
    primary key (ORDER_LINK, PRODUCT_CODE)
)^
-- end SAMPLE_ORDER_LINE
-- begin SAMPLE_PRODUCT
create table SAMPLE_PRODUCT (
    PROD_CODE varchar(10) not null,
    --
    NAME varchar(255),
    DESCRIPTION longvarchar,
    PRICE decimal(19, 2),
    --
    primary key (PROD_CODE)
)^
-- end SAMPLE_PRODUCT
-- begin SAMPLE_ORDER
create table SAMPLE_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    AMOUNT decimal(19, 2),
    --
    primary key (ID)
)^
-- end SAMPLE_ORDER
