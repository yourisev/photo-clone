create table if not exists photo(
    id identity primary key,
    file_name varchar(255),
    content_type varchar(255),
    data_ binary large object
);