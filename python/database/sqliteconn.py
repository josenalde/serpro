import sqlite3  # built-in

# definindo conexão e cursor
conn = sqlite3.connect('store_transactions.db')
cursor = conn.cursor()

# res = cursor.execute("SELECT name FROM sqlite_master")
# print(res.fetchone())

# criar tabela da loja
st_create_table_store = """CREATE TABLE IF NOT EXISTS
stores(store_id INTEGER PRIMARY KEY AUTOINCREMENT, location TEXT)"""

cursor.execute(st_create_table_store)

# criar tabela de compras
st_create_table_purchases = """CREATE TABLE IF NOT EXISTS
purchases(purchase_id INTEGER PRIMARY KEY AUTOINCREMENT, store_id INTEGER, total_cost FLOAT,
FOREIGN KEY(store_id) REFERENCES stores(store_id))"""

# sqlite3 aceita colunas sem tipo, pois é dinâmico
# cursor.execute("CREATE TABLE movie(title, year, score)")

cursor.execute(st_create_table_purchases)

# adicionar lojas
# NULL para AUTOINCREMENT
cursor.execute("INSERT INTO stores VALUES (NULL, 'Natal, RN')")
cursor.execute("INSERT INTO stores VALUES (NULL, 'Parnamirim, RN')")
cursor.execute("INSERT INTO stores VALUES (NULL, 'Currais Novos, RN')")

cursor.execute("INSERT INTO purchases VALUES (NULL, 05, 15.49)")
cursor.execute("INSERT INTO purchases VALUES (NULL, 22, 21.12)")

conn.commit()

cursor.execute("SELECT * FROM purchases")

rset = cursor.fetchall()  # retorna tupla iterável

conn.close()
print(rset)

"""
for row in cur.execute("SELECT year, title FROM movie ORDER BY year"):
    print(row)
(1971, 'And Now for Something Completely Different')
(1975, 'Monty Python and the Holy Grail')
(1979, "Monty Python's Life of Brian")
(1982, 'Monty Python Live at the Hollywood Bowl')
(1983, "Monty Python's The Meaning of Life")
"""

"""
data = [
    ("Monty Python Live at the Hollywood Bowl", 1982, 7.9),
    ("Monty Python's The Meaning of Life", 1983, 7.5),
    ("Monty Python's Life of Brian", 1979, 8.0),
]
cur.executemany("INSERT INTO movie VALUES(?, ?, ?)", data)
con.commit()  # Remember to commit the transaction after executing INSERT.
"""
# comandos sqlite3 _.db no terminal (.table, .exit, .schema <tabela> .select * from ..;)
