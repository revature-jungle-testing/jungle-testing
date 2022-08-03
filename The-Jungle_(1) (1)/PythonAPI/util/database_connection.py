import os

from psycopg import connect, OperationalError


def create_connection():
    try:
        conn = connect(
            host="thejungle.cgg7cg1eomrq.us-east-1.rds.amazonaws.com",
            dbname="TheJungle",
            user="postgres",
            password="password",
            port="5432"
        )
        return conn
    except OperationalError as e:
        print(str(e))


connection = create_connection()
print(connection)
