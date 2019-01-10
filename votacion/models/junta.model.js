require('./institucion.model');

var mongoose = require('mongoose');
var Institucion = mongoose.model('Institucion');

var Schema = mongoose.Schema;

var junta = new Schema({
    numero: {
        type: String,
        required: true
    },
    tipo: {
        type: String,
        required: true
    },
    institucion: {
        type: mongoose.Schema.Types.ObjectId, 
        ref: 'Institucion'
    },
    created: { 
        type: Date,
        default: Date.now
    }
});

module.exports = mongoose.model('Junta', junta);