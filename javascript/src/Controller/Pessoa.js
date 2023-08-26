import { openDb } from '../configdb.js';

export async function createTable() {
    openDb().then(db=> {
        db.exec('create table if not exists Pessoa (id INTEGER PRIMARY KEY, nome TEXT, idade INTEGER)');
    })
}

export async function insertPessoa(pessoa) {
    openDb().then(db=> {
        db.run('insert into Pessoa (nome, idade) values (?,?)', [pessoa.nome, pessoa.idade]);
    })
}

export async function updatePessoa(pessoa) {
    openDb().then(db=> {
        db.run('UPDATE Pessoa SET nome=?, idade=? WHERE id=?', [pessoa.nome, pessoa.idade, pessoa.id]);
    })
}

export async function deletePessoa(id) {
    openDb().then(db=> {
        db.run('DELETE from Pessoa WHERE id=?', id);
    })
}