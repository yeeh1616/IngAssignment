-- Database: ing01

-- DROP DATABASE IF EXISTS ing01;

CREATE DATABASE ing01
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Table: public.bag

-- DROP TABLE IF EXISTS public.bag;

CREATE TABLE IF NOT EXISTS public.bag
(
    id uuid NOT NULL,
    applenum integer NOT NULL DEFAULT 1,
    supplier integer NOT NULL,
    "time" date NOT NULL,
    price integer NOT NULL DEFAULT 1,
    CONSTRAINT bag_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.bag
    OWNER to postgres;