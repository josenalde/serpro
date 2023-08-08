# no terminal instalar psycopg (adapter, conector)
# conda install psycopg2

import psycopg2 as psql
try:
    conn = psql.connect(host='localhost', database='serprodb',
                        user='postgress', password='postgres')
except Exception as e:
    print(f'Erro: {e}')

"""
cursor = conn.cursor()
sql = 'create table if not exists cidade (id serial primary key, nome varchar(100), uf varchar(2))'
cursor.execute(sql)
sql = "insert into cidade values (default, 'Natal', 'RN')"
cursor.execute(sql)
conn.commit()
cursor.execute('select * from cidade')
rset = cursor.fetchall()
for r in rset:
    print(r)
conn.close()
"""
