-- Table: public.bag

DROP TABLE IF EXISTS public.bag;

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