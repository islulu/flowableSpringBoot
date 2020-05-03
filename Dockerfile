FROM mysql/mysql-server
ENV INIT_SQL init.sql
ENV AUTO_RUN_DIR ./docker-entrypoint-initdb.d

COPY ./$INIT_SQL $AUTO_RUN_DIR/
