
import {openDb} from './configdb.js'
import { createTable, deletePessoa, insertPessoa, updatePessoa } from './Controller/Pessoa.js';
import express from 'express'
//const express = require('express');
const app = express();
app.use(express.json());

createTable();

app.get('/', function(req, res) {
    res.send('hello world');
})

app.post('/pessoa', function(req,  res) {
    //console.log('test')
    insertPessoa(req.body);
    res.json({
        'statuscode': 200
    })
});

app.put('/pessoa', function(req,  res) {
    if (req.body && !req.body.id) {
        res.json({
            "statusCode": "400",
            "msg": "obrigatorio informar id"
        })
    } else {
        updatePessoa(req.body);
        res.json({
            'statuscode': 200
        })
    }  
});

app.delete('/pessoa', async function(req, res) {
    let pessoa = await deletePessoa(req.body.id);
    res.json(pessoa);
});

app.listen(3000, ()=> console.log('api rodando'));