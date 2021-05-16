---- DATABASE DDL  !!!!!!!!!!!!!!!!!!!!!----------
CREATE DATABASE hrms
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Turkish_Turkey.1254'
    LC_CTYPE = 'Turkish_Turkey.1254'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE hrms
    IS 'Human Resource Management System Database';
	
----------------------------------------------------




CREATE TABLE public.users
(
    user_id integer NOT NULL DEFAULT nextval('users_user_id_seq'::regclass),
    email character varying(100) COLLATE pg_catalog."default" NOT NULL,
    msisdn character(10) COLLATE pg_catalog."default" NOT NULL,
    password character varying(40) COLLATE pg_catalog."default" NOT NULL,
    cdate timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    udate timestamp without time zone,
    CONSTRAINT pk_users PRIMARY KEY (user_id),
    CONSTRAINT uk_users_email UNIQUE (email),
    CONSTRAINT uk_users_msisdn UNIQUE (msisdn)
)

TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;
	
	
CREATE TABLE public.system_employees
(
    user_id integer NOT NULL DEFAULT nextval('system_employees_user_id_seq'::regclass),
    first_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    cdate timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    udate timestamp without time zone,
    CONSTRAINT pk_system_users PRIMARY KEY (user_id),
    CONSTRAINT fk_system_users_users FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.system_employees
    OWNER to postgres;
	
	
	
CREATE TABLE public.job_positions
(
    job_position_id integer NOT NULL DEFAULT nextval('job_positions_job_position_id_seq'::regclass),
    job_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    cdate timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    udate timestamp without time zone,
    CONSTRAINT job_positions_pkey PRIMARY KEY (job_position_id)
)

TABLESPACE pg_default;

ALTER TABLE public.job_positions
    OWNER to postgres;



CREATE TABLE public.employers_activation_by_system_employees
(
    id integer NOT NULL DEFAULT nextval('employers_activation_by_system_employees_id_seq'::regclass),
    employer_id integer NOT NULL,
    system_employee_id integer NOT NULL,
    is_confirmed boolean NOT NULL,
    confirmation_date timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_employers_activation_by_system_employees PRIMARY KEY (id),
    CONSTRAINT fk_employers_activation_by_system_employees_employers FOREIGN KEY (employer_id)
        REFERENCES public.employers (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT fk_employers_activation_by_system_employees_system_employees FOREIGN KEY (system_employee_id)
        REFERENCES public.system_employees (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE public.employers_activation_by_system_employees
    OWNER to postgres;



CREATE TABLE public.employers
(
    user_id integer NOT NULL DEFAULT nextval('employers_user_id_seq'::regclass),
    company_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    website character varying(100) COLLATE pg_catalog."default" NOT NULL,
    cdate timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    udate timestamp without time zone,
    CONSTRAINT pk_employers PRIMARY KEY (user_id),
    CONSTRAINT fk_employers_users FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.employers
    OWNER to postgres;


CREATE TABLE public.candidates
(
    user_id integer NOT NULL DEFAULT nextval('candidates_user_id_seq'::regclass),
    first_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    nat_id character(11) COLLATE pg_catalog."default" NOT NULL,
    birth_date date NOT NULL,
    cdate timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    udate timestamp without time zone,
    CONSTRAINT pk_candidates PRIMARY KEY (user_id),
    CONSTRAINT uk_candidates_nat_id UNIQUE (nat_id),
    CONSTRAINT fk_candidates_users FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.candidates
    OWNER to postgres;



CREATE TABLE public.activation_codes_candidates
(
    activation_code_id integer NOT NULL DEFAULT nextval('activation_codes_candidates_activation_code_id_seq'::regclass),
    candidate_id integer NOT NULL,
    CONSTRAINT pk_activation_code_candidates PRIMARY KEY (activation_code_id),
    CONSTRAINT fk_activation_code_candidates_activation_codes FOREIGN KEY (activation_code_id)
        REFERENCES public.activation_codes (activation_code_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT fk_activation_code_candidates_candidates FOREIGN KEY (candidate_id)
        REFERENCES public.candidates (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE public.activation_codes_candidates
    OWNER to postgres;


CREATE TABLE public.activation_codes
(
    activation_code_id integer NOT NULL DEFAULT nextval('activation_codes_activation_code_id_seq'::regclass),
    activtion_code character varying(20) COLLATE pg_catalog."default" NOT NULL,
    is_confirmed boolean NOT NULL,
    cdate timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    udate timestamp without time zone,
    CONSTRAINT activation_codes_pkey PRIMARY KEY (activation_code_id)
)

TABLESPACE pg_default;

ALTER TABLE public.activation_codes
    OWNER to postgres;




CREATE TABLE public.activation_code_employers
(
    activation_code_id integer NOT NULL DEFAULT nextval('activation_code_employers_activation_code_id_seq'::regclass),
    employer_id integer NOT NULL,
    CONSTRAINT pk_activation_code_employers PRIMARY KEY (activation_code_id),
    CONSTRAINT fk_activation_code_employers_activation_codes FOREIGN KEY (activation_code_id)
        REFERENCES public.activation_codes (activation_code_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
        NOT VALID,
    CONSTRAINT fk_activation_code_employers_employers FOREIGN KEY (employer_id)
        REFERENCES public.employers (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.activation_code_employers
    OWNER to postgres;	
	
	
	
