CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS store (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4 (),
    name VARCHAR(255) NOT NULL,
    cnpj VARCHAR(14) NOT NULL,
    address VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unique_cnpj UNIQUE (cnpj)
);

CREATE TABLE IF NOT EXISTS brand (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unique_brand_name UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS product_category (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    parent_id UUID REFERENCES product_category(id),
    CONSTRAINT unique_product_category_name UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS product_group (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    category_id UUID REFERENCES product_category(id),
    CONSTRAINT unique_product_group_name UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS product (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    sku VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    best_price DECIMAL(10, 2) NOT NULL,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    best_price_store_id UUID REFERENCES store(id),
    brand_id UUID REFERENCES brand(id),
    group_id UUID REFERENCES product_group(id),
    CONSTRAINT unique_sku UNIQUE (sku)
);

CREATE TABLE IF NOT EXISTS price (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    price DECIMAL(10, 2) NOT NULL,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    product_id UUID NOT NULL REFERENCES product(id),
    store_id UUID NOT NULL REFERENCES store(id)
);

CREATE TABLE IF NOT EXISTS invoice (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    total DECIMAL(10, 2) NOT NULL,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    store_id UUID NOT NULL REFERENCES store(id)
);

CREATE TABLE IF NOT EXISTS invoice_products (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    price DECIMAL(10, 2) NOT NULL,
    quantity DECIMAL(10, 3) NOT NULL,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    invoice_id UUID NOT NULL REFERENCES invoice(id),
    product_id UUID NOT NULL REFERENCES product(id)
);