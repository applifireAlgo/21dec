




echo $PATH
DB_PATH=/tmp/applifire/db/ZQPQWXV5D3UBRQGUKYXHG/18D01ABF-F632-496A-B379-FC50EDEAB8C0
MYSQL=/usr/bin
USER=dec22
PASSWORD=dec22
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'