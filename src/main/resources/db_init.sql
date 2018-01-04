--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE orders (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    total integer
);


ALTER TABLE orders OWNER TO postgres;

--
-- Name: order_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE order_id_seq OWNER TO postgres;

--
-- Name: order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE order_id_seq OWNED BY orders.id;


--
-- Name: seat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE seat (
    id bigint NOT NULL,
    number integer,
    price integer,
    reserved boolean DEFAULT false,
    seat_row integer,
    order_id bigint
);


ALTER TABLE seat OWNER TO postgres;

--
-- Name: seat_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE seat_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE seat_id_seq OWNER TO postgres;

--
-- Name: seat_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE seat_id_seq OWNED BY seat.id;


--
-- Name: orders id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders ALTER COLUMN id SET DEFAULT nextval('order_id_seq'::regclass);


--
-- Name: seat id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY seat ALTER COLUMN id SET DEFAULT nextval('seat_id_seq'::regclass);


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Data for Name: seat; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (28, 3, 40, false, 6, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (18, 3, 80, false, 4, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (19, 4, 80, false, 4, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (2, 2, 50, false, 1, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (3, 3, 50, false, 1, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (4, 4, 50, false, 1, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (7, 2, 50, false, 2, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (9, 4, 50, false, 2, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (21, 1, 40, false, 5, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (6, 1, 50, false, 2, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (25, 5, 40, false, 5, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (15, 5, 80, false, 3, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (17, 2, 80, false, 4, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (30, 5, 40, false, 6, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (27, 2, 40, false, 6, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (20, 5, 80, false, 4, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (16, 1, 80, false, 4, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (29, 4, 40, false, 6, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (11, 1, 80, false, 3, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (26, 1, 40, false, 6, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (10, 5, 50, false, 2, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (8, 3, 50, false, 2, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (1, 1, 50, false, 1, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (24, 4, 40, false, 5, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (12, 2, 80, false, 3, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (22, 2, 40, false, 5, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (14, 4, 80, false, 3, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (23, 3, 40, false, 5, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (13, 3, 80, false, 3, NULL);
INSERT INTO seat (id, number, price, reserved, seat_row, order_id) VALUES (5, 5, 50, false, 1, NULL);


--
-- Name: order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('order_id_seq', 1, false);


--
-- Name: seat_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('seat_id_seq', 30, true);


--
-- Name: orders order_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT order_pkey PRIMARY KEY (id);


--
-- Name: seat seat_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY seat
    ADD CONSTRAINT seat_pkey PRIMARY KEY (id);


--
-- Name: seat fk8vypjisvjd3p1ecpwymeq95wu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY seat
    ADD CONSTRAINT fk8vypjisvjd3p1ecpwymeq95wu FOREIGN KEY (order_id) REFERENCES orders(id);


--
-- PostgreSQL database dump complete
--

