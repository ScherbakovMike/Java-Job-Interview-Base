drop table if exists books;
drop table if exists authors;
drop table if exists courses;
drop table if exists author_courses;

create table authors (
    id bigint not null auto_increment,
    name varchar(255),
    primary key (id)
);

create table courses (
    id bigint not null auto_increment,
    name varchar(255),
    author_id bigint,
    primary key (id),
    constraint courses_author_pk FOREIGN KEY (author_id) references authors(id)
);

create table books (
    id bigint not null auto_increment,
    name varchar(255),
    author_id bigint,
    primary key (id),
    constraint books_author_pk FOREIGN KEY (author_id) references authors(id)
);

create table author_courses (
    author_id bigint not null,
    course_id bigint not null,
    primary key (author_id, course_id),
    constraint ac_author_pk FOREIGN KEY (author_id) references authors(id),
    constraint ac_course_pk FOREIGN KEY (course_id) references courses(id)
);
