




echo $PATH
DB_PATH=/tmp/applifire/db/XHXGDWAAHU9LCGFZF4JMZA/2C22EEF3-027E-42C9-8D11-4B593576AC61
MYSQL=/usr/bin
USER=salesdemo
PASSWORD=salesdemo
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'