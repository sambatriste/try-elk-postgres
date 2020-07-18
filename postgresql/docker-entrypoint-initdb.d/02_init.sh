set -eu
psql -U postgres -d postgres -c "copy zipcode from '/docker-entrypoint-initdb.d/KEN_ALL.CSV' with csv encoding 'shift_jis'";
